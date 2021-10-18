package com.bawei.library_common.back;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * @ClassName ProgressManger
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/9/11 8:53
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */

public class ProgressManger {
    /**
     * 获取当前进程的Name进行初始化判断
     * 1、获取系统服务
     * 2、根据系统服务拿到运行的进程
     * 3、判断进程是否存在
     * 4、循环判断进程是否和当前进程一致，如果一致返回进程的名称进行初始化
     */
    public static String getProcessName(Context context, int pid){
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses!=null){
            for (ActivityManager.RunningAppProcessInfo processInfo:runningAppProcesses){
                if (processInfo.pid==pid){
                    return processInfo.processName;
                }
            }
        }
        return null;
    }
}
