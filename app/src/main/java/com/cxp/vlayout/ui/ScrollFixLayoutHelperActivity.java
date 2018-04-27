package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.DelegateRecyclerAdapter;
import com.cxp.vlayout.adapter.FixLayoutAdapter;

/**
 * 文 件 名: ScrollFixLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 21:21
 * 描    述: 可选固定布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class ScrollFixLayoutHelperActivity extends Activity{

    private RecyclerView recyclerview;
    private DelegateAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        recyclerview=findViewById(R.id.recyclerview);

        //绑定VirtualLayoutManager
        VirtualLayoutManager manager = new VirtualLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        adapter =new DelegateAdapter(manager, true);

        adapter.addAdapter(initScrollFixLayout(this));
        adapter.addAdapter(initLinearLayout(this));
        recyclerview.setAdapter(adapter);
    }

    public DelegateRecyclerAdapter initLinearLayout(Context context){
        LinearLayoutHelper linearLayoutHelper=new LinearLayoutHelper();
        return new DelegateRecyclerAdapter(context,linearLayoutHelper,"ScrollFixLayoutHelper");
    }

    //可选固定布局初始化
    public static FixLayoutAdapter initScrollFixLayout(Context context){
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(15,15);
        //show_always:总是显示
        //show_on_enter:当页面滚动到这个视图的位置的时候，才显示
        //show_on_leave:当页面滚出这个视图的位置的时候显示
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        return new FixLayoutAdapter(context, scrollFixLayoutHelper,"scrollfixlayouthelper");
    }

}
