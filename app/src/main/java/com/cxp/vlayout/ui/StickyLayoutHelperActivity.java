package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.DelegateRecyclerAdapter;
import com.cxp.vlayout.adapter.StickyLayoutHelperAdapter;

/**
 * 文 件 名: StickyLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:20
 * 描    述: 吸边布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class StickyLayoutHelperActivity extends Activity{

    private RecyclerView mRecyclerView;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        mRecyclerView=findViewById(R.id.recyclerview);

        //绑定VirtualLayoutManager
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initStickyLayoutHelper(this));
        adapter.addAdapter(initLinearLayoutHelper(this));

        mRecyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initLinearLayoutHelper(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        return new DelegateRecyclerAdapter(context,linearLayoutHelper,"StickyLayoutHelper");
    }

    public static StickyLayoutHelperAdapter initStickyLayoutHelper(Context context){
        StickyLayoutHelper stickyLayoutHelper=new StickyLayoutHelper();
        return new StickyLayoutHelperAdapter(context,stickyLayoutHelper);
    }

}
