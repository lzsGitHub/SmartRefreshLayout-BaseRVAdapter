package com.example.r.refreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.r.refreshlayout.smartRV.BaseRecyclerAdapter;
import com.example.r.refreshlayout.smartRV.SmartViewHolder;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.Arrays;
import java.util.Collection;

import static com.example.r.refreshlayout.R.layout.test_item;

public class SmartActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private BaseRecyclerAdapter<Void> mBaseRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);
        RefreshLayout refreshLayout= (RefreshLayout) findViewById(R.id.activity_smart);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this)
        .setEnableLastTime(false)
                .setAccentColor(Color.parseColor("#fff4511e"))
        );
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                    refreshlayout.getLayout().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mBaseRecyclerAdapter.refresh(initData());
                            refreshlayout.finishRefresh();
                        }
                    },2000);
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                refreshlayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mBaseRecyclerAdapter.getItemCount()>30){
                            refreshlayout.setLoadmoreFinished(true);
                        }else {
                            mBaseRecyclerAdapter.loadmore(initData());
                            refreshlayout.finishLoadmore();
                        }
                    }
                },1000);
            }
        });
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mBaseRecyclerAdapter=new BaseRecyclerAdapter<Void>(test_item) {

            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Void model, int position) {
                holder.text(R.id.item_one,position+"条");
            }
        };
        mRecyclerView.setAdapter(mBaseRecyclerAdapter);
        refreshLayout.autoRefresh();
    }
    private Collection<Void> initData(){
        return Arrays.asList(null,null,null,null,null,null,null,null,null,null);
    }
}
