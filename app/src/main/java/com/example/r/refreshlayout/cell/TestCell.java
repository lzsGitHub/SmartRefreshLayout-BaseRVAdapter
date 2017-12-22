package com.example.r.refreshlayout.cell;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.r.refreshlayout.R;
import com.example.r.refreshlayout.base.RVBaseCell;
import com.example.r.refreshlayout.base.RVBaseViewHolder;

import java.util.List;

/**
 * Created by ${Lee} on 2017/12/20.
 */

public class TestCell extends RVBaseCell<List<String>>{
    public static final int TYPE=4;

    public TestCell(List<String> strings) {
        super(strings);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        holder.setText(R.id.item_one,mData.get(position).toString());
    }
}
