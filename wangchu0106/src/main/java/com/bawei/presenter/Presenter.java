package com.bawei.presenter;

import com.bawei.base.BasePresenter;
import com.bawei.contract.Icontract;
import com.bawei.model.Model;
import com.bawei.wangchu0106.MainActivity;

import java.util.Map;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:56
 *@Description:${DESCRIPTION}
 **/
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
        model=new Model();
    }
    public void getZuo(String url, Class cls){
        model.getZuo(url, cls, new Icontract.CoAll() {
            @Override
            public void success(String url) {
                MainActivity mainActivity = (MainActivity) v;
                mainActivity.success(url);
            }
        });
    }
    public void getYou(String url, Map<String,Object>map, Class cls, Icontract.CoAll coAll){
        model.getYou(url, map, cls, new Icontract.CoAll() {
            @Override
            public void success(String url) {
                MainActivity mainActivity = (MainActivity) v;
                mainActivity.success(url);
            }
        });
    }
}
