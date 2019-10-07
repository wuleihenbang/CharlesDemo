package com.wl.demo.utils;

import com.wl.demo.DemoApplication;

public class DisplayUtils {

    public static int getScreenWidth(){
        return DemoApplication.getInstance().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(){
        return DemoApplication.getInstance().getResources().getDisplayMetrics().heightPixels;
    }
}
