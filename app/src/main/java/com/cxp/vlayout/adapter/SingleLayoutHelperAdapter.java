package com.cxp.vlayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.cxp.vlayout.R;

/**
 * 文 件 名: SingleLayoutHelperAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:02
 * 描    述: 通栏布局适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class SingleLayoutHelperAdapter extends DelegateAdapter.Adapter<SingleLayoutHelperAdapter.SingleLayoutHelperViewHolder> {

    public Context mContext;
    private LayoutHelper mHelper;
    private String name;

    public SingleLayoutHelperAdapter(Context context, LayoutHelper helper, String name) {
        mContext = context;
        mHelper = helper;
        this.name = name;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public SingleLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SingleLayoutHelperViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SingleLayoutHelperViewHolder holder, int position) {
            if(position%2==0){
                holder.itemView.setBackgroundColor(0xaa3F51B5);
            }else{
                holder.itemView.setBackgroundColor(0xccFF4081);
            }
            holder.tvName.setText(name+position+"");
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class SingleLayoutHelperViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public SingleLayoutHelperViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.item_name);
        }
    }
}
