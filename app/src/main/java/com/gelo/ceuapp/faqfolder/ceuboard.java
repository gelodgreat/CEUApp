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

public class ceuboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceuboard);
        showboard();

        ImageButton floatButton = (ImageButton) findViewById(R.id.img_gohomeboard_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showboard() {
        WebView wv_showboard = (WebView) findViewById(R.id.wv_showboard);

        WebSettings webSettings = wv_showboard.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(false);
        wv_showboard.setBackgroundColor(15658734);
        wv_showboard.loadUrl("file:///android_asset/board_of_directors.html");
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
