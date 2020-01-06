package com.bawei.util;

import android.widget.ImageView;

import com.bawei.app.MyApp;
import com.bawei.wangchu0106.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:9:03
 *@Description:${DESCRIPTION}
 **/
public class GlideUtil {
    public static void loadImage(String url, ImageView imageView){
        Glide.with(MyApp.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(100)))
                .into(imageView);
    }
}
