package com.bawei.library_common.net;

import android.text.TextUtils;
import android.util.Log;


import com.bawei.library_common.Bean.TokenRespEntity;
import com.bawei.library_common.api.TokenApi;
import com.bawei.library_common.common.NetConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName RetrofitFactory
 * @Author 孔晨亮
 * @Date 2021/10/14 19:50
 * User: msi
 */
public class RetrofitFactory {
    private volatile static RetrofitFactory retrofitFactory;
    public static RetrofitFactory getRetrofitFactory(){
        if(retrofitFactory  ==  null){
            synchronized (RetrofitFactory.class){
                retrofitFactory = new RetrofitFactory();
            }
        }
        return retrofitFactory;
    }
    private Retrofit retrofit;

    public RetrofitFactory() {
        retrofit=createRetrofit();
    }

    private Retrofit createRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("")
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    /**
     * OkHttpClient
     * @return
     */
    private OkHttpClient createOkHttpClient() {
        OkHttpClient build=new OkHttpClient.Builder( )
                .addInterceptor(createInterceptor())//日志
                .addInterceptor(createNetworkInterceptor())//token
                .addInterceptor(new Retry(3))//重试
                .readTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .writeTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .connectTimeout(NetConfig.TIMEOUT, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)//默认重试一次，若需要重试N次，则要实现拦截器。
                .build( );

        return build;
    }


    /**
     * 判断token
     */
    private String mToken="";
    private Interceptor createNetworkInterceptor() {
        Interceptor interceptor = new Interceptor(){
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request( );
                //获取本地Token
                String localToken = mToken;
                if(!TextUtils.isEmpty(localToken)){
                    return resetRequest(request,localToken,chain);
                }

                Response proceed=chain.proceed(request);

                if(proceed.code()==401){
                    String token=requestToken();
                    if(TextUtils.isEmpty(token)){
                        return proceed;
                    }
                    mToken=token;
                    return resetRequest(request,token,chain);
                }
                return proceed;
            }
        };
        return interceptor;
    }

    private String requestToken() {
        TokenApi tokenApi=create(TokenApi.class);
        Call<TokenRespEntity> password=tokenApi.getToken("password", NetConfig.AUTH_CODE, "");
        try {
            retrofit2.Response<TokenRespEntity> execute=password.execute( );
            if(execute!=null&&execute.body()!=null){
                return execute.body().getAccess_token();
            }
        } catch (IOException e) {
            e.printStackTrace( );

        }
        return null;
    }

    private Response resetRequest(Request request, String localToken, Interceptor.Chain chain) {

        Request authorization=request.newBuilder( ).addHeader("Authorization", "bearer " + localToken).build( );
        try {
            return chain.proceed(authorization);
        } catch (IOException e) {
            e.printStackTrace( );
        }
        return null;
    }


    /**
     * 日志拦截器
     * TokenInterceptor
     * @return
     */
    private Interceptor createInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor( )
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }


    /**
     * 自定义的，重试N次的拦截器
     * 通过：addInterceptor 设置
     */
    public  class Retry implements Interceptor {
        public int maxRetry;//最大重试次数
        private int retryNum = 0;
        public Retry(int maxRetry) {
            this.maxRetry = maxRetry;
        }
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            Log.i("Retry","num:"+retryNum);
            while (!response.isSuccessful() && retryNum < maxRetry) {
                retryNum++;
                Log.i("Retry","num:"+retryNum);
                response = chain.proceed(request);
            }
            return response;
        }
    }


    /**
     * 通过api接口获取到其实例
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service){
        return retrofit.create(service) ;
    }
}
