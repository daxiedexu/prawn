package com.bawei.module_home.mvvm.model;

import androidx.lifecycle.LiveData;
import com.bawei.library_mvvm.model.IModel;
import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.library_net.net.RetrofitFactory;
import com.bawei.module_home.bean.PostListBean;
import com.bawei.module_home.mvvm.api.HomeApi;

import java.util.ArrayList;

/**
 * @ClassName PostListModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 9:15
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class PostListModel implements IModel {
    public LiveData<BaseRespEntity<PostListBean>> postList(int feedId,int pageCount,int userId){
        LiveData<BaseRespEntity<PostListBean>> liveData = RetrofitFactory.getRetrofitFactory().create(HomeApi.class).postList(feedId, pageCount, userId);
        return liveData;
    }
}
