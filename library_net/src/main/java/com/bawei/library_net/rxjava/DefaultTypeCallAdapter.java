package com.bawei.library_net.rxjava;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;

/**
 * @ClassName DefaultTypeCallAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/19 14:11
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class DefaultTypeCallAdapter<R> implements CallAdapter<R,Object> {
    Type mType = null;

    public DefaultTypeCallAdapter(Type _t) {
        this.mType = _t;
    }

    @Override
    public Type responseType() {
        return mType;
    }

    @Override
    public Object adapt(Call<R> call) {
        return call;
    }
}
