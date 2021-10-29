package com.bawei.prawn;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.library_common.back.SharedPreferencesUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;

public class AdvActivity extends AppCompatActivity {
    private static final String TAG = "AdvActivity";
    private TTAdNative mTTAdNative;
    private FrameLayout mSplashContainer;
    //是否强制跳转到主页面
    private boolean mForceGoMain;

    //开屏广告加载超时时间,建议大于3000,这里为了冷启动第一次加载到广告并且展示,示例设置了3000ms
    private static final int AD_TIME_OUT = 3000;
    private String mCodeId = "801121648";
    private boolean mIsExpress = false; //是否请求模板广告
    private boolean mIsHalfSize = false;//是否是半全屏开屏
    private boolean mIsSplashClickEye = false;//是否是开屏点睛

    private LinearLayout mSplashHalfSizeLayout;
    private FrameLayout mSplashSplashContainer;

    private TTSplashAd mSplashAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);
        mSplashContainer = (FrameLayout) findViewById(R.id.splash_container);
        mTTAdNative = TTAdSdk.getAdManager().createAdNative(this);
        getExtraInfo();
        loadSplashAd();
    }
    private void getExtraInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String codeId = intent.getStringExtra("splash_rit");
        if (!TextUtils.isEmpty(codeId)) {
            mCodeId = codeId;
        }
        mIsExpress = intent.getBooleanExtra("is_express", false);
        mIsHalfSize = intent.getBooleanExtra("is_half_size", false);
        mIsSplashClickEye = intent.getBooleanExtra("is_splash_click_eye", false);
    }

    @Override
    protected void onResume() {
        //判断是否该跳转到主页面
        if (mForceGoMain) {
            goToMainActivity();
        }
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mForceGoMain = true;
    }

    /**
     * 加载开屏广告
     */
    private void loadSplashAd() {
        //step3:创建开屏广告请求参数AdSlot,具体参数含义参考文档

        AdSlot adSlot = null;
        if (mIsExpress) {
            //个性化模板广告需要传入期望广告view的宽、高，单位dp，请传入实际需要的大小，
            //比如：广告下方拼接logo、适配刘海屏等，需要考虑实际广告大小
            //float expressViewWidth = UIUtils.getScreenWidthDp(this);
            //float expressViewHeight = UIUtils.getHeight(this);

            adSlot = new AdSlot.Builder()
                    .setCodeId(mCodeId)
                    //模板广告需要设置期望个性化模板广告的大小,单位dp,代码位是否属于个性化模板广告，请在穿山甲平台查看
                    //view宽高等于图片的宽高
                    .setExpressViewAcceptedSize(1080, 1920)
                    .build();
        } else {

            adSlot = new AdSlot.Builder()
                    .setCodeId(mCodeId)
                    .setImageAcceptedSize(1080, 1920)
                    .build();
        }

        //step4:请求广告，调用开屏广告异步请求接口，对请求回调的广告作渲染处理

        mTTAdNative.loadSplashAd(adSlot, new TTAdNative.SplashAdListener() {
            @Override
            @MainThread
            public void onError(int code, String message) {
                Log.d(TAG, String.valueOf(message));
                showToast(message);
                goToMainActivity();
            }

            @Override
            @MainThread
            public void onTimeout() {
                showToast("开屏广告加载超时");
                goToMainActivity();
            }

            @Override
            @MainThread

            public void onSplashAdLoad(TTSplashAd ad) {
                Log.d(TAG, "开屏广告请求成功");
                if (ad == null) {
                    return;
                }
                mSplashAd = ad;

                //获取SplashView
                View view = ad.getSplashView();
                if (mIsHalfSize) {
                    if (view != null && mSplashSplashContainer != null && !AdvActivity.this.isFinishing()) {
                        mSplashHalfSizeLayout.setVisibility(View.VISIBLE);
                        mSplashSplashContainer.setVisibility(View.VISIBLE);
                        if (mSplashContainer != null) {
                            mSplashContainer.setVisibility(View.GONE);
                        }
                        mSplashSplashContainer.removeAllViews();
                        //把SplashView 添加到ViewGroup中,注意开屏广告view：width >=70%屏幕宽；height >=50%屏幕高
                        mSplashSplashContainer.addView(view);
                        /**
                         * 设置是否开启开屏广告倒计时功能以及不显示跳过按钮,如果设置为true，您需要自定义倒计时逻辑，
                         * 参考样例请看：
                         * @see SplashActivity#useCustomCountdownButton
                         */
                        //useCustomCountdownButton(false,ad);
                    } else {
                        goToMainActivity();
                    }
                } else {
                    if (view != null && mSplashContainer != null && !AdvActivity.this.isFinishing()) {
                        mSplashContainer.setVisibility(View.VISIBLE);
                        if (mSplashHalfSizeLayout != null) {
                            mSplashHalfSizeLayout.setVisibility(View.GONE);
                        }

                        mSplashContainer.removeAllViews();
                        //把SplashView 添加到ViewGroup中,注意开屏广告view：width >=70%屏幕宽；height >=50%屏幕高
                        mSplashContainer.addView(view);
                        /**
                         * 设置是否开启开屏广告倒计时功能以及不显示跳过按钮,如果设置为true，您需要自定义倒计时逻辑，
                         * 参考样例请看：
                         * @see SplashActivity#useCustomCountdownButton
                         */
                        //useCustomCountdownButton(false,ad);

                    } else {
                        goToMainActivity();
                    }
                }


                //设置SplashView的交互监听器

                ad.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() {
                    @Override

                    public void onAdClicked(View view, int type) {
                        Log.d(TAG, "onAdClicked");
                        showToast("开屏广告点击");
                    }

                    @Override

                    public void onAdShow(View view, int type) {
                        Log.d(TAG, "onAdShow");
                        showToast("开屏广告展示");
                    }

                    @Override

                    public void onAdSkip() {
                        Log.d(TAG, "onAdSkip");
                        showToast("开屏广告跳过");
                        goToMainActivity();

                    }

                    @Override

                    public void onAdTimeOver() {
                        Log.d(TAG, "onAdTimeOver");
                        showToast("开屏广告倒计时结束");
                        goToMainActivity();
                    }
                });

                if (ad.getInteractionType() == TTAdConstant.INTERACTION_TYPE_DOWNLOAD) {
                    ad.setDownloadListener(new TTAppDownloadListener() {
                        boolean hasShow = false;

                        @Override
                        public void onIdle() {
                        }

                        @Override
                        public void onDownloadActive(long totalBytes, long currBytes, String fileName, String appName) {
                            if (!hasShow) {
                                showToast("下载中...");
                                hasShow = true;
                            }
                        }

                        @Override
                        public void onDownloadPaused(long totalBytes, long currBytes, String fileName, String appName) {
                            showToast("下载暂停...");

                        }

                        @Override
                        public void onDownloadFailed(long totalBytes, long currBytes, String fileName, String appName) {
                            showToast("下载失败...");

                        }

                        @Override
                        public void onDownloadFinished(long totalBytes, String fileName, String appName) {
                            showToast("下载完成...");

                        }

                        @Override
                        public void onInstalled(String fileName, String appName) {
                            showToast("安装完成...");

                        }
                    });
                }
            }
        }, AD_TIME_OUT);
    }

    /**
     * 跳转到主页面
     */
    private void goToMainActivity() {
        Intent intent = new Intent(AdvActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private void showToast(String msg) {

    }
}