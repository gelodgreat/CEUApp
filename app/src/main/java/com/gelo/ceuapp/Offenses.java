package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Offenses extends AppCompatActivity {

    public static EditText et_off;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_offenses);
        Click();

    }

    public void Click() {
        Button btn_minor = (Button) findViewById(R.id.btn_minor);
        Button btn_lessserious = (Button) findViewById(R.id.btn_lessserious);
        Button btn_serious = (Button) findViewById(R.id.btn_serious);
        Button btn_other = (Button) findViewById(R.id.btn_other);
        et_off = (EditText) findViewById(R.id.et_off);

        btn_minor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent("com.gelo.ceuapp.listoffenses");
                et_off.setText("minor");
                startActivity(intent);
            }
        });

        btn_lessserious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.listoffenses");
                et_off.setText("less");
                startActivity(intent);
            }
        });

        btn_serious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.listoffenses");
                et_off.setText("serious");
                startActivity(intent);
            }
        });

        btn_other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.listoffenses");
                et_off.setText("other");
                startActivity(intent);
            }
        });

    }
}
