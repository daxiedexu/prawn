package com.bawei.library_common.back;

import android.util.Log;

import com.bawei.library_common.BuildConfig;

/**
 * @ClassName LogUtils
 * @Description TODO
 * @Date 2021/10/13 8:10
 * @Version 1.0
 * Created by Android Studio.
 */
public class LogUtils {
    private static String className;
    private static String methodName;
    private static int lineNumber;

    public static boolean isDebuggable(){
        return BuildConfig.DEBUG;
    }

    private static String createLog(String log){
        StringBuffer buffer = new StringBuffer();
        buffer.append("========");
        buffer.append(className);
        buffer.append("(").append(className).append(":").append(lineNumber).append(")========:");
        buffer.append(log);
        return buffer.toString();
    }

    /**
     * 通过当前线程的栈帧拿到类的属性名进行赋值
     */
    public static void getMethodNames(StackTraceElement[] stackTraceElements){
        className = stackTraceElements[1].getFileName();
        methodName = stackTraceElements[1].getMethodName();
        lineNumber = stackTraceElements[1].getLineNumber();
    }

    /**
     * 示例：
     * 1.判断是否为DEBUG模式
     * 2.获取当前栈帧的信息
     * 3.输出对应Log语句
     */
    public static void v(String message){
        if (!isDebuggable()){
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.v(className,createLog(message));
    }

    public static void d(String message){
        if (!isDebuggable()){
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.d(className,createLog(message));
    }

    public static void i(String message){
        if (!isDebuggable()){
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.i(className,createLog(message));
    }

    public static void w(String message){
        if (!isDebuggable()){
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.w(className,createLog(message));
    }

    public static void e(String message){
        if (!isDebuggable()){
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        Log.e(className,createLog(message));
    }
}
