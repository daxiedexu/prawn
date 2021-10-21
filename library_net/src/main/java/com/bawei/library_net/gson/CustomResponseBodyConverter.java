package com.bawei.library_net.gson;


import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.library_net.Bean.TokenRespEntity;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @ClassName CustomResponseBodyConverter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/19 14:55
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class CustomResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    @Override
    public T convert(ResponseBody value) throws IOException {
        String jsonContent = value.string();
        if (jsonContent.contains("access_")){
            return (T) new Gson().fromJson(jsonContent, TokenRespEntity.class);
        }
        BaseRespEntity entity = new Gson().fromJson(jsonContent, BaseRespEntity.class);
        return (T) entity;
    }
}
