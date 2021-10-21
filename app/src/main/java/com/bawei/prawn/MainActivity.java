package com.bawei.prawn;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bawei.library_common.front.StatusBarUtils;
import com.bawei.module_discover.DiscoverFragment;
import com.bawei.module_home.HomeFragment;
import com.bawei.module_publish.PublishFragment;
import com.bawei.module_sofa.SofaFragment;
import com.bawei.mudule_my.MyFragment;
import com.bawei.prawn.adapter.VpAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager actMainVp;
    private RadioGroup actMainRadio;
    private RadioButton actMainHome;
    private RadioButton actMainSofa;
    private ImageView actMainPublish;
    private RadioButton actMainFind;
    private RadioButton actMainMy;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置白底黑字
        StatusBarUtils.setStatusBarColor(this, Color.WHITE);
        StatusBarUtils.setAndroidNativeLightStatusBar(this,true);
        initView();
        initSelect();
    }

    private void initSelect() {
        //添加数据设置Fragment适配器
        fragments = new ArrayList<>();
//        fragments.add(new HomeFragment());//该Fragment添加适配器会报错，先不进行添加，单独开发
        fragments.add(new SofaFragment());
        fragments.add(new PublishFragment());
        fragments.add(new DiscoverFragment());
        fragments.add(new MyFragment());
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments);
        actMainVp.setAdapter(vpAdapter);
        //添加监听事件
        actMainRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.act_main_home:
                        //先不进行Fragment切换
                        break;
                    case R.id.act_main_sofa:
                        actMainVp.setCurrentItem(0);
                        break;
                    case R.id.act_main_find:
                        actMainVp.setCurrentItem(2);
                        break;
                    case R.id.act_main_my:
                        actMainVp.setCurrentItem(3);
                        break;
                    default:break;
                }
            }
        });
        actMainPublish.setOnClickListener(view->{
            actMainVp.setCurrentItem(1);
        });
    }

    private void initView() {
        actMainVp = (ViewPager) findViewById(R.id.act_main_vp);
        actMainRadio = (RadioGroup) findViewById(R.id.act_main_radio);
        actMainHome = (RadioButton) findViewById(R.id.act_main_home);
        actMainSofa = (RadioButton) findViewById(R.id.act_main_sofa);
        actMainPublish = (ImageView) findViewById(R.id.act_main_publish);
        actMainFind = (RadioButton) findViewById(R.id.act_main_find);
        actMainMy = (RadioButton) findViewById(R.id.act_main_my);
    }
}