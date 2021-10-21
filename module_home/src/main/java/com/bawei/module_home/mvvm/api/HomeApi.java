package com.bawei.module_home.mvvm.api;

import androidx.lifecycle.LiveData;

import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.module_home.bean.PostListBean;

import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @ClassName HomeApi
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 9:13
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public interface HomeApi {
    @GET("feeds/queryHotFeedsList?")
    LiveData<BaseRespEntity<PostListBean>> postList(@Query("feedId") int feedId,@Query("pageCount") int pageCount,@Query("userId") int userId);
}
