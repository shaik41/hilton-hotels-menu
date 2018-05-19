package com.android.hilton.ui.menu.dining.area;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.hilton.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shaikatif on 1/18/18.
 */

 class DiningAreaHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.civ_area_image)
    CircleImageView areaImage;
    @BindView(R.id.tv_area_name)
    TextView areaName;

     DiningAreaHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
