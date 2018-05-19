package com.android.hilton.ui.menu.dining.menu;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.hilton.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaikatif on 1/18/18.
 */

public class DiningMenuHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_menu_name)
    TextView menuName;
    public DiningMenuHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
