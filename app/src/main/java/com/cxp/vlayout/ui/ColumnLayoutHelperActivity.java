package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.ColumnLayoutAdapter;

/**
 * 文 件 名: ColumnLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 21:39
 * 描    述: 栏格布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ColumnLayoutHelperActivity extends Activity{

    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        mRecyclerview=findViewById(R.id.recyclerview);

        //绑定VirtualLayoutManager
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        mRecyclerview.setLayoutManager(manager);
        DelegateAdapter adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initColumnLayout(this));
        mRecyclerview.setAdapter(adapter);
    }

    public static ColumnLayoutAdapter initColumnLayout(Context context){
        ColumnLayoutHelper columnLayoutHelper=new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{20,20,20,20,20});
        columnLayoutHelper.setMarginBottom(20);
        return new ColumnLayoutAdapter(context,columnLayoutHelper,"ColumnLayoutHelper");
    }


}
