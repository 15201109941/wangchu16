package com.bawei.base;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:51
 *@Description:${DESCRIPTION}
 **/
public class BasePresenter<V extends BaseActivity> {
    public V v;

    public void onAttch(V v) {
        this.v=v;
    }
    public void onDeAttch(){
        if (v!=null){
            v=null;
        }
    }
}
