package com.cxp.vlayout.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.cxp.vlayout.R;
import com.cxp.vlayout.adapter.DelegateRecyclerAdapter;

/**
 * 文 件 名: GridLayoutHelperActivity
 * 创 建 人: CXP
 * 创建日期: 2018-04-27 20:40
 * 描    述: 网格布局
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class GridLayoutHelperActivity extends Activity{

    public RecyclerView mRecyclerView;
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

        adapter.addAdapter(init(this));
        mRecyclerView.setAdapter(adapter);
    }

    //网格布局初始化
    public static DelegateRecyclerAdapter init(Context context){
        GridLayoutHelper gridLayoutHelper=new GridLayoutHelper(4);
        gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position >5) {
                    return 2;
                }else {
                    return 1;
                }
            }
        });
        gridLayoutHelper.setAutoExpand(false);
        return new DelegateRecyclerAdapter(context,gridLayoutHelper,"GridLayoutHelper");
    }


}
