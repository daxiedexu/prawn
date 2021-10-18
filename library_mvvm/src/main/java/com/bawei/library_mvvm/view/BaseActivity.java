package com.bawei.library_mvvm.view;

import android.os.Bundle;
import android.renderscript.RSRuntimeException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.bawei.library_mvvm.viewmodel.BaseViewModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName cccc
 * @Description TODO
 * @Author 张溢通
 * @Date 2021/10/14 19:35
 * @Version 1.0
 * Created by Android Studio.
 * User: 伊莎贝拉
 */
public abstract class BaseActivity<VM extends BaseViewModel,Binding extends ViewDataBinding> extends AppCompatActivity {
    protected Binding mBinding;
    protected VM mViewModel;
    private HashMap<Integer,Object> mMap = new HashMap<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, getLayout());
        mBinding.setLifecycleOwner(this);//设置生命周期的所有者，如果不设置那么使用LiveData页面将无法获取到数据的更新
        mViewModel = createViewModel();
        prepareSetVars(mMap);
        setVars(mBinding,mMap);
        initEvent();
    }

    private void setVars(Binding mBinding, HashMap<Integer, Object> mMap) {
        if (mMap.size()==0){
            throw new RSRuntimeException("please set variable...");
        }
        for (Map.Entry<Integer,Object> entry:mMap.entrySet()){
            mBinding.setVariable(entry.getKey(),entry.getValue());
        }
    }

    protected abstract void initEvent();

    protected abstract void prepareSetVars(HashMap<Integer, Object> mMap);

    protected abstract VM createViewModel();

    protected abstract int getLayout();
}
