package com.bawei.model;

import com.bawei.contract.Icontract;
import com.bawei.util.HttpUtil;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:55
 *@Description:${DESCRIPTION}
 **/
public class Model {
    public void getZuo(String url, Class cls, final Icontract.CoAll coAll){
        HttpUtil.getInstance().getZuo(url, cls, new Icontract.CoAll() {
            @Override
            public void success(String url) {
                coAll.success(url);
            }
        });
    }
    public void getYou(String url, Map<String,Object>map, Class cls, final Icontract.CoAll coAll){
        HttpUtil.getInstance().getYou(url, map, cls, new Icontract.CoAll() {
            @Override
            public void success(String url) {
                coAll.success(url);
            }
        });
    }
}
