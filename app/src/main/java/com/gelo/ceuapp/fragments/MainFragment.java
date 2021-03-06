package com.gelo.ceuapp.fragments;


/*import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;*/

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.gelo.ceuapp.R;
import com.gelo.ceuapp.buildings.ListBuildings;
import com.gelo.ceuapp.buildings.Navigation_Gif;
import com.gelo.ceuapp.buildings.cah;
import com.gelo.ceuapp.buildings.cdl;
import com.gelo.ceuapp.buildings.chapel;
import com.gelo.ceuapp.buildings.dcth;
import com.gelo.ceuapp.buildings.dent_sci;
import com.gelo.ceuapp.buildings.ffh;
import com.gelo.ceuapp.buildings.fgh;
import com.gelo.ceuapp.buildings.fsh;
import com.gelo.ceuapp.buildings.gdlsc;
import com.gelo.ceuapp.buildings.isc;
import com.gelo.ceuapp.buildings.lah;
import com.gelo.ceuapp.buildings.mvh;
import com.gelo.ceuapp.buildings.phlh;
import com.gelo.ceuapp.buildings.sac;
import com.gelo.ceuapp.buildings.sdvh;
import com.gelo.ceuapp.buildings.tech_center;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    public static SurfaceView suv;
    public static String retainn;
    private static AutoCompleteTextView search;
    private final String[] Building_List = {"CAH", "CDL", "Chapel", "DCTH", "Dent Sci", "FFH", "FGH", "FSH", "GDLSC", "ISC", "LAH", "MVH", "North Quadrangle", "PHLH", "SAC", "SDVH", "Tech Center", "Academic Affairs Office", "Library Department", "Probe Room", "Masscomm, Laboratory Rooms", "Social Sciences Department", "Filipino Department", "Social Arts and Humanities Department", "Campus Ministry", "International Languages Department", "Teaching and Learning Technology Department (TLTD)", "Multimedia Instruction Room (MIR)", "School of Education-Libreral Arts-Music-Social Work", "Music Rooms", "Tiongco Recital Hall", "Social Work Case Conference Room", "Human Resource Department", "Non-Teaching Employee's Lounge", "Cafeteria", "Librada Avelino Auditorium", "Clinical Laboratory", "Health Services Department", "SDV Lanai and Friendship Areas", "Diagnostic Center-Radiology Section", "Graduate School", "Marketing Communications Department", "Guidance and Counseling Department", "Psychology Laboratory", "Social Arts Laboratories", "Speech Laboratory", "Auxilliary Services Department (MATPRO)", "Cash Department", "Chapel/Adoration Chapel", "Chaplain's Office", "Executive Meeting Room", "Executive Vice President's Office", "Professional and Continuing Education Office", "Office of the Corporate Secretary", "President's Office", "Security Department", "SRMD (Registrar's Office)", "Treasurer's Office", "Uniform Section", "Meeting Room", "Biological Science Department", "University Publications", "Museum", "Physical Science Department", "LAH Seminar Rooms 1,2 and 3", "Nursing Arts Laboratories", "Pharmacare Laboratory", "Alumni Relations Department", "Audit Department", "Study Area", "Food Booths", "School of Nutrition and Hospitality Management", "Lecture or Demo Room", "Food Laboratories", "Linen and Laundry Room", "Hotel Suite", "Science Laboratory Rooms", "Extramurals Athletic Coordinator", "Gymnasium", "CEU Consumers Cooperative", "Bulwagang Maestra Osang", "Manufacturing Laboratory (Pharmacy)", "Vision and Eye Care Center", "College of Nursing", "College of Optometry", "Optometry Junior's Clinic", "Nursing Arts Laboratory", "College of Medical Technology", "Computer Laboratories", "ISC Canteen", "Travel Bureau", "Friend's Cafe", "ISC Mezzanine Function Rooms", "I.D. Section", "Management Information System Department", "Computer Education Department", "Information and Communication Technology Department", "School of Dentistry", "Laboratory Rooms", "School of Science and Technology", "Mathematics Department", "Psychology Department", "Gym and Fitness Room", "P.E. Department", "Swimming Pool", "Dental Clinics", "Food Booths", "M.S. Periodontics Clinic", "M.S. Orthodontics Clinic", "Simulations Rooms", "CEU-FAWU Office", "Baking Room and Cold Kitchen", "Food Laboratories", "Physical Plant and Facilities Department", "Student Organizations Center", "Science Laboratory Rooms", "Student Affairs Office", "University Council Office", "Community Outreach Department", "DCTH Canteen", "Property Department", "School of Accountancy and Management", "Market Research and Bank Simulation Room", "Quality and Productivity Rooms", "Accounting Laboratory", "Lecture Hall", "FFH Assembly Hall",};
    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);

        Configuration conf = getResources().getConfiguration();

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.actvd);

        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.dropdownproperties, Building_List);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);


        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if (search.getText().toString().equalsIgnoreCase("SAC")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("CDL")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("FFH")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("DCTH")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("Chapel")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("ISC")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("MVH")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            } else if (search.getText().toString().equalsIgnoreCase("SDVH")) {
                                Intent intent = new Intent(getActivity(), Navigation_Gif.class);
                                startActivity(intent);

                            }
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        ImageView imgviewbldgs = (ImageView) view.findViewById(R.id.img_themap);
        imgviewbldgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListBuildings.class);
                startActivity(intent);

            }
        });


        search = (AutoCompleteTextView) view.findViewById(R.id.actvd);
        Button search_btn = (Button) view.findViewById(R.id.btn_search);
        search_btn.requestFocus();


        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (search.getText().toString().equalsIgnoreCase("SAC")) {
                    Intent intent = new Intent(getActivity(), sac.class);
                    search.setText("");
                    retainn = ("SAC");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("CDL") || (search.getText().toString().equalsIgnoreCase("Academic Affairs Office")) || (search.getText().toString().equalsIgnoreCase("Library Department")) || (search.getText().toString().equalsIgnoreCase("Probe Room")) || (search.getText().toString().equalsIgnoreCase("Masscomm, Laboratory Rooms")) || (search.getText().toString().equalsIgnoreCase("Social Sciences Department")) || (search.getText().toString().equalsIgnoreCase("Filipino Department")) || (search.getText().toString().equalsIgnoreCase("Social Arts and Humanities Department")) || (search.getText().toString().equalsIgnoreCase("Campus Ministry")) || (search.getText().toString().equalsIgnoreCase("International Languages Department")) || (search.getText().toString().equalsIgnoreCase("Teaching and Learning Technology Department (TLTD)")) || (search.getText().toString().equalsIgnoreCase("Multimedia Instruction Room (MIR)")) || (search.getText().toString().equalsIgnoreCase("School of Education-Libreral Arts-Music-Social Work")) || (search.getText().toString().equalsIgnoreCase("Music Rooms")) || (search.getText().toString().equalsIgnoreCase("Tiongco Recital Hall")) || (search.getText().toString().equalsIgnoreCase("Social Work Case Conference Room"))
                       /* ||
                        (search.getText().toString().equalsIgnoreCase("Library Department"))*/) {
                    Intent intent = new Intent(getActivity(), cdl.class);
                    search.setText("");
                    retainn = ("CDL");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("FFH") || (search.getText().toString().equalsIgnoreCase("FFH Assembly Hall"))

                        ) {
                    Intent intent = new Intent(getActivity(), ffh.class);
                    search.setText("");
                    retainn = ("FFH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("DCTH") || (search.getText().toString().equalsIgnoreCase("Community Outreach Department")) || (search.getText().toString().equalsIgnoreCase("DCTH Canteen")) || (search.getText().toString().equalsIgnoreCase("Property Department")) || (search.getText().toString().equalsIgnoreCase("School of Accountancy and Management")) || (search.getText().toString().equalsIgnoreCase("Market Research and Bank Simulation Room")) || (search.getText().toString().equalsIgnoreCase("Quality and Productivity Rooms")) || (search.getText().toString().equalsIgnoreCase("Accounting Laboratory")) || (search.getText().toString().equalsIgnoreCase("Lecture Hall"))) {
                    Intent intent = new Intent(getActivity(), dcth.class);
                    search.setText("");
                    retainn = ("DCTH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("Chapel")) {
                    Intent intent = new Intent(getActivity(), chapel.class);
                    search.setText("");
                    retainn = ("Chapel");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("ISC") || (search.getText().toString().equalsIgnoreCase("Computer Laboratories")) || (search.getText().toString().equalsIgnoreCase("ISC Canteen")) || (search.getText().toString().equalsIgnoreCase("Travel Bureau")) || (search.getText().toString().equalsIgnoreCase("Friend's Cafe")) || (search.getText().toString().equalsIgnoreCase("ISC Mezzanine Function Rooms")) || (search.getText().toString().equalsIgnoreCase("I.D. Section")) || (search.getText().toString().equalsIgnoreCase("Management Information System Department")) || (search.getText().toString().equalsIgnoreCase("Computer Education Department")) || (search.getText().toString().equalsIgnoreCase("Information and Communication Technology Department"))) {
                    Intent intent = new Intent(getActivity(), isc.class);
                    search.setText("");
                    retainn = ("ISC");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("MVH") || (search.getText().toString().equalsIgnoreCase("Human Resource Department")) || (search.getText().toString().equalsIgnoreCase("Non-Teaching Employee's Lounge")) || (search.getText().toString().equalsIgnoreCase("Cafeteria")) || (search.getText().toString().equalsIgnoreCase("Librada Avelino Auditorium"))) {
                    Intent intent = new Intent(getActivity(), mvh.class);
                    search.setText("");
                    retainn = ("MVH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("SDVH") || (search.getText().toString().equalsIgnoreCase("Clinical Laboratory")) || (search.getText().toString().equalsIgnoreCase("Health Services Department")) || (search.getText().toString().equalsIgnoreCase("SDV Lanai and Friendship Areas")) || (search.getText().toString().equalsIgnoreCase("Diagnostic Center-Radiology Section")) || (search.getText().toString().equalsIgnoreCase("Graduate School")) || (search.getText().toString().equalsIgnoreCase("Marketing Communications Department")) || (search.getText().toString().equalsIgnoreCase("Guidance and Counseling Department")) || (search.getText().toString().equalsIgnoreCase("Psychology Laboratory")) || (search.getText().toString().equalsIgnoreCase("Social Arts Laboratories")) || (search.getText().toString().equalsIgnoreCase("Speech Laboratory"))) {
                    Intent intent = new Intent(getActivity(), sdvh.class);
                    search.setText("");
                    retainn = ("SDVH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("CAH")) {
                    Intent intent = new Intent(getActivity(), cah.class);
                    search.setText("");
                    retainn = ("CAH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("Dent Sci") || (search.getText().toString().equalsIgnoreCase("School of Dentistry")) || (search.getText().toString().equalsIgnoreCase("Laboratory Rooms")) || (search.getText().toString().equalsIgnoreCase("School of Science and Technology")) || (search.getText().toString().equalsIgnoreCase("Mathematics Department")) || (search.getText().toString().equalsIgnoreCase("Psychology Department")) || (search.getText().toString().equalsIgnoreCase("Gym and Fitness Room")) || (search.getText().toString().equalsIgnoreCase("P.E. Department")) || (search.getText().toString().equalsIgnoreCase("Swimming Pool"))) {
                    Intent intent = new Intent(getActivity(), dent_sci.class);
                    search.setText("");
                    retainn = ("Dent Sci");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("FGH") || (search.getText().toString().equalsIgnoreCase("Dental Clinics")) || (search.getText().toString().equalsIgnoreCase("Food Booths")) || (search.getText().toString().equalsIgnoreCase("M.S. Periodontics Clinic")) || (search.getText().toString().equalsIgnoreCase("M.S. Orthodontics Clinic")) || (search.getText().toString().equalsIgnoreCase("Simulations Rooms"))) {
                    Intent intent = new Intent(getActivity(), fgh.class);
                    search.setText("");
                    retainn = ("FGH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("FSH") || (search.getText().toString().equalsIgnoreCase("CEU-FAWU Office"))) {
                    Intent intent = new Intent(getActivity(), fsh.class);
                    search.setText("");
                    retainn = ("FSH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("GDLSC") || (search.getText().toString().equalsIgnoreCase("Bulwagang Maestra Osang")) || (search.getText().toString().equalsIgnoreCase("Manufacturing Laboratory (Pharmacy)")) || (search.getText().toString().equalsIgnoreCase("Vision and Eye Care Center")) || (search.getText().toString().equalsIgnoreCase("College of Nursing")) || (search.getText().toString().equalsIgnoreCase("College of Optometry")) || (search.getText().toString().equalsIgnoreCase("Optometry Junior's Clinic")) || (search.getText().toString().equalsIgnoreCase("Nursing Arts Laboratory")) || (search.getText().toString().equalsIgnoreCase("College of Medical Technology"))) {
                    Intent intent = new Intent(getActivity(), gdlsc.class);
                    search.setText("");
                    retainn = ("GDLSC");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("LAH") || (search.getText().toString().equalsIgnoreCase("Auxilliary Services Department (MATPRO)")) || (search.getText().toString().equalsIgnoreCase("Cash Department")) || (search.getText().toString().equalsIgnoreCase("Chapel/Adoration Chapel")) || (search.getText().toString().equalsIgnoreCase("Chaplain's Office")) || (search.getText().toString().equalsIgnoreCase("Executive Meeting Room")) || (search.getText().toString().equalsIgnoreCase("Executive Vice President's Office")) || (search.getText().toString().equalsIgnoreCase("Professional and Continuing Education Office")) || (search.getText().toString().equalsIgnoreCase("Office of the Corporate Secretary")) || (search.getText().toString().equalsIgnoreCase("President's Office")) || (search.getText().toString().equalsIgnoreCase("Security Department")) || (search.getText().toString().equalsIgnoreCase("SRMD (Registrar's Office)")) || (search.getText().toString().equalsIgnoreCase("Treasurer's Office")) || (search.getText().toString().equalsIgnoreCase("Uniform Section")) || (search.getText().toString().equalsIgnoreCase("Meeting Room")) || (search.getText().toString().equalsIgnoreCase("Biological Science Department")) || (search.getText().toString().equalsIgnoreCase("University Publications")) || (search.getText().toString().equalsIgnoreCase("Museum")) || (search.getText().toString().equalsIgnoreCase("Physical Science Department")) || (search.getText().toString().equalsIgnoreCase("LAH Seminar Rooms 1,2 and 3")) || (search.getText().toString().equalsIgnoreCase("Nursing Arts Laboratories")) || (search.getText().toString().equalsIgnoreCase("Pharmacare Laboratory")) || (search.getText().toString().equalsIgnoreCase("Alumni Relations Department")) || (search.getText().toString().equalsIgnoreCase("Audit Department"))) {
                    Intent intent = new Intent(getActivity(), lah.class);
                    search.setText("");
                    retainn = ("LAH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("PHLH") || (search.getText().toString().equalsIgnoreCase("Baking Room and Cold Kitchen")) || (search.getText().toString().equalsIgnoreCase("Food Laboratories")) || (search.getText().toString().equalsIgnoreCase("Physical Plant and Facilities Department")) || (search.getText().toString().equalsIgnoreCase("Student Organizations Center")) || (search.getText().toString().equalsIgnoreCase("Science Laboratory Rooms")) || (search.getText().toString().equalsIgnoreCase("Student Affairs Office")) || (search.getText().toString().equalsIgnoreCase("University Council Office"))) {
                    Intent intent = new Intent(getActivity(), phlh.class);
                    search.setText("");
                    retainn = ("PHLH");
                    startActivity(intent);

                } else if (search.getText().toString().equalsIgnoreCase("Tech Center") || (search.getText().toString().equalsIgnoreCase("Study Area")) || (search.getText().toString().equalsIgnoreCase("Food Booths")) || (search.getText().toString().equalsIgnoreCase("School of Nutrition and Hospitality Management")) || (search.getText().toString().equalsIgnoreCase("Lecture or Demo Room")) || (search.getText().toString().equalsIgnoreCase("Food Laboratories")) || (search.getText().toString().equalsIgnoreCase("Linen and Laundry Room")) || (search.getText().toString().equalsIgnoreCase("Hotel Suite")) || (search.getText().toString().equalsIgnoreCase("Science Laboratory Rooms")) || (search.getText().toString().equalsIgnoreCase("Extramurals Athletic Coordinator")) || (search.getText().toString().equalsIgnoreCase("Gymnasium")) || (search.getText().toString().equalsIgnoreCase("CEU Consumers Cooperative"))) {
                    Intent intent = new Intent(getActivity(), tech_center.class);
                    search.setText("");
                    retainn = ("Tech Center");
                    startActivity(intent);

                }
            }
        });

        //                interstitial = new InterstitialAd(getActivity().getApplicationContext());
        //                interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_interstitial));
        //                AdRequest adRequest = new AdRequest.Builder().build();
        //                interstitial.loadAd(adRequest);
        //                interstitial.setAdListener(new AdListener() {
        //                    @Override
        //                    public void onAdLoaded() {
        //                        super.onAdLoaded();
        //                        displayInterstitial();
        //                    }
        //                });
        return view;


    }

    //
    //    private void displayInterstitial() {
    //        // If Ads are loaded, show Interstitial else show nothing.
    //        if (interstitial.isLoaded()) {
    //            interstitial.show();
    //        }
    //    }


}