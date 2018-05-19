package com.android.hilton.ui.inhousemenu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hilton.R;
import com.android.hilton.model.housemenu.HouseMenuModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shaikatif on 1/19/18.
 */

public class InHouseMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private  List<HouseMenuModel> houseMenus;
    private  IInHouseMenu iInHouseMenu;

    InHouseMenuAdapter(HouseMenuModel[] houseMenuModels,IInHouseMenu iInHouseMenu){
        this.houseMenus=new ArrayList<>();
        Collections.addAll(this.houseMenus,houseMenuModels);
        this.iInHouseMenu=iInHouseMenu;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inHouseMenuView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in_house_menu,parent,false);
        return new InHouseMenuHolder(inHouseMenuView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final InHouseMenuHolder inHouseMenuHolder= (InHouseMenuHolder) holder;
        inHouseMenuHolder.menuName.setText(houseMenus.get(position).menuName);
        Glide.with(inHouseMenuHolder.itemView.getContext())
                .load(houseMenus.get(position).menuImage)
                .into(inHouseMenuHolder.menuImage);

        inHouseMenuHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iInHouseMenu.onMenuSelected(houseMenus.get(inHouseMenuHolder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return houseMenus.size();
    }
}
