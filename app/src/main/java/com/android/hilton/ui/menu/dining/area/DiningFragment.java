package com.android.hilton.ui.menu.dining.area;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.hilton.R;
import com.android.hilton.model.dining.DiningModel;
import com.android.hilton.ui.menu.dining.menu.DiningMenuDialog;
import com.android.hilton.ui.menu.dining.menu.IDiningMenu;
import com.android.hilton.util.DataUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaikatif on 1/17/18.
 */

public class DiningFragment extends Fragment implements  DiningListListener,IDiningDetail,IDiningMenu{

    @BindView(R.id.rv_dining)
    RecyclerView diningListView;

    public static DiningFragment getDiningFragment() {
        return new DiningFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View diningView= inflater.inflate(R.layout.fragment_dining, container, false);
        ButterKnife.bind(this,diningView);
        return diningView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapterToDiningList();
    }

    private void setAdapterToDiningList() {
        diningListView.setLayoutManager(new LinearLayoutManager(getContext()));
        diningListView.setAdapter(new DiningListAdapter(this, DataUtils.getDiningModel(getContext())));
    }

    @Override
    public void onDiningAreaSelected(DiningModel diningModel) {
        new DiningDetailDialog(getContext()).showDiningDetails(diningModel,this);
    }

    @Override
    public void onMenuSelected(String url) {
       // startActivity(PDFWebViewActivity.getPDFActivityIntent(getContext(),"Menu",url.trim()));
       openCustomTab(url);

    }

    private void openCustomTab(String url) {
        String UURL=url.trim();
        Uri uri = Uri.parse(UURL);

// create an intent builder
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();

// Begin customizing

// set toolbar colors
        intentBuilder.setToolbarColor(Color.WHITE);
        intentBuilder.setShowTitle(false);
        intentBuilder.setSecondaryToolbarColor(Color.YELLOW);

// set start and exit animations
        intentBuilder.setStartAnimations(getContext(), android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        intentBuilder.setExitAnimations(getContext(), android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
// build custom tabs intent
        CustomTabsIntent customTabsIntent = intentBuilder.build();

// launch the url
        customTabsIntent.launchUrl(getActivity(), uri);
    }

    @Override
    public void onDiningMenuClicked(List<String> foodMenu) {
        new DiningMenuDialog(getContext()).showFoodMenu(foodMenu,this);
    }

    @Override
    public void onBookATableClick(String url) {
        if(url.trim().isEmpty()){
            return;
        }
        openCustomTab(url.trim());

    }

    @Override
    public void onMoreInfoClick(String url) {
        if(url.trim().isEmpty()){
            return;
        }
        openCustomTab(url.trim());
    }
}
