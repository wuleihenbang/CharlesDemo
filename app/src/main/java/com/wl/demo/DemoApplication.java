package com.wl.demo;

import android.app.Application;

public class DemoApplication extends Application {

    private static DemoApplication mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static DemoApplication getInstance() {
        return mInstance;
    }
}
