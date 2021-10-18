package com.bawei.prawn;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.bawei.library_common.front.StatusBarUtils;
import com.bawei.module_discover.DiscoverFragment;
import com.bawei.module_home.HomeFragment;
import com.bawei.module_publish.PublishFragment;
import com.bawei.module_sofa.SofaFragment;
import com.bawei.mudule_my.MyFragment;

public class MainActivity extends AppCompatActivity{

    private LinearLayout actMainLl;
    private RadioGroup actMainRadio;
    private RadioButton actMainHome;
    private RadioButton actMainSofa;
    private ImageView actMainPublish;
    private RadioButton actMainFind;
    private RadioButton actMainMy;

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
        getSupportFragmentManager().beginTransaction().add(R.id.act_main_ll,new HomeFragment()).commit();//初始化HomeFragment
        actMainRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.act_main_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.act_main_ll,new HomeFragment()).commit();
                        break;
                    case R.id.act_main_sofa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.act_main_ll,new SofaFragment()).commit();
                        break;
                    case R.id.act_main_find:
                        getSupportFragmentManager().beginTransaction().replace(R.id.act_main_ll,new DiscoverFragment()).commit();
                        break;
                    case R.id.act_main_my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.act_main_ll,new MyFragment()).commit();
                        break;
                    default:break;
                }
            }
        });
        actMainPublish.setOnClickListener(view->{
            getSupportFragmentManager().beginTransaction().replace(R.id.act_main_ll,new PublishFragment()).commit();
        });
    }

    private void initView() {
        actMainLl = (LinearLayout) findViewById(R.id.act_main_ll);
        actMainRadio = (RadioGroup) findViewById(R.id.act_main_radio);
        actMainHome = (RadioButton) findViewById(R.id.act_main_home);
        actMainSofa = (RadioButton) findViewById(R.id.act_main_sofa);
        actMainPublish = (ImageView) findViewById(R.id.act_main_publish);
        actMainFind = (RadioButton) findViewById(R.id.act_main_find);
        actMainMy = (RadioButton) findViewById(R.id.act_main_my);
    }
}