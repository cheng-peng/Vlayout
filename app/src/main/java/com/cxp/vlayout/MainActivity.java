package com.cxp.vlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxp.vlayout.ui.AllActivity;
import com.cxp.vlayout.ui.ColumnLayoutHelperActivity;
import com.cxp.vlayout.ui.FixLayoutHelperActivity;
import com.cxp.vlayout.ui.FloatLayoutHelperActivity;
import com.cxp.vlayout.ui.GridLayoutHelperActivity;
import com.cxp.vlayout.ui.LinearLayoutHelperActivity;
import com.cxp.vlayout.ui.OnePlusNLayoutHelperActivity;
import com.cxp.vlayout.ui.ScrollFixLayoutHelperActivity;
import com.cxp.vlayout.ui.SingleLayoutHelperActivity;
import com.cxp.vlayout.ui.StaggeredGridLayoutHelperActivity;
import com.cxp.vlayout.ui.StickyLayoutHelperActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 单击事件
     * @param view
     */
    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.main_bt1:
                //线性布局
                startActivity(new Intent(this,LinearLayoutHelperActivity.class));
                break;
            case R.id.main_bt2:
                //网格布局
                startActivity(new Intent(this,GridLayoutHelperActivity.class));
                break;
            case R.id.main_bt3:
                //瀑布流布局
                startActivity(new Intent(this,StaggeredGridLayoutHelperActivity.class));
                break;
            case R.id.main_bt4:
                //固定布局
                startActivity(new Intent(this,FixLayoutHelperActivity.class));
                break;
            case R.id.main_bt5:
                //可选固定布局
                startActivity(new Intent(this,ScrollFixLayoutHelperActivity.class));
                break;
            case R.id.main_bt6:
                //栏格布局
                startActivity(new Intent(this,ColumnLayoutHelperActivity.class));
                break;
            case R.id.main_bt7:
                //通栏布局
                startActivity(new Intent(this,SingleLayoutHelperActivity.class));
                break;
            case R.id.main_bt8:
                //栏格布局
                startActivity(new Intent(this,OnePlusNLayoutHelperActivity.class));
                break;
            case R.id.main_bt9:
                //浮动布局
                startActivity(new Intent(this,FloatLayoutHelperActivity.class));
                break;
            case R.id.main_bt10:
                //吸边布局
                startActivity(new Intent(this,StickyLayoutHelperActivity.class));
                break;
            case R.id.main_bt11:
                //全部
                startActivity(new Intent(this,AllActivity.class));
                break;

        }
    }
}
