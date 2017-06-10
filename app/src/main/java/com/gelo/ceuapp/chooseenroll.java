package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class chooseenroll extends AppCompatActivity {

    public static EditText et_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseenroll);
        onClickChoice();

        AdView madviewchenroll = (AdView) findViewById(R.id.chooseenrollad);
        AdView madviewchenroll2 = (AdView) findViewById(R.id.chooseenrollad2);

        AdRequest adRequest = new AdRequest.Builder()
                //                .addTestDevice(getString(R.string.test_device_id))
                .build();

        madviewchenroll.loadAd(adRequest);
        madviewchenroll2.loadAd(adRequest);

    }

    private void onClickChoice() {
        Button btn_fresh = (Button) findViewById(R.id.btn_fresh);
        Button btn_alien = (Button) findViewById(R.id.btn_alienproc);
        Button btn_seconddeg = (Button) findViewById(R.id.btn_seconddeg);
        Button btn_transferee = (Button) findViewById(R.id.btn_transferee);
        Button btn_continuing = (Button) findViewById(R.id.btn_contin);
        et_enroll = (EditText) findViewById(R.id.et_enroll);

        btn_fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseenroll.this, enrollmentproc.class);
                et_enroll.setText("fresh");
                startActivity(intent);
            }
        });

        btn_alien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseenroll.this, enrollmentproc.class);
                et_enroll.setText("alien");
                startActivity(intent);
            }
        });

        btn_seconddeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseenroll.this, enrollmentproc.class);
                et_enroll.setText("seconddeg");
                startActivity(intent);
            }
        });

        btn_transferee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseenroll.this, enrollmentproc.class);
                et_enroll.setText("transferee");
                startActivity(intent);
            }
        });

        btn_continuing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(chooseenroll.this, enrollmentproc.class);
                et_enroll.setText("continuing");
                startActivity(intent);
            }
        });


    }
}
