package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class developer_wu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_wu);
        aboutwu();
    }

    private void aboutwu() {
        WebView wv = (WebView) findViewById(R.id.wv_aboutwu);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);

        wv.loadUrl("file:///android_asset/wuabout.html");
    }
}

