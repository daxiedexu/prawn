package com.bawei.prawn;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.sdk.android.cloudcode.AdLoadListener;
import com.alibaba.sdk.android.cloudcode.SplashAdView;

public class AdvActivity extends AppCompatActivity {
    private static final String TAG = "AdvActivity";
    private SplashAdView splashAdView;
    private boolean isClickAd = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);
        initView();
        // 设置广告加载监听
        splashAdView.setAdLoadListener(new AdLoadListener() {
            @Override
            public void loadSuccess() {
                Log.d(TAG,"加载广告位成功!");
            }

            @Override
            public void loadFail(String s, String s1) {
                Log.d(TAG,"加载广告位失败..."+s+" "+s1);
/*                Toast.makeText(AdvActivity.this, "加载广告位失败,直接跳转主页面", Toast.LENGTH_SHORT).show();
//                ARouter.getInstance().build(Config.MODULE_MAIN).navigation();
                startActivity(new Intent(AdvActivity.this,MainActivity.class));
                finish();*/
            }
        });

        // 设置广告交互监听
        splashAdView.setAdInteractListener(new SplashAdView.SplashAdInteractListener() {
            @Override
            public void onTimeOver() {
                goToMain();
            }

            @Override
            public void jump() {
                goToMain();
            }

            @Override
            public void onShowed() {
            }

            @Override
            public void onClicked() {
                isClickAd = true;
            }

            @Override
            public void onAction(int i, int i1) {
            }
        });

        // 请求加载广告
        splashAdView.loadAd();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isClickAd) {
            // 从广告界面返回的
            goToMain();
        }
    }

    private void goToMain() {
        // 开屏广告展示结束，跳转主界面
        startActivity(new Intent(AdvActivity.this, MainActivity.class));
        finish();
    }

    private void initView() {
        splashAdView = (SplashAdView) findViewById(R.id.splashAdView);
    }
}