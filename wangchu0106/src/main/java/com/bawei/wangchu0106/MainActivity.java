package com.bawei.wangchu0106;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.adapter.MyAdapter;
import com.bawei.adapter.MyAdapter2;
import com.bawei.base.BaseActivity;
import com.bawei.base.BasePresenter;
import com.bawei.bean.YouBean;
import com.bawei.bean.ZuoBean;
import com.bawei.contract.Icontract;
import com.bawei.presenter.Presenter;
import com.bawei.url.MyUrl;
import com.bawei.util.HttpUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements Icontract.CoAll {


    @BindView(R.id.recy_a)
    RecyclerView recyA;
    @BindView(R.id.recy_b)
    RecyclerView recyB;
    private List<ZuoBean> list = new ArrayList<>();
    private Presenter presenter;
    @Override
    protected void initData() {
        presenter= (Presenter) mPresenter;
        presenter.getZuo(MyUrl.BASEZUO,ZuoBean.class);
    }

    @Override
    protected void initView() {
        recyA.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyB.setLayoutManager(new GridLayoutManager(this,3));
    }

    @Override
    protected BasePresenter initmPresenter() {
        return new Presenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(String url) {
        Gson gson = new Gson();
        ZuoBean zuoBean = gson.fromJson(url, ZuoBean.class);
        List<String> category = zuoBean.getCategory();
        for (int i = 0; i < category.size(); i++) {
        }

        MyAdapter myAdapter = new MyAdapter(list,this);
        recyA.setAdapter(myAdapter);
        myAdapter.setOnItemClick(new MyAdapter.OnItemClick() {
            @Override
            public void onClick(int t) {
                EventBus.getDefault().post(t);
            }
        });
        myAdapter.notifyDataSetChanged();
    }
    @Subscribe
    public void getVoid(String url, Map<String,Object>map){
        HttpUtil.getInstance().getYou(MyUrl.BASEYOU, map, YouBean.class, new Icontract.CoAll() {
            @Override
            public void success(String url) {
                Gson gson1 = new Gson();
                YouBean youBean = gson1.fromJson(url, YouBean.class);
                MyAdapter2 myAdapter2 = new MyAdapter2(youBean.getData(),MainActivity.this);
                recyB.setAdapter(myAdapter2);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
