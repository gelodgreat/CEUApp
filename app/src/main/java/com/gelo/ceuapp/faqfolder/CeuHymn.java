package com.gelo.ceuapp.faqfolder;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.gelo.ceuapp.R;

import java.util.Objects;

public class CeuHymn extends AppCompatActivity implements View.OnClickListener {

    private ImageButton play;
    private ImageButton pause;
    TextView lyrics;
    ScrollView scr;
    private MediaPlayer mp;
    private String a = "false";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceu_hymn);
        mp = MediaPlayer.create(this, R.raw.ceuhymn);
        mp.setLooping(true);
        mp.start();

        LinearLayout layout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(75, 75, 100);
        RelativeLayout rellayout = new RelativeLayout(this);
        WebView lyrics = new WebView(this);


        play = new ImageButton(this);
        play.setBackgroundResource(R.drawable.play);
        play.setLayoutParams(layoutparams);
        play.setOnClickListener(this);

        pause = new ImageButton(this);
        pause.setBackgroundResource(R.drawable.pause);
        pause.setLayoutParams(layoutparams);
        pause.setOnClickListener(this);

        ImageButton stop = new ImageButton(this);
        stop.setBackgroundResource(R.drawable.stop);
        stop.setLayoutParams(layoutparams);
        stop.setOnClickListener(this);

        lyrics.loadUrl("file:///android_asset/CEUHymn.html");


        rellayout.addView(lyrics);


        layout.addView(play);
        layout.addView(pause);
        layout.addView(stop);
        rellayout.addView(layout);


        setContentView(rellayout);


    }


    @Override
    public void onClick(View v) {


        if (v == play) {

            if (Objects.equals(a, "true")) {
                mp.reset();
                mp = MediaPlayer.create(this, R.raw.ceuhymn);
                mp.start();
            } else {

                mp.start();
                a = "true";

            }
        } else if (v == pause) {
            if (mp.isPlaying()) {
                mp.pause();
                a = "false";
            }


        } else {
            mp.stop();
            a = "true";
            //super.onBackPressed();
        }
    }

    public void onBackPressed() {
        mp.stop();
        finish();
    }

}
