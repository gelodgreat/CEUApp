package com.gelo.ceuapp.aboutfolder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gelo.ceuapp.R;

public class Disclaimer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);

        WebView wv = (WebView) findViewById(R.id.webView1);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
        if (about.et_about.getText().toString().equalsIgnoreCase("disclaimer")) {
            wv.loadUrl("file:///android_asset/disclaimer.html");
        } else if (about.et_about.getText().toString().equalsIgnoreCase("apps")) {
            wv.loadUrl("file:///android_asset/aboutapplication.html");
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
