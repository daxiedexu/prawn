package com.bawei.module_home.adapter;

import com.bawei.module_home.R;
import com.bawei.module_home.bean.PostListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @ClassName PostListAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 8:58
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class PostListAdapter extends BaseQuickAdapter<PostListBean.PostDataBean.DataBean, BaseViewHolder> {

    public PostListAdapter(@Nullable List<PostListBean.PostDataBean.DataBean> data) {
        super(R.layout.layout_postlist, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, PostListBean.PostDataBean.DataBean dataBean) {
        baseViewHolder.setText(R.id.item_feeds_text,dataBean.getFeeds_text());
    }
}
