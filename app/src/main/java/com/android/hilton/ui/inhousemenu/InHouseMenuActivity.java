package com.android.hilton.ui.inhousemenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.hilton.R;
import com.android.hilton.model.housemenu.HouseMenuModel;
import com.android.hilton.util.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaikatif on 1/18/18.
 */

public class InHouseMenuActivity extends AppCompatActivity implements IInHouseMenu {

    public static Intent getInHouseMenu(Context context) {
        return new Intent(context, InHouseMenuActivity.class);
    }

    @BindView(R.id.rv_in_house_menu)
    RecyclerView inHouseListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setAdapterToInHouseList();
    }

    private void setAdapterToInHouseList() {
        inHouseListView.setLayoutManager(new LinearLayoutManager(this));
        inHouseListView.setAdapter(new InHouseMenuAdapter(DataUtils.getInHouseMenuModel(this), this));
    }


    @Override
    public void onMenuSelected(HouseMenuModel houseMenuModel) {
        switch (houseMenuModel.menuName) {
            case "DINING":
                startActivity(MenuOptionsActivity.getOptionsActivity(InHouseMenuActivity.this));
                break;

        }
    }
}


