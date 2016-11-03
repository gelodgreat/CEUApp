package com.gelo.ceuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ceuchoosemusic extends AppCompatActivity {

    public static Button btn_elcollar,btn_laflor,btn_mabango, btn_ceuhymn;
    public static EditText et_choosemusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceuchoosemusic);
        choosmusic();
    }

    public void choosmusic(){
        btn_elcollar = (Button)findViewById(R.id.btn_elcollar);
        btn_laflor = (Button)findViewById(R.id.btn_laflor);
        btn_mabango = (Button)findViewById(R.id.btn_sampmabango);
        et_choosemusic = (EditText)findViewById(R.id.et_choosemusic);
        btn_ceuhymn=(Button)findViewById(R.id.hymn);

        btn_elcollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceumusic");
                et_choosemusic.setText("elcollar");
                startActivity(intent);
            }
        });

        btn_laflor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceumusic");
                et_choosemusic.setText("laflor");
                startActivity(intent);
            }
        });
        btn_mabango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceumusic");
                et_choosemusic.setText("mabango");
                startActivity(intent);
            }
        });


        btn_ceuhymn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceumusic");
                et_choosemusic.setText("hymn");
                startActivity(intent);
            }

        });
    }
}
