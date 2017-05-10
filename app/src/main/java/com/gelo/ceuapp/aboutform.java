package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class aboutform extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutform);

        showabout();


    }

    private void showabout() {
        WebView wv = (WebView) findViewById(R.id.wv_about);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
        if (MainActivity.et_aboutt.getText().toString().equalsIgnoreCase("devs")) {
            wv.loadUrl("file:///android_asset/about.html");
        } else if (MainActivity.et_aboutt.getText().toString().equalsIgnoreCase("apps")) {
            wv.loadUrl("file:///android_asset/aboutapplication.html");
        } else if (MainActivity.et_aboutt.getText().toString().equalsIgnoreCase("disclaimer")) {
            wv.loadUrl("file:///android_asset/disclaimer.html");
        }
    }
}
