package com.gelo.ceuapp;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;

public class about_developers2 extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developers2);


        TabHost tabHost2=(TabHost)this.findViewById(R.id.tabHost2);
        tabHost2.setup(this.getLocalActivityManager());

        TabHost.TabSpec tab4=tabHost2.newTabSpec("Tab4");
        tab4.setIndicator("Junius Reginald Tan");
        Intent i4= new Intent(about_developers2.this,developer_tan.class);
        tab4.setContent(i4);

        TabHost.TabSpec tab5=tabHost2.newTabSpec("Tab5");
        tab5.setIndicator("Brenz Buenaventura");
        Intent i5= new Intent(about_developers2.this,developer_buenaventura.class);
        tab5.setContent(i5);

        TabHost.TabSpec tab6=tabHost2.newTabSpec("Tab6");
        tab6.setIndicator("Karmeli Rejina D. Viril");
        Intent i6= new Intent(about_developers2.this,developer_viril.class);
        tab6.setContent(i6);

        tabHost2.addTab(tab4);
        tabHost2.addTab(tab5);
        tabHost2.addTab(tab6);

        onclickprev();
    }

    private void onclickprev() {
        ImageButton prev,homeb2;

        prev = (ImageButton)findViewById(R.id.img_aboutprev_float);
        homeb2 = (ImageButton) findViewById(R.id.img_homeab2_float);


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.About_developers");
                startActivity(intent);
            }
        });

        homeb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

