package com.example.r.refreshlayout.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.adapter.CBPageAdapter;
import com.bigkoo.convenientbanner.adapter.CBViewHolderCreator;
import com.example.r.refreshlayout.R;
import com.example.r.refreshlayout.base.RVBaseCell;
import com.example.r.refreshlayout.base.RVBaseViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by ${Lee} on 2017/12/19.
 */

/**
 * Banner类型的item 例子2
 */
public class BannerCell extends RVBaseCell<List<String>> {
    public static final int TYPE = 2;
    private ConvenientBanner mConvenientBanner;
    public BannerCell(List<String> strings) {
        super(strings);
    }

    @Override
    public int getItemType() {
        return TYPE;
    }

    @Override
    public RVBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RVBaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell_layoout,null));
    }

    @Override
    public void onBindViewHolder(RVBaseViewHolder holder, int position) {
        mConvenientBanner = (ConvenientBanner) holder.getView(R.id.banner);
        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, mData);
        mConvenientBanner.startTurning(2000);
    }

    @Override
    public void releaseResource() {
        if(mConvenientBanner!=null){
            mConvenientBanner.stopTurning();
        }
    }

    public static class NetworkImageHolderView implements CBPageAdapter.Holder<String>{
        private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            ImageLoader.getInstance().displayImage(data,imageView);
        }
    }
}

