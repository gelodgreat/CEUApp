package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class commencetransac extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commencetransac);
        commencetransac();

        ImageButton floatButton = (ImageButton) findViewById(R.id.img_commencetransac_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void commencetransac() {
        WebView wv_commencetransac = (WebView) findViewById(R.id.wv_commencetransac);

        WebSettings webSettings = wv_commencetransac.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv_commencetransac.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);

        if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("cross")) {
            wv_commencetransac.loadUrl("file:///android_asset/cross_enroll.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("eval")) {
            wv_commencetransac.loadUrl("file:///android_asset/evaluation_for_grad.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("add")) {
            wv_commencetransac.loadUrl("file:///android_asset/add_drop_subjects.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("id")) {
            wv_commencetransac.loadUrl("file:///android_asset/id.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("promi")) {
            wv_commencetransac.loadUrl("file:///android_asset/promissory_note.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("read")) {
            wv_commencetransac.loadUrl("file:///android_asset/readmission.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("refund")) {
            wv_commencetransac.loadUrl("file:///android_asset/refund.html");
        } else if (othertransac.et_choosetransac.getText().toString().equalsIgnoreCase("shift")) {
            wv_commencetransac.loadUrl("file:///android_asset/shifting.html");
        }

    }
}
