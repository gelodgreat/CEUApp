package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class developer_hamili extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_hamili);
        abouthamili();
    }

    private void abouthamili() {
        WebView wv = (WebView) findViewById(R.id.wv_abouthamili);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);

        wv.loadUrl("file:///android_asset/hamiliabout.html");
    }
}
