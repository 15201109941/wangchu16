package com.bawei.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:43
 *@Description:${DESCRIPTION}
 **/
public interface ApiService {
    @GET
    Observable<ResponseBody> getZuo(@Url String url);
    @GET
    Observable<ResponseBody> getYou(@Url String url, @QueryMap Map<String,Object>map);
}
