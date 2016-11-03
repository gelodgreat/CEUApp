package com.gelo.ceuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class developer_viril extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_viril);
        aboutviril();
    }

    public void aboutviril(){
        WebView wv = (WebView)findViewById(R.id.wv_aboutviril);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);

        wv.loadUrl("file:///android_asset/rhejabout.html");
    }
}
