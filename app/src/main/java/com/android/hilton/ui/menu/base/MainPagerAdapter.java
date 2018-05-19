package com.android.hilton.ui.menu.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.android.hilton.ui.menu.dining.area.DiningFragment;

/**
 * Created by shaikatif on 1/17/18.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return DiningFragment.getDiningFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
