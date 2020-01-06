package com.bawei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.bean.ZuoBean;
import com.bawei.wangchu0106.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
 *@auther:王楚
 *@Date: 2020/1/6
 *@Time:9:07
 *@Description:${DESCRIPTION}
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<ZuoBean> list;
    private Context context;

    public MyAdapter(List<ZuoBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.a, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.textA.setText((CharSequence) list.get(i).getCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_a)
        TextView textA;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    //点击事件
    public interface OnItemClick{
        void onClick(int t);
    }
    private  OnItemClick onItemClick;

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }
}
