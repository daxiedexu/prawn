package com.bawei.library_net.gson;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * @ClassName CustomRequestBodyConverter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/19 14:51
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class CustomRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    @Override
    public RequestBody convert(T value) throws IOException {
        String jsonContent = new Gson().toJson(value);
        return RequestBody.create(MEDIA_TYPE,jsonContent);
    }
}
