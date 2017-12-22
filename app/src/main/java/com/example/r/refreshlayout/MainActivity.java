package com.example.r.refreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.r.refreshlayout.base.Cell;
import com.example.r.refreshlayout.base.RVSimpleAdapter;
import com.example.r.refreshlayout.cell.TestCell;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerview;
    protected RVSimpleAdapter mBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RefreshLayout refreshLayout= (RefreshLayout) findViewById(R.id.activity_main);
        //设置 Header 为 Material样式
        refreshLayout.setRefreshHeader(new ClassicsHeader(this).setAccentColor(Color.parseColor("#fff4511e")));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                    refreshlayout.finishRefresh(2000,true);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                    refreshlayout.getLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mBaseAdapter.addAll(getCell());
                            refreshlayout.finishLoadmore();
                        }
                    },2000);

            }
        });
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerview.setLayoutManager(initLayoutManager());
        mBaseAdapter=initAdapter();
        mRecyclerview.setAdapter(mBaseAdapter);
        mBaseAdapter.addAll(getCell());
    }

    private RecyclerView.LayoutManager initLayoutManager() {
        LinearLayoutManager manager=new LinearLayoutManager(MainActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        return manager;
    }
    protected RVSimpleAdapter initAdapter(){
        return new RVSimpleAdapter();
    }
    List<String> list=new ArrayList<>();
    List<Cell> cells=new ArrayList<>();
    private List<Cell> getCell(){
        if (list.size()==20){
            for (int i = 20; i < 40; i++) {
                list.add("str"+i);
                cells.add(new TestCell(list));
            }
            return cells;
        }
        if (list.size()>=40){
            return cells;
        }
        for (int i = 0; i < 20; i++) {
            list.add("str"+i);
            cells.add(new TestCell(list));
        }
        return cells;
    }
}
