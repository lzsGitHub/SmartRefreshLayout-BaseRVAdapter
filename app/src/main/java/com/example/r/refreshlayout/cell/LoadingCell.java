package com.example.r.refreshlayout.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.r.refreshlayout.R;
import com.example.r.refreshlayout.base.RVBaseViewHolder;
import com.example.r.refreshlayout.base.RVSimpleAdapter;


public class LoadingCell extends RVAbsStateCell {
    public LoadingCell(Object o) {
        super(o);
    }

    @Override
    public int getItemType() {
        return RVSimpleAdapter.LOADING_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.rv_loading_layout,null);
    }
}
