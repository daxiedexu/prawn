package com.bawei.prawn.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @ClassName VpAdapter
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/19 18:10
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class VpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public VpAdapter(@NonNull @NotNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
