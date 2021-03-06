package com.example.r.refreshlayout.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.r.refreshlayout.R;
import com.example.r.refreshlayout.base.RVBaseViewHolder;
import com.example.r.refreshlayout.base.RVSimpleAdapter;


public class EmptyCell extends RVAbsStateCell {

    public EmptyCell(Object o) {
        super(o);
    }


    @Override
    public int getItemType() {
        return RVSimpleAdapter.EMPTY_TYPE;
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {

    }

    @Override
    protected View getDefaultView(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.rv_empty_layout,null);
    }
}
