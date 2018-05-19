package com.android.hilton.ui.menu.dining.area;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hilton.R;
import com.android.hilton.model.dining.DiningModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shaikatif on 1/17/18.
 */

public class DiningListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<DiningModel> diningModels;
    private DiningListListener iDiningListListener;

    DiningListAdapter(DiningListListener iDiningListListener, DiningModel[] diningModels){
        this.iDiningListListener=iDiningListListener;
        this.diningModels=new ArrayList<>();
        Collections.addAll(this.diningModels,diningModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View diningAreaView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dining_item,parent,false);
        return new DiningAreaHolder(diningAreaView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DiningAreaHolder diningAreaHolder= (DiningAreaHolder) holder;
        final DiningModel diningModel=diningModels.get(position);
        diningAreaHolder.areaName.setText(diningModel.areaName);
        Glide.with(diningAreaHolder.itemView.getContext())
                .load(diningModel.areaImage)
                .into(diningAreaHolder.areaImage);
        diningAreaHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iDiningListListener.onDiningAreaSelected(diningModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return diningModels.size();
    }

}
