package com.bawei.prawn;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;


import com.alibaba.sdk.android.cloudcode.CloudCodeInitializer;
import com.alibaba.sdk.android.cloudcode.CloudCodeLog;
import com.alibaba.sdk.android.logger.LogLevel;
import com.bawei.library_common.back.ProgressManger;
import com.eachann.launch.starter.TaskDispatcher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyApplication
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/10/13 18:49
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class MyApplication extends Application {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CODE_POLL_SIZE = Math.max(2,Math.min(CPU_COUNT-1,4));
    private ExecutorService executorService;

    /**
     * 这是第一种冷启动：（目前正在使用的方式）
     * 使用线程池进行耗时操作
     */
    @Override
    public void onCreate() {
        super.onCreate();
        String processName = ProgressManger.getProcessName(this, Process.myPid());//获取当前进程名：示例com.hello.github
        if (processName.equalsIgnoreCase(getPackageName()) && !TextUtils.isEmpty(processName)){//目前一个进程使用if，后期多个进程使用switch
            executorService = Executors.newFixedThreadPool(CODE_POLL_SIZE);
            executorService.submit(()->{
                TaskDispatcher.init(MyApplication.this);//初始化启动器
            });
            executorService.shutdown();//关闭线程池
            // 用户签署隐私协议之后，
            // 注入用户设备OAID
            CloudCodeInitializer.setOAID(null);
            // 调用云码sdk初始化
            CloudCodeInitializer.init(this);
            // 如果没有在manifest中配置渠道ID和媒体ID，需要在此处传入
            // CloudCodeInitializer.init(this, "使用渠道ID替换此处", "使用媒体ID替换此处");
            // 设置日志输出级别为debug
            CloudCodeLog.setLevel(LogLevel.DEBUG);
        }

    }

    /**
     * 这是第二种冷启动：
     * 优化使用addTask方法进行初始化耗时操作
     */
    public void optimize2(){
        TaskDispatcher.createInstance()
                .start();
    }
}
