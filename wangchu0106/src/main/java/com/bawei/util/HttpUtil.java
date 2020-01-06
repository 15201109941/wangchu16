package com.bawei.util;

import com.bawei.api.ApiService;
import com.bawei.contract.Icontract;
import com.bawei.url.MyUrl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:43
 *@Description:${DESCRIPTION}
 **/
public class HttpUtil {
    private ApiService apiService;
    private HttpUtil(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyUrl.BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        apiService=retrofit.create(ApiService.class);
    }
    private static class NetHolder{
        private static final HttpUtil mNet = new HttpUtil();
    }
    public static HttpUtil getInstance(){
        return NetHolder.mNet;
    }
    public void getZuo(final String url, Class cls, final Icontract.CoAll coAll){
        apiService.getZuo(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        coAll.success(responseBody.string());
                    }
                });
    }
    public void getYou(String url, Map<String,Object>map, Class cls, final Icontract.CoAll coAll){
        apiService.getYou(url,map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        coAll.success(responseBody.string());
                    }
                });
    }
}
