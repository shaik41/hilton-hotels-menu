package com.android.hilton.ui.menu.dining.area;

import java.util.List;

/**
 * Created by shaikatif on 1/18/18.
 */

public interface IDiningDetail {
    void  onDiningMenuClicked(List<String> foodMenu);
    void onBookATableClick(String url);
    void onMoreInfoClick(String url);
}
