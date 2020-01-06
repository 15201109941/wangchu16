package com.bawei.app;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:40
 *@Description:${DESCRIPTION}
 **/
public class MyApp extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
