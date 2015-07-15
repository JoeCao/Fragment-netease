package com.base;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

/**
 * Created by caozupeng on 15-6-16.
 */
public class App extends Application {
    public static boolean debug = true;
    public static App ctx;

    public static App getInstance() {
        return ctx;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        ctx = this;
        String appId = "3xlpeeb8p42wtkupk3ah1sr4a5g1tna7sd5i655bie9io0y7";
        String appKey = "mjvyhhrr6phu10u5qh43qruyqgv7xeflwspfx5z5aoxuwy41";

        AVOSCloud.initialize(this, appId, appKey);
    }
}
