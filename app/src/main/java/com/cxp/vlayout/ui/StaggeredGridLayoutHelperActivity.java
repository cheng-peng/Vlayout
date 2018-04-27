package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.StaggeredGridLayoutHelperAdapter;

/**
 * 文 件 名: StaggeredGridLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 20:51
 * 描    述: 瀑布流布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class StaggeredGridLayoutHelperActivity extends Activity {

    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        mRecyclerview = findViewById(R.id.recyclerview);

        //绑定VirtualLayoutManager
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        mRecyclerview.setLayoutManager(manager);
        DelegateAdapter adapter = new DelegateAdapter(manager, true);

        adapter.addAdapter(init(this));
        mRecyclerview.setAdapter(adapter);
    }

    //瀑布流布局初始化
    public static StaggeredGridLayoutHelperAdapter init(Context context) {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3, 20);
        return  new StaggeredGridLayoutHelperAdapter(context, staggeredGridLayoutHelper, "StaggeredGridLayoutHelper");
    }


}
