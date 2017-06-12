package com.gelo.ceuapp.buildings;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gelo.ceuapp.R;

public class tech_center extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tech_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView tv = (WebView) findViewById(R.id.scroll_wv_tech_center_info);
        WebSettings webSettings = tv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        tv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
        tv.loadUrl("file:///android_asset/TC_Info.html");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(tech_center.this).setTitle("Start Location").setMessage("Where do you want to start?").setPositiveButton("South Gate", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(tech_center.this, Navigation_Gif.class);
                        startActivity(i);
                    }
                }).setNegativeButton("North Gate", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(tech_center.this, North_Gate_Navigation.class);
                        startActivity(i);
                    }
                })

                        .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).setIcon(android.R.drawable.ic_menu_directions).show();

            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}