package com.bw.mvvm_core.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.bw.mvvm_core.repository.BaseRepository;

/**
 * @ClassName cccc
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/10/14 19:34
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public abstract class BaseViewModel<Repo extends BaseRepository> extends ViewModel implements LifecycleObserver {
    protected Repo mRepository;
    private LifecycleOwner mOwner;
    public BaseViewModel(LifecycleOwner owner) {
        mRepository = createRepository();
        mOwner = owner;
        mOwner.getLifecycle().addObserver(this);
    }
    /**
     * 创建并初始化Repository
     */
    protected abstract Repo createRepository();

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void uiConnection(){
        initResource();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disConnection(){
        releaseResource();
        mOwner.getLifecycle().removeObserver(this);
    }

    protected void releaseResource(){}

    protected void initResource(){};
}
