package com.bawei.library_net.rxjava;

import androidx.lifecycle.LiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * @ClassName LiveDataCallAdapterFactory
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/18 19:53
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    public static LiveDataCallAdapterFactory create(){
        return new LiveDataCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (!(returnType instanceof ParameterizedType)){
            throw new IllegalArgumentException("要求返回值必须是可参数化的(支持泛型)");
        }
        Class<?> rawType = getRawType(returnType);
        if (rawType!=LiveData.class && rawType!=Call.class){
            throw new IllegalArgumentException("返回值类型必须是LiveData或者是Call");
        }
        Type t = getParameterUpperBound(0, (ParameterizedType) returnType);
        if (rawType==Call.class){
            return new DefaultTypeCallAdapter<>(t);
        }else if (rawType==LiveData.class){
            return new LiveDataCallAdapter<>(t);
        }
        return new DefaultTypeCallAdapter<>(t);
    }
}
