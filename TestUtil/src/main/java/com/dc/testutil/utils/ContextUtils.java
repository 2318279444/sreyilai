package com.dc.testutil.utils;

import android.app.Application;
import android.content.Context;

public class ContextUtils {
    private static Context context;

    public static Context getContext() {
        if (context == null) {
            synchronized (ContextUtils.class) {
                if (context == null) {
                    try {
//                        Class<?> ActivityThread = Class.forName("android.app.ActivityThread");
//                        Method method = ActivityThread.getMethod("currentActivityThread");
//                        Object currentActivityThread = method.invoke(ActivityThread);
//                        Method method2 = currentActivityThread.getClass().getMethod("getApplication");
//                        context = (Context) method2.invoke("currentActivityThread");
                        Application app = (Application) Class.forName("android.app.ActivityThread")
                                .getMethod("currentApplication")
                                .invoke(null,(Object[])null);
                        context = app.getApplicationContext();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return context;
    }
}
