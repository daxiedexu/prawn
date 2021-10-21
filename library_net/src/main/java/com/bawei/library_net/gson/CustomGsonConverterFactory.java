package com.bawei.library_net.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * @ClassName CustomGsonConverterFactory
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/19 14:50
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class CustomGsonConverterFactory extends Converter.Factory {
    public static CustomGsonConverterFactory create(){
        return new CustomGsonConverterFactory();
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new CustomResponseBodyConverter<>();
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new CustomRequestBodyConverter<>();
    }
}
