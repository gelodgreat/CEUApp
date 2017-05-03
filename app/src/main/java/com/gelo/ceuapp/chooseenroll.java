package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class chooseenroll extends AppCompatActivity {

    private static Button btn_fresh;
    private static Button btn_alien;
    private static Button btn_seconddeg;
    private static Button btn_transferee;
    private static Button btn_continuing;
    public static EditText et_enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseenroll);
        onClickChoice();
    }

    private void onClickChoice() {
        btn_fresh = (Button) findViewById(R.id.btn_fresh);
        btn_alien = (Button) findViewById(R.id.btn_alienproc);
        btn_seconddeg = (Button) findViewById(R.id.btn_seconddeg);
        btn_transferee = (Button) findViewById(R.id.btn_transferee);
        btn_continuing = (Button) findViewById(R.id.btn_contin);
        et_enroll = (EditText) findViewById(R.id.et_enroll);

        btn_fresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.enrollmentproc");
                et_enroll.setText("fresh");
                startActivity(intent);
            }
        });

        btn_alien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.enrollmentproc");
                et_enroll.setText("alien");
                startActivity(intent);
            }
        });

        btn_seconddeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.enrollmentproc");
                et_enroll.setText("seconddeg");
                startActivity(intent);
            }
        });

        btn_transferee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.enrollmentproc");
                et_enroll.setText("transferee");
                startActivity(intent);
            }
        });

        btn_continuing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.enrollmentproc");
                et_enroll.setText("continuing");
                startActivity(intent);
            }
        });


    }
}
