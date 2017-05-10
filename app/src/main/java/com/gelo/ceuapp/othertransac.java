package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class othertransac extends AppCompatActivity {

    public static EditText et_choosetransac;
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othertransac);
        onClickTransactionOn();

        MobileAds.initialize(getApplicationContext(), getString(R.string.ad_app_id));
    }

    private void onClickTransactionOn() {
        Button btn_crossenroll = (Button) findViewById(R.id.btn_crossenroll);
        Button btn_eval = (Button) findViewById(R.id.btn_evaluation);
        Button btn_id = (Button) findViewById(R.id.btn_id);
        Button btn_promi = (Button) findViewById(R.id.btn_promisorry);
        Button btn_read = (Button) findViewById(R.id.btn_readmission);
        Button btn_refund = (Button) findViewById(R.id.btn_refund);
        Button btn_shifting = (Button) findViewById(R.id.btn_shifting);
        et_choosetransac = (EditText) findViewById(R.id.et_chooseothertransac);
        Button btn_addndrop = (Button) findViewById(R.id.btn_addndrop);

        btn_crossenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("cross");
                startActivity(intent);
            }
        });
        btn_eval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("eval");
                startActivity(intent);
            }
        });
        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("id");
                startActivity(intent);
            }
        });
        btn_promi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("promi");
                startActivity(intent);
            }
        });
        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("read");
                startActivity(intent);
            }
        });
        btn_refund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("refund");
                startActivity(intent);
            }
        });
        btn_shifting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("shift");
                startActivity(intent);
            }
        });
        btn_addndrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.commencetransac");
                et_choosetransac.setText("add");
                startActivity(intent);
            }
        });


        AdRequest adRequest = new AdRequest.Builder()
                //                .addTestDevice(getString(R.string.test_device_id))
                .build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(othertransac.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_interstitial2));

        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });


    }

    private void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
