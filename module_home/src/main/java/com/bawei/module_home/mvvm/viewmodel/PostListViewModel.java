package com.bawei.module_home.mvvm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bawei.library_common.back.ThreadUtils;
import com.bawei.library_mvvm.viewmodel.BaseViewModel;
import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.module_home.bean.PostListBean;
import com.bawei.module_home.mvvm.repository.HomeRepository;

import java.util.ArrayList;

/**
 * @ClassName PostListViewModel
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 9:17
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class PostListViewModel extends BaseViewModel<HomeRepository> {
    public MutableLiveData<PostListBean> mutableLiveData = new MutableLiveData<>();

    public PostListViewModel(LifecycleOwner owner) {
        super(owner);
        PostListBean postListBean = new PostListBean();
        if (ThreadUtils.isMainThread()){
            mutableLiveData.setValue(postListBean);
        }else {
            mutableLiveData.postValue(postListBean);
        }
    }

    @Override
    protected HomeRepository createRepository() {
        return new HomeRepository();
    }

    public LiveData<BaseRespEntity<PostListBean>> postList(int feedId, int pageCount, int userId){
        return mRepository.postList(feedId, pageCount, userId);
    }
}
