package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Information extends AppCompatActivity {

    ImageButton floatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        showinformation();

        floatButton = (ImageButton) findViewById(R.id.img_infocollege_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        showinformation();
    }

    public void showinformation() {
        WebView wv = (WebView) findViewById(R.id.wv_information);

        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);

        this.setTitle(Colleges.title);

        if (this.getTitle().toString().equalsIgnoreCase("School of Science and Technology")) {
            wv.loadUrl("file:///android_asset/scitechInfo_hamili.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("School of Pharmacy")) {
            wv.loadUrl("file:///android_asset/pharmaInfo_hamili.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("School of Dentistry")) {
            wv.loadUrl("file:///android_asset/dentistryInfo_hamili.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Optometry")) {
            wv.loadUrl("file:///android_asset/optometryInfo_hamili.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Medical Technology")) {
            wv.loadUrl("file:///android_asset/mtinfo_umali.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Graduate School")) {
            wv.loadUrl("file:///android_asset/gradschoolinfo_umali.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Nursing")) {
            wv.loadUrl("file:///android_asset/nursinginfo_umali.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Accountancy and Management")) {
            wv.loadUrl("file:///android_asset/saminfo_umali.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Education-Liberal Arts-Music-Social Work")) {
            wv.loadUrl("file:///android_asset/selamsinfo_umali.html");
        } else if (this.getTitle().toString().equalsIgnoreCase("College of Nutrition and Hospitality Management")) {
            wv.loadUrl("file:///android_asset/nhminfo_umali.html");
        }


    }


}
