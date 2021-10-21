package com.bawei.module_home.mvvm.repository;

import androidx.lifecycle.LiveData;

import com.bawei.library_mvvm.model.Model;
import com.bawei.library_mvvm.repository.BaseRepository;
import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.module_home.bean.PostListBean;
import com.bawei.module_home.mvvm.model.PostListModel;

import java.util.ArrayList;

/**
 * @ClassName HomeRepository
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 9:16
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class HomeRepository extends BaseRepository {
    @Model
    PostListModel postListModel;
    public LiveData<BaseRespEntity<PostListBean>> postList(int feedId, int pageCount, int userId){
        return postListModel.postList(feedId, pageCount, userId);
    }
}
