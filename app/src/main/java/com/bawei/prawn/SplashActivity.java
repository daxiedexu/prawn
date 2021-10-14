package com.bawei.prawn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.bawei.common.front.StatusBarUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //置空window背景图
        getWindow().setBackgroundDrawable(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置白底黑字
        StatusBarUtils.setStatusBarColor(this, Color.WHITE);
        StatusBarUtils.setAndroidNativeLightStatusBar(this,true);
    }

    /**
     * 等待视图能够获取焦点跳转登录页面
     * 1.在视图获取到焦点的时候去跳转
     * 2.在视图失去焦点的时候去杀死Activity
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            startActivity(new Intent(SplashActivity.this,MainActivity.class));
        }else {
            finish();
        }
    }
}