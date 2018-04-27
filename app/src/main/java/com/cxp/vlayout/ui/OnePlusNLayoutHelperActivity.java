package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.OnePlusNLayoutAdapter;

/**
 * 文 件 名: OnePlusNLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:08
 * 描    述: 1拖N布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class OnePlusNLayoutHelperActivity extends Activity{

    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        //绑定VirtualLayoutManager
        mRecyclerview=findViewById(R.id.recyclerview);
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        mRecyclerview.setLayoutManager(manager);
        DelegateAdapter adapter =new DelegateAdapter(manager, true);

        initOnePlusNLayout(this);
        adapter.addAdapter(initOnePlusNLayout(this));
        mRecyclerview.setAdapter(adapter);
    }

    //1拖N布局初始化
    public static OnePlusNLayoutAdapter initOnePlusNLayout(Context context){
        OnePlusNLayoutHelper onePlusNLayoutHelper=new OnePlusNLayoutHelper();
        //设置布局底部与下个布局的间隔
        onePlusNLayoutHelper.setMarginBottom(20);
        return new OnePlusNLayoutAdapter(context,onePlusNLayoutHelper,"OnePlusNLayoutHelper");
    }


}
