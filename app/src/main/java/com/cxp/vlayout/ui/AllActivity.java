package com.cxp.vlayout.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.cxp.vlayout.R;

import java.util.LinkedList;
import java.util.List;

/**
 * 文 件 名: AllActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 22:24
 * 描    述: 全部
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class AllActivity extends Activity{

    private RecyclerView mRecyclerView;
    private DelegateAdapter delegateAdapter ;
    final List<DelegateAdapter.Adapter> adapters = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        mRecyclerView=findViewById(R.id.recyclerview);

        initView();
    }

    public void initView(){
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);

        adapters.add(LinearLayoutHelperActivity.init(this));
        adapters.add(ColumnLayoutHelperActivity.initColumnLayout(this));
        adapters.add(GridLayoutHelperActivity.init(this));
        adapters.add(FixLayoutHelperActivity.initFixLayoutHelper(this));
        adapters.add(ScrollFixLayoutHelperActivity.initScrollFixLayout(this));
        adapters.add(SingleLayoutHelperActivity.initSingleLayout(this));
        adapters.add(OnePlusNLayoutHelperActivity.initOnePlusNLayout(this));
        adapters.add(FloatLayoutHelperActivity.initFloatLayoutHelper(this));
        adapters.add(StickyLayoutHelperActivity.initStickyLayoutHelper(this));
        adapters.add(StaggeredGridLayoutHelperActivity.init(this));

        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        delegateAdapter = new DelegateAdapter(manager);

        delegateAdapter.setAdapters(adapters);
        mRecyclerView.setAdapter(delegateAdapter);
    }

}
