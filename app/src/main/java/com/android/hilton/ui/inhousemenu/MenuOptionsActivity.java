package com.android.hilton.ui.inhousemenu;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.hilton.R;
import com.android.hilton.ui.menu.base.MainPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuOptionsActivity extends AppCompatActivity {

    public static Intent getOptionsActivity(Context context) {
        return new Intent(context,MenuOptionsActivity.class);
    }

    @BindView(R.id.vp_launch)
    ViewPager launchViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
        setLaunchPagerAdapter();
    }

    private void setLaunchPagerAdapter() {
        launchViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        launchViewPager.addOnPageChangeListener(pageChangeListener);
    }

    private ViewPager.OnPageChangeListener pageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //TODO
        }

        @Override
        public void onPageSelected(int position) {
            //TODO
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //TODO
        }
    };

}
