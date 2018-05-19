package com.android.hilton.ui.menu.dining.area;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.hilton.R;
import com.android.hilton.model.dining.DiningModel;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shaikatif on 1/18/18.
 */

public class DiningDetailDialog extends AlertDialog {
    @BindView(R.id.tv_area_name)
    TextView areaName;
    @BindView(R.id.tv_area_description)
    TextView areaDescription;
    @BindView(R.id.civ_area_image)
    CircleImageView areaImage;
    @BindView(R.id.tv_area_availability)
    TextView areaAvailability;
    @BindView(R.id.ll_menu)
    LinearLayout menuView;
    @BindView(R.id.ll_table)
    LinearLayout bookTableView;
    @BindView(R.id.ll_more_info)
    LinearLayout moreInfoView;
    @BindView(R.id.tv_close)
    TextView closeView;



    protected DiningDetailDialog(Context context) {
        super(context);
    }

    public void showDiningDetails(final DiningModel diningModel,final IDiningDetail iDiningDetail){
        View diningDetailView= LayoutInflater.from(getContext()).inflate(R.layout.dialog_dining_detail,null,false);
        ButterKnife.bind(this,diningDetailView);
        setView(diningDetailView);
        areaName.setText(diningModel.areaName);
        areaDescription.setText(diningModel.areaDescription);
        areaAvailability.setText(diningModel.areaAvailabilityTime);
        Glide.with(getContext()).load(diningModel.areaImage).into(areaImage);
        menuView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iDiningDetail.onDiningMenuClicked(diningModel.foodMenuPDFURLs);
            }
        });

        if(diningModel.bookATableURL.isEmpty()){
            bookTableView.setVisibility(View.GONE);
        }
        bookTableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iDiningDetail.onBookATableClick(diningModel.bookATableURL);
            }
        });
        moreInfoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iDiningDetail.onMoreInfoClick("http://www3.hilton.com/en/hotels/uae/hilton-dubai-jumeirah-DXBJBHI/dining/index.html");
            }
        });

        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        show();

    }
}
