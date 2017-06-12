package com.gelo.ceuapp.faqfolder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.gelo.ceuapp.MainActivity;
import com.gelo.ceuapp.R;

public class listoffenses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listoffenses);
        condition();


        ImageButton floatButton = (ImageButton) findViewById(R.id.img_offenses_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void condition() {

        WebView wv = (WebView) findViewById(R.id.wv_listoffenses);

        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);

        if (Offenses.et_off.getText().toString().equalsIgnoreCase("minor")) {
            wv.loadUrl("file:///android_asset/slight_offenses.html");

        } else if (Offenses.et_off.getText().toString().equalsIgnoreCase("less")) {
            wv.loadUrl("file:///android_asset/less_serious_offenses.html");

        } else if (Offenses.et_off.getText().toString().equalsIgnoreCase("serious")) {
            wv.loadUrl("file:///android_asset/serious_offenses.html");

        } else if (Offenses.et_off.getText().toString().equalsIgnoreCase("other")) {
            wv.loadUrl("file:///android_asset/other_offenses_and_sanctions.html");

        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
