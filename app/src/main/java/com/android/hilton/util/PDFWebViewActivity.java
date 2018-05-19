package com.android.hilton.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.android.hilton.R;

public class PDFWebViewActivity extends AppCompatActivity {

    public static Intent getPDFActivityIntent(Context context,String menuName,String menuURL) {
       Intent intent=new Intent(context,PDFWebViewActivity.class);
       intent.putExtra(AppConstants.KEY_PLAN_URL,menuURL);
       intent.putExtra(AppConstants.KEY_PLAN_NAME,menuName);
       return intent;
    }

    private static final int MAX_CLICK_DURATION = 1000;

    /**
     * Max allowed distance to move during a "click", in DP.
     */
    private static final int MAX_CLICK_DISTANCE = 15;

    private long pressStartTime;
    private float pressedX;
    private float pressedY;

    WebView pdfWebView;

    private boolean isPageFinished;
    private String planURL;
    private String planName;
    private ProgressDialog progressDialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_pdf_view);
        getIntenData();
        intViews();
        loadPDFWebView();


    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    private void intViews(){
        pdfWebView = (WebView) findViewById(R.id.webview);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(planName);
        }
    }

    private void loadPDFWebView(){
        pdfWebView.getSettings().setJavaScriptEnabled(true);
        pdfWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return !isPageFinished;
            }
        });

        pdfWebView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + planURL);
        pdfWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if(progressDialog!=null&& progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                progressDialog=ProgressDialog.show(PDFWebViewActivity.this,"Loading Menu","Please wait.");
                isPageFinished=false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(!url.contains("/viewerng/viewer")){
                    view.loadUrl(url);
                }
                return true;
            }

            @Override
            public void onPageFinished(WebView view, final String url) {
                if(progressDialog!=null&& progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                pdfWebView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('ndfHFb-c4YZDc-GSQQnc-LgbsSe ndfHFb-c4YZDc-to915-LgbsSe VIpgJd-TzA9Ye-eEGnhe ndfHFb-c4YZDc-LgbsSe')[0].style.display='none'; })()");
                webViewClick(url);
                isPageFinished = true;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void webViewClick(final String pdfURL){

        final Bundle pdfState;
        pdfState = new Bundle();
        pdfWebView.saveState(pdfState);

        pdfWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        pressStartTime = System.currentTimeMillis();
                        pressedX = event.getX();
                        pressedY = event.getY();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        long pressDuration = System.currentTimeMillis() - pressStartTime;
                        if (pressDuration < MAX_CLICK_DURATION && distance(pressedX, pressedY, event.getX(), event.getY()) < MAX_CLICK_DISTANCE) {
                        }
                    }
                }
                return false;
            }
        });

    }

    private float distance(float x1, float y1, float x2, float y2) {
        float dx = x1 - x2;
        float dy = y1 - y2;
        float distanceInPx = (float) Math.sqrt(dx * dx + dy * dy);
        return pxToDp(distanceInPx);
    }

    private float pxToDp(float px) {
        return px / getResources().getDisplayMetrics().density;
    }


    public void getIntenData() {
        planURL=getIntent().getStringExtra(AppConstants.KEY_PLAN_URL);
        planName=getIntent().getStringExtra(AppConstants.KEY_PLAN_NAME);
    }
}
