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
 * 文 件 名: StaggeredGridLayoutHelperAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 20:51
 * 描    述: 流布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class StaggeredGridLayoutHelperAdapter extends DelegateAdapter.Adapter<StaggeredGridLayoutHelperAdapter.StaggeredGridLayoutHelperViewHolder> {

    public Context mContext;
    private LayoutHelper mHelper;
    private String name;

    public StaggeredGridLayoutHelperAdapter(Context context, LayoutHelper helper, String name) {
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
    public StaggeredGridLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new StaggeredGridLayoutHelperViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridLayoutHelperViewHolder holder, int position) {
        if(position%2==0){
            holder.itemView.setBackgroundColor(0xaa3F51B5);
        }else{
            holder.itemView.setBackgroundColor(0xccFF4081);
        }
        ViewGroup.LayoutParams layoutParams = holder.tvName.getLayoutParams();
        layoutParams.height = 260 + position % 7 * 20;
        holder.tvName.setLayoutParams(layoutParams);
        holder.tvName.setText(position + 1 + "");
        holder.tvName.setText(name);
    }

    @Override
    public int getItemCount() {
        return 60;
    }

    public class StaggeredGridLayoutHelperViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public StaggeredGridLayoutHelperViewHolder(View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.item_name);
        }
    }
}
