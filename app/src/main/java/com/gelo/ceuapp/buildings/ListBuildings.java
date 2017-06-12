package com.gelo.ceuapp.buildings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gelo.ceuapp.R;
import com.gelo.ceuapp.fragments.MainFragment;

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
            MainFragment.retainn = ("Dent Sci");
            startActivity(new Intent(ListBuildings.this, dent_sci.class));
            finish();
        } else if (touched == "FGH") {
            MainFragment.retainn = ("FGH");
            startActivity(new Intent(ListBuildings.this, fgh.class));
            finish();
        } else if (touched == "ISC") {
            MainFragment.retainn = ("ISC");
            startActivity(new Intent(ListBuildings.this, isc.class));
            finish();
        } else if (touched == "TECH CENTER") {
            MainFragment.retainn = ("Tech Center");
            startActivity(new Intent(ListBuildings.this, tech_center.class));
            finish();
        } else if (touched == "SDVH") {
            MainFragment.retainn = ("SDVH");
            startActivity(new Intent(ListBuildings.this, sdvh.class));
            finish();
        } else if (touched == "FFH") {
            MainFragment.retainn = ("FFH");
            startActivity(new Intent(ListBuildings.this, ffh.class));
            finish();
        } else if (touched == "MVH") {
            MainFragment.retainn = ("MVH");
            startActivity(new Intent(ListBuildings.this, mvh.class));
            finish();
        } else if (touched == "DCTH") {
            MainFragment.retainn = ("DCTH");
            startActivity(new Intent(ListBuildings.this, dcth.class));
            finish();
        } else if (touched == "PHLH") {
            MainFragment.retainn = ("PHLH");
            startActivity(new Intent(ListBuildings.this, phlh.class));
            finish();
        } else if (touched == "Student Activity Center") {
            MainFragment.retainn = ("SAC");
            startActivity(new Intent(ListBuildings.this, sac.class));
            finish();
        } else if (touched == "North Quadrangle") {
            startActivity(new Intent(ListBuildings.this, north_quad.class));
            finish();
        } else if (touched == "CDL") {
            MainFragment.retainn = ("CDL");
            startActivity(new Intent(ListBuildings.this, cdl.class));
            finish();
        } else if (touched == "Chapel") {
            MainFragment.retainn = ("Chapel");
            startActivity(new Intent(ListBuildings.this, chapel.class));
            finish();
        } else if (touched == "LAH") {
            MainFragment.retainn = ("LAH");
            startActivity(new Intent(ListBuildings.this, lah.class));
            finish();
        } else if (touched == "CAH") {
            MainFragment.retainn = ("CAH");
            startActivity(new Intent(ListBuildings.this, cah.class));
            finish();
        } else if (touched == "GDLSC") {
            MainFragment.retainn = ("GDLSC");
            startActivity(new Intent(ListBuildings.this, gdlsc.class));
            finish();
        } else if (touched == "FSH") {
            MainFragment.retainn = ("FSH");
            startActivity(new Intent(ListBuildings.this, fsh.class));
            finish();
        }
    }

}
