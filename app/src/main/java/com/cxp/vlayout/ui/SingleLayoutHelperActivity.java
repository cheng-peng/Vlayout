package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.SingleLayoutHelperAdapter;

/**
 * 文 件 名: SingleLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:01
 * 描    述: 通栏布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class SingleLayoutHelperActivity extends Activity{

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

        adapter.addAdapter(initSingleLayout(this));
        mRecyclerview.setAdapter(adapter);
    }

    public static SingleLayoutHelperAdapter initSingleLayout(Context context){
        SingleLayoutHelper singleLayoutHelper=new SingleLayoutHelper();
        //设置间距
        singleLayoutHelper.setMargin(20,20,20,20);
        return new SingleLayoutHelperAdapter(context,singleLayoutHelper,"SingleLayoutHelper");
    }


}
