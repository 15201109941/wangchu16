package com.bawei.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:8:50
 *@Description:${DESCRIPTION}
 **/
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter=initmPresenter();
        if (mPresenter!=null){
            mPresenter.onAttch(this);
        }
        initView();
        initData();
        ButterKnife.bind(this);
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initmPresenter();

    protected abstract int layoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDeAttch();
            mPresenter=null;
        }
    }
}
