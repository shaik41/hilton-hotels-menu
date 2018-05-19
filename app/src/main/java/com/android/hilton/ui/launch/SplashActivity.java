package com.android.hilton.ui.launch;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.hilton.R;
import com.android.hilton.ui.inhousemenu.InHouseMenuActivity;

/**
 * Created by shaikatif on 1/19/18.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               startActivity(InHouseMenuActivity.getInHouseMenu(SplashActivity.this));
               finish();
            }
        },3000);
    }
}
