package com.gelo.ceuapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListBuildings extends AppCompatActivity {


    ListView list;
    String[] bldgname = {"DentSci", "FGH", "ISC", "TECH CENTER", "SDVH", "FFH", "MVH", "DCTH", "PHLH", "FSH", "Student Activity Center", "North Quadrangle", "CDL", "Chapel", "LAH", "CAH", "GDLSC"

    };
    // FOR FUTURE USE IF WE ALREADY HAVE DESC FOR EACH BUILDINGS
    //    String[]bldgdesc = {
    //            "Dentistry and Science Building",
    //
    //
    //    };

    Integer[] imgid = {R.drawable.scroll_dentistry_science, R.drawable.scroll_fgh, R.drawable.scroll_isc, R.drawable.scroll_tc, R.drawable.scroll_sdv, R.drawable.scroll_ffh, R.drawable.scroll_mvh, R.drawable.scroll_dcth, R.drawable.scroll_phlh, R.drawable.scroll_fsh, R.drawable.scroll_sac, R.drawable.scroll_northquad, R.drawable.scroll_cdl, R.drawable.scroll_chapel, R.drawable.scroll_lah, R.drawable.scroll_cah, R.drawable.scroll_gdlsc

    };

    String touched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_buildings);
        CustomListAdapter adapter = new CustomListAdapter(this, bldgname, imgid);
        list = (ListView) findViewById(R.id.list_allbuildings);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                touched = list.getItemAtPosition(position).toString();
                bldgcondition();

            }
        });
    }


    private void bldgcondition() {
        if (touched == "DentSci") {
            MainFragment.retainn.setText("Dent Sci");
            startActivity(new Intent(ListBuildings.this, dent_sci.class));
        } else if (touched == "FGH") {
            MainFragment.retainn.setText("FGH");
            startActivity(new Intent(ListBuildings.this, fgh.class));
        } else if (touched == "ISC") {
            MainFragment.retainn.setText("ISC");
            startActivity(new Intent(ListBuildings.this, isc.class));
        } else if (touched == "TECH CENTER") {
            MainFragment.retainn.setText("Tech Center");
            startActivity(new Intent(ListBuildings.this, tech_center.class));
        } else if (touched == "SDVH") {
            MainFragment.retainn.setText("SDVH");
            startActivity(new Intent(ListBuildings.this, sdvh.class));
        } else if (touched == "FFH") {
            MainFragment.retainn.setText("FFH");
            startActivity(new Intent(ListBuildings.this, ffh.class));
        } else if (touched == "MVH") {
            MainFragment.retainn.setText("MVH");
            startActivity(new Intent(ListBuildings.this, mvh.class));
        } else if (touched == "DCTH") {
            MainFragment.retainn.setText("DCTH");
            startActivity(new Intent(ListBuildings.this, dcth.class));
        } else if (touched == "PHLH") {
            MainFragment.retainn.setText("PHLH");
            startActivity(new Intent(ListBuildings.this, phlh.class));
        } else if (touched == "Student Activity Center") {
            MainFragment.retainn.setText("SAC");
            startActivity(new Intent(ListBuildings.this, sac.class));
        } else if (touched == "North Quadrangle") {
            startActivity(new Intent(ListBuildings.this, north_quad.class));
        } else if (touched == "CDL") {
            MainFragment.retainn.setText("CDL");
            startActivity(new Intent(ListBuildings.this, cdl.class));
        } else if (touched == "Chapel") {
            MainFragment.retainn.setText("Chapel");
            startActivity(new Intent(ListBuildings.this, chapel.class));
        } else if (touched == "LAH") {
            MainFragment.retainn.setText("LAH");
            startActivity(new Intent(ListBuildings.this, lah.class));
        } else if (touched == "CAH") {
            MainFragment.retainn.setText("CAH");
            startActivity(new Intent(ListBuildings.this, cah.class));
        } else if (touched == "GDLSC") {
            MainFragment.retainn.setText("GDLSC");
            startActivity(new Intent(ListBuildings.this, gdlsc.class));
        } else if (touched == "FSH") {
            MainFragment.retainn.setText("FSH");
            startActivity(new Intent(ListBuildings.this, fsh.class));
        }
    }

}
