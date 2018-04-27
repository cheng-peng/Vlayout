package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.DelegateRecyclerAdapter;
import com.cxp.vlayout.adapter.FixLayoutAdapter;

/**
 * 文 件 名: FixLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 21:04
 * 描    述: 固定布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FixLayoutHelperActivity extends Activity{

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

        adapter.addAdapter(initLinearLayoutHelper(this));
        adapter.addAdapter(initFixLayoutHelper(this));
        mRecyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initLinearLayoutHelper(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        //设置间隔高度
        linearLayoutHelper.setDividerHeight(5);
        //设置布局底部与下个布局的间隔
        linearLayoutHelper.setMarginBottom(20);
        //设置间距
        linearLayoutHelper.setMargin(20,20,20,20);
        return new DelegateRecyclerAdapter(context,linearLayoutHelper,"FixLayoutHelper");
    }

    //固定布局初始化
    public static FixLayoutAdapter initFixLayoutHelper(Context context){
        FixLayoutHelper fixLayoutHelper=new FixLayoutHelper(FixLayoutHelper.BOTTOM_LEFT, 200, 200);
        return new FixLayoutAdapter(context,fixLayoutHelper,"FixLayoutHelper");
    }

}
