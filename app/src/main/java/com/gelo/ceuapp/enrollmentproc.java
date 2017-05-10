package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class enrollmentproc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollmentproc);

        showwv();


        ImageButton floatButton = (ImageButton) findViewById(R.id.img_enrollproc_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showwv() {

        WebView wv = (WebView) findViewById(R.id.wv_enroll);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);

        if (chooseenroll.et_enroll.getText().toString().equalsIgnoreCase("fresh")) {
            wv.loadUrl("file:///android_asset/enrollment_freshmen.html");
        } else if (chooseenroll.et_enroll.getText().toString().equalsIgnoreCase("alien")) {
            wv.loadUrl("file:///android_asset/enrollment_aliens_nonresident_ofw.html");
        } else if (chooseenroll.et_enroll.getText().toString().equalsIgnoreCase("seconddeg")) {
            wv.loadUrl("file:///android_asset/enrollment_second_degree.html");
        } else if (chooseenroll.et_enroll.getText().toString().equalsIgnoreCase("transferee")) {
            wv.loadUrl("file:///android_asset/enrollment_transferees.html");
        } else if (chooseenroll.et_enroll.getText().toString().equalsIgnoreCase("continuing")) {
            wv.loadUrl("file:///android_asset/enrollment_continuing_students.html");
        }
    }
}
