package com.example.r.refreshlayout.base;

/**
 * Created by lee on 2017/12/19.
 */

public abstract class RVBaseCell<T> implements Cell {
    public T mData;
    public RVBaseCell(T t) {
        mData=t;
    }

    @Override
    public void releaseResource() {
        //do nothing
    }
}
