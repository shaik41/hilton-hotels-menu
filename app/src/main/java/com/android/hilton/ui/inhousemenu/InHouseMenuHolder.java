package com.android.hilton.ui.inhousemenu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.hilton.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shaikatif on 1/19/18.
 */

public class InHouseMenuHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.civ_in_house_menu_image)
    CircleImageView menuImage;
    @BindView(R.id.tv_in_house_menu_name)
    TextView menuName;

    public InHouseMenuHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

}
