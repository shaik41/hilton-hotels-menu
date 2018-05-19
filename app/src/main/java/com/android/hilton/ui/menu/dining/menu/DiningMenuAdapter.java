package com.android.hilton.ui.menu.dining.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hilton.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaikatif on 1/18/18.
 */

public class DiningMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String > foodMenuURLs;
    private IDiningMenu iDiningMenu;

    DiningMenuAdapter(List<String> foodMenuURLs,IDiningMenu iDiningMenu){
        this.iDiningMenu=iDiningMenu;
        this.foodMenuURLs=new ArrayList<>(foodMenuURLs);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View diningMenu= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dining_menu_item,parent,false);
        return new DiningMenuHolder(diningMenu);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final DiningMenuHolder diningMenuHolder= (DiningMenuHolder) holder;
        if(foodMenuURLs!=null&&foodMenuURLs.size()>0) {
            final String[] menuDetails = foodMenuURLs.get(position).split(";");
            diningMenuHolder.menuName.setText(menuDetails[0]);
            if(menuDetails.length>1) {
                diningMenuHolder.menuName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        iDiningMenu.onMenuSelected(menuDetails[1]);
                    }
                });
            }
        }


    }

    @Override
    public int getItemCount() {
        return foodMenuURLs.size();
    }


}
