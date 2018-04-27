package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.DelegateRecyclerAdapter;
import com.cxp.vlayout.adapter.FixLayoutAdapter;

/**
 * 文 件 名: FloatLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:14
 * 描    述: 浮动布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class FloatLayoutHelperActivity extends Activity{

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

        adapter.addAdapter(initLinearLayout(this));
        adapter.addAdapter(initFloatLayoutHelper(this));

        mRecyclerView.setAdapter(adapter);
    }

    public static DelegateRecyclerAdapter initLinearLayout(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        return new DelegateRecyclerAdapter(context,linearLayoutHelper,"FloatLayoutHelper");
    }

    //浮动布局初始化
    public static FixLayoutAdapter initFloatLayoutHelper(Context context){
        FloatLayoutHelper floatLayoutHelper=new FloatLayoutHelper();
        floatLayoutHelper.setDefaultLocation(20,250);
        return  new FixLayoutAdapter(context,floatLayoutHelper,"FloatLayoutHelper");
    }


}
