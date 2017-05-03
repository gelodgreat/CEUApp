package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class North_Gate_Navigation extends AppCompatActivity {

    private ImageButton floatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north__gate__navigation);


        floatButton = (ImageButton) findViewById(R.id.img_navnorth_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        WebView wv = (WebView) findViewById(R.id.wv_north_nav_gif);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);

        if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Dent Sci")) {
            wv.loadUrl("file:///android_asset/ng_to_dentsci.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FGH")) {
            wv.loadUrl("file:///android_asset/ng_to_fgh_w_dentonly.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("LAH")) {
            wv.loadUrl("file:///android_asset/ng_to_lah.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("CAH")) {
            wv.loadUrl("file:///android_asset/ng_to_cah.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("CDL")) {
            wv.loadUrl("file:///android_asset/ng_to_cdl.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Chapel")) {
            wv.loadUrl("file:///android_asset/ng_to_chapel.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("DCTH")) {
            wv.loadUrl("file:///android_asset/ng_to_dcth.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FFH")) {
            wv.loadUrl("file:///android_asset/ng_to_ffh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FSH")) {
            wv.loadUrl("file:///android_asset/ng_to_fsh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("GDLSC")) {
            wv.loadUrl("file:///android_asset/ng_to_gdlsc.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("ISC")) {
            wv.loadUrl("file:///android_asset/ng_to_isc.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("MVH")) {
            wv.loadUrl("file:///android_asset/ng_to_mvh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("PHLH")) {
            wv.loadUrl("file:///android_asset/ng_to_phlh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("SAC")) {
            wv.loadUrl("file:///android_asset/ng_to_sac.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("SDVH")) {
            wv.loadUrl("file:///android_asset/ng_to_sdvh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Tech Center")) {
            wv.loadUrl("file:///android_asset/ng_to_tc.html");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        WebView wv = (WebView) findViewById(R.id.wv_north_nav_gif);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);


        if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Dent Sci")) {
            wv.loadUrl("file:///android_asset/ng_to_dentsci.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FGH")) {
            wv.loadUrl("file:///android_asset/ng_to_fgh_w_dentonly.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("LAH")) {
            wv.loadUrl("file:///android_asset/ng_to_lah.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("CAH")) {
            wv.loadUrl("file:///android_asset/ng_to_cah.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("CDL")) {
            wv.loadUrl("file:///android_asset/ng_to_cdl.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Chapel")) {
            wv.loadUrl("file:///android_asset/ng_to_chapel.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("DCTH")) {
            wv.loadUrl("file:///android_asset/ng_to_dcth.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FFH")) {
            wv.loadUrl("file:///android_asset/ng_to_ffh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("FSH")) {
            wv.loadUrl("file:///android_asset/ng_to_fsh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("GDLSC")) {
            wv.loadUrl("file:///android_asset/ng_to_gdlsc.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("ISC")) {
            wv.loadUrl("file:///android_asset/ng_to_isc.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("MVH")) {
            wv.loadUrl("file:///android_asset/ng_to_mvh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("PHLH")) {
            wv.loadUrl("file:///android_asset/ng_to_phlh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("SAC")) {
            wv.loadUrl("file:///android_asset/ng_to_sac.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("SDVH")) {
            wv.loadUrl("file:///android_asset/ng_to_sdvh.html");
        } else if (MainFragment.retainn.getText().toString().equalsIgnoreCase("Tech Center")) {
            wv.loadUrl("file:///android_asset/ng_to_tc.html");
        }
    }

}