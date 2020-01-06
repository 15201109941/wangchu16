package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.bean.YouBean;
import com.bawei.util.GlideUtil;
import com.bawei.wangchu0106.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:9:12
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.Holder2> {
    private List<YouBean.DataBean> list;
    private Context context;

    public MyAdapter2(List<YouBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.aa, null);
        return new Holder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder2 holder2, int i) {
        GlideUtil.loadImage(list.get(i).getGoods_thumb(),holder2.imagAa);
        holder2.textAa.setText(list.get(i).getGoods_name());
        holder2.textBb.setText(list.get(i).getCurrency_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.imag_aa)
        ImageView imagAa;
        @BindView(R.id.text_aa)
        TextView textAa;
        @BindView(R.id.text_bb)
        TextView textBb;
        public Holder2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
