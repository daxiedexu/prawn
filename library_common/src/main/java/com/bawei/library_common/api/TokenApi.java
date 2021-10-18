package com.bawei.library_common.api;


import com.bawei.library_common.Bean.TokenRespEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @ClassName RetrofitFactory
 * @Author 孔晨亮
 * @Date 2021/10/14 19:50
 * User: msi
 */
public interface TokenApi {
    @FormUrlEncoded
    @POST("token")
    Call<TokenRespEntity> getToken(@Field("grant_type") String grant_type, @Field("username") String username, @Field("password") String password);
}
