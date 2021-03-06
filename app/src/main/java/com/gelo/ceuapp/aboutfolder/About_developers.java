package com.gelo.ceuapp.aboutfolder;

import android.animation.ObjectAnimator;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.gelo.ceuapp.R;

public class About_developers extends ActivityGroup {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developers);

        ObjectAnimator animator = ObjectAnimator.ofInt(R.id.horiscroll, "ScrollX", 1000);
        animator.setDuration(250);
        animator.start();

        TabHost tabHost = (TabHost) this.findViewById(R.id.tabHost1);
        tabHost.setup(this.getLocalActivityManager());

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Tab1");
        tab1.setIndicator("UMALI");
        Intent i1 = new Intent(About_developers.this, umali_developer.class);
        tab1.setContent(i1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Tab2");
        tab2.setIndicator("HAMILI");
        Intent i2 = new Intent(About_developers.this, hamili_developer.class);
        tab2.setContent(i2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Tab3");
        tab3.setIndicator("WU");
        Intent i3 = new Intent(About_developers.this, wu_developer.class);
        tab3.setContent(i3);

        TabHost.TabSpec tab4 = tabHost.newTabSpec("Tab4");
        tab4.setIndicator("TAN");
        Intent i4 = new Intent(About_developers.this, tan_developer.class);
        tab4.setContent(i4);

        TabHost.TabSpec tab5 = tabHost.newTabSpec("Tab5");
        tab5.setIndicator("BUENAVENTURA");
        Intent i5 = new Intent(About_developers.this, buenaventura_developer.class);
        tab5.setContent(i5);

        TabHost.TabSpec tab6 = tabHost.newTabSpec("Tab6");
        tab6.setIndicator("VIRIL");
        Intent i6 = new Intent(About_developers.this, viril_developer.class);
        tab6.setContent(i6);


        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
        tabHost.addTab(tab4);
        tabHost.addTab(tab5);
        tabHost.addTab(tab6);


        onclickbutton();


    }

    private void onclickbutton() {
        /*ImageButton next, homeb1;

        next = (ImageButton) findViewById(R.id.img_aboutnext_float);
        homeb1 = (ImageButton) findViewById(R.id.img_homeab1_float);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.about_developers2");
                startActivity(intent);
            }
        });

        homeb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });*/


    }

}
