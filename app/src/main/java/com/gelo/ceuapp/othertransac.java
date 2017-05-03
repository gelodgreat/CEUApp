package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class othertransac extends AppCompatActivity {

    private static Button btn_crossenroll;
    private static Button btn_eval;
    private static Button btn_id;
    private static Button btn_promi;
    private static Button btn_read;
    private static Button btn_refund;
    private static Button btn_shifting;
    private static Button btn_addndrop;
    public static EditText et_choosetransac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othertransac);
        onClickTransactionOn();
    }

    private void onClickTransactionOn() {
        btn_crossenroll = (Button) findViewById(R.id.btn_crossenroll);
        btn_eval = (Button) findViewById(R.id.btn_evaluation);
        btn_id = (Button) findViewById(R.id.btn_id);
        btn_promi = (Button) findViewById(R.id.btn_promisorry);
        btn_read = (Button) findViewById(R.id.btn_readmission);
        btn_refund = (Button) findViewById(R.id.btn_refund);
        btn_shifting = (Button) findViewById(R.id.btn_shifting);
        et_choosetransac = (EditText) findViewById(R.id.et_chooseothertransac);
        btn_addndrop = (Button) findViewById(R.id.btn_addndrop);

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


    }
}
