package com.gelo.ceuapp;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;

public class ceumusic extends AppCompatActivity implements View.OnClickListener{

    ImageButton floatButton;
    ImageButton play;
    ImageButton pause;
    ImageButton stop;
    MediaPlayer mp;
    WebView wv;
    String a=new String("false");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ceumusic);

        wv = (WebView)findViewById(R.id.wv_listmusic);

        mp=MediaPlayer.create(this, R.raw.ceuhymn);
        //mp.setLooping(true);

        floatButton = (ImageButton)findViewById(R.id.img_ceumusic_float);
        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);

        play=(ImageButton)findViewById(R.id.imgb_play);
        play.setOnClickListener(this);

        pause=(ImageButton)findViewById(R.id.imgb_pause);
        pause.setOnClickListener(this);






        if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("elcollar")){
            mp=MediaPlayer.create(this, R.raw.elcollar);
            mp.start();
            wv.loadUrl("file:///android_asset/el_collar_de_sampaguita.html");
        }
        else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("laflor")){
            mp=MediaPlayer.create(this, R.raw.salaflor);
            mp.start();
            wv.loadUrl("file:///android_asset/sampaguita_la_flor_de_manila.html");
        }
        else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("mabango")){
            mp=MediaPlayer.create(this, R.raw.samabango);
            mp.start();
            wv.loadUrl("file:///android_asset/sampaguitang_mabango.html");
        }
        else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("hymn")){
            mp=MediaPlayer.create(this, R.raw.ceuhymn);
            mp.start();
            wv.loadUrl("file:///android_asset/CEUHymn.html");
        }



    }

    @Override
    public void onClick(View v) {
        if (v==play){

            if (a=="true"){
                mp.reset();
                if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("elcollar")){
                    mp=MediaPlayer.create(this, R.raw.elcollar);

                }
                else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("laflor")){
                    mp=MediaPlayer.create(this, R.raw.salaflor);
                    mp.start();
                    wv.loadUrl("file:///android_asset/sampaguita_la_flor_de_manila.html");
                }
                else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("mabango")){
                    mp=MediaPlayer.create(this, R.raw.samabango);

                }
                else if (ceuchoosemusic.et_choosemusic.getText().toString().equalsIgnoreCase("hymn")){
                    mp=MediaPlayer.create(this, R.raw.ceuhymn);

                }
                mp.start();
            }else{

                mp.start();
                a="true";

            }
        }else if(v==pause){
            if (mp.isPlaying()){
                mp.pause();
                a="false";
            }


        }
    }

    public void onBackPressed() {
        mp.stop();
        super.onBackPressed();
    }
}
