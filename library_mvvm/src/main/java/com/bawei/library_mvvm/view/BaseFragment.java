package com.bawei.library_mvvm.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


import com.bawei.library_mvvm.common.MVVMModelException;
import com.bawei.library_mvvm.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName cccc
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/10/14 19:34
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public abstract class BaseFragment<VM extends BaseViewModel,Binding extends ViewDataBinding> extends Fragment {
    protected Binding mBinding;
    protected VM mViewModel;

    private HashMap<Integer,Object> mMap=new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        //设置生命周期的所有者，如果不设置使用LiveData页面将无法获取到数据的更新
        mBinding.setLifecycleOwner(this);
        mViewModel=createViewModel();
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
        loadData();
        initEvent();
    }

    /**
     * 初始化事件
     */
    protected abstract void initEvent();

    /**
     * 初始化数据意思为获取数据
     */
    protected abstract void loadData();

    /**
     * 设置变量
     * @param mBinding
     * @param mMap
     */
    protected void setVars(Binding mBinding, HashMap<Integer, Object> mMap){
        //判断是否有变量 如果没有就抛出异常
        if (mMap.size()==0){
            throw new MVVMModelException("please set variable..");
        }
        for (Map.Entry<Integer,Object> entry:mMap.entrySet()) {
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }


    /**
     * 准备设置数据源
     * @param mMap
     */
    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    /**
     * 创建ViewModel实例
     * @param
     * @return
     * @time 2021/8/17 8:59
     */
    protected abstract VM createViewModel();

    /**
     * 让子类去重写获取布局资源id
     * @return
     */
    protected abstract int getLayoutId();


}
