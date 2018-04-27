package com.cxp.vlayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.cxp.vlayout.R;

/**
 * 文 件 名: StickyLayoutHelperAdapter
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:21
 * 描    述: 吸边布局适配器
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class StickyLayoutHelperAdapter extends DelegateAdapter.Adapter<StickyLayoutHelperAdapter.StickyLayoutHelperViewHolder> {

    public Context mContext;
    private LayoutHelper mHelper;

    public StickyLayoutHelperAdapter(Context context, LayoutHelper helper) {
        mContext = context;
        mHelper = helper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @NonNull
    @Override
    public StickyLayoutHelperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new StickyLayoutHelperViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_sticy,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StickyLayoutHelperViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class StickyLayoutHelperViewHolder extends RecyclerView.ViewHolder{


        public StickyLayoutHelperViewHolder(View itemView) {
            super(itemView);

        }
    }
}
