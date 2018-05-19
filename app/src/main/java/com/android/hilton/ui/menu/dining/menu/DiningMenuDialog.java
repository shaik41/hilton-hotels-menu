package com.android.hilton.ui.menu.dining.menu;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.hilton.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaikatif on 1/18/18.
 */

public class DiningMenuDialog extends AlertDialog  {
    @BindView(R.id.rv_dining_menu)
    RecyclerView diningMenuListView;
    @BindView(R.id.tv_close)
    TextView closeView;

    public DiningMenuDialog(Context context) {
        super(context);
    }

    public void showFoodMenu(List<String> foodMenu,final IDiningMenu iDiningMenu){
        View foodMenuView= LayoutInflater.from(getContext()).inflate(R.layout.dialog_dining_menu,null,false);
        ButterKnife.bind(this,foodMenuView);
        setView(foodMenuView);
        setAdapterToDiningMenu(foodMenu,iDiningMenu);
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        show();
    }

    private void setAdapterToDiningMenu(List<String> foodMenu,IDiningMenu iDiningMenu) {
        diningMenuListView.setLayoutManager(new LinearLayoutManager(getContext()));
        if(foodMenu==null||foodMenu.size()==0){
            foodMenu=new ArrayList<>();
             foodMenu.add("Sorry, the menu is unavailable");
        }
        diningMenuListView.setAdapter(new DiningMenuAdapter(foodMenu,iDiningMenu));
    }


}
