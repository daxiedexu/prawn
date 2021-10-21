package com.bawei.module_home;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library_common.back.LogUtils;
import com.bawei.library_mvvm.view.BaseFragment;
import com.bawei.library_net.Bean.BaseRespEntity;
import com.bawei.module_home.adapter.PostListAdapter;
import com.bawei.module_home.bean.PostListBean;
import com.bawei.module_home.databinding.FragmentHomeBinding;
import com.bawei.module_home.mvvm.viewmodel.PostListViewModel;
import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;


public class HomeFragment extends BaseFragment<PostListViewModel, FragmentHomeBinding> implements OnLoadMoreListener, OnRefreshListener {
    private SmartRefreshLayout fgHomeSmart;
    private RecyclerView fgHomeRecycler;

    @Override
    protected void initView() {
        fgHomeSmart = (SmartRefreshLayout) getActivity().findViewById(R.id.fg_home_smart);
        fgHomeRecycler = (RecyclerView) getActivity().findViewById(R.id.fg_home_recycler);
    }

    @Override
    protected void loadData() {
        //请求数据
        mViewModel.postList(0,10,0).observe(this, new Observer<BaseRespEntity<PostListBean>>() {
            @Override
            public void onChanged(BaseRespEntity<PostListBean> baseRespEntity) {
                Log.d("hello","hello");
                Log.d("hello",baseRespEntity.getMsg()+"");
//                PostListAdapter postListAdapter = new PostListAdapter(baseRespEntity.getData().getPostDataBean().getData());
//                fgHomeRecycler.setAdapter(postListAdapter);
//                fgHomeRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        });
    }

    @Override
    public void onLoadMore(@NonNull @NotNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull @NotNull RefreshLayout refreshLayout) {

    }

    @Override
    protected PostListViewModel createViewModel() {
        return new PostListViewModel(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void prepareSetVars(HashMap mMap) {
        mMap.put(BR.HomeViewModel,mViewModel);
    }
}