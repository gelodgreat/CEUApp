package com.gelo.ceuapp;


/*import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;*/
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ButtonBarLayout;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import decoder.GifRun;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    public static AutoCompleteTextView search;
    public static Button search_btn;
    public static SurfaceView suv;
    public static EditText retainn;
    public static Configuration conf;




    AutoCompleteTextView autoCompleteTextView;
    String[] Building_List ={
            "CAH",
            "CDL",
            "Chapel",
            "DCTH",
            "Dent Sci",
            "FFH",
            "FGH",
            "FSH",
            "GDLSC",
            "ISC",
            "LAH",
            "MVH",
            "North Quadrangle",
            "PHLH",
            "SAC",
            "SDVH",
            "Tech Center",
            "Academic Affairs Office",
            "Library Department",
            "Probe Room",
            "Masscomm, Laboratory Rooms",
            "Social Sciences Department",
            "Filipino Department",
            "Social Arts and Humanities Department",
            "Campus Ministry",
            "International Languages Department",
            "Teaching and Learning Technology Department (TLTD)",
            "Multimedia Instruction Room (MIR)",
            "School of Education-Libreral Arts-Music-Social Work",
            "Music Rooms",
            "Tiongco Recital Hall",
            "Social Work Case Conference Room",
            "Human Resource Department",
            "Non-Teaching Employee's Lounge",
            "Cafeteria",
            "Librada Avelino Auditorium",
            "Clinical Laboratory",
            "Health Services Department",
            "SDV Lanai and Friendship Areas",
            "Diagnostic Center-Radiology Section",
            "Graduate School",
            "Marketing Communications Department",
            "Guidance and Counseling Department",
            "Psychology Laboratory",
            "Social Arts Laboratories",
            "Speech Laboratory",
            "Auxilliary Services Department (MATPRO)",
            "Cash Department",
            "Chapel/Adoration Chapel",
            "Chaplain's Office",
            "Executive Meeting Room",
            "Executive Vice President's Office",
            "Professional and Continuing Education Office",
            "Office of the Corporate Secretary",
            "President's Office",
            "Security Department",
            "SRMD (Registrar's Office)",
            "Treasurer's Office",
            "Uniform Section",
            "Meeting Room",
            "Biological Science Department",
            "University Publications",
            "Museum",
            "Physical Science Department",
            "LAH Seminar Rooms 1,2 and 3",
            "Nursing Arts Laboratories",
            "Pharmacare Laboratory",
            "Alumni Relations Department",
            "Audit Department",
            "Study Area",
            "Food Booths",
            "School of Nutrition and Hospitality Management",
            "Lecture or Demo Room",
            "Food Laboratories",
            "Linen and Laundry Room",
            "Hotel Suite",
            "Science Laboratory Rooms",
            "Extramurals Athletic Coordinator",
            "Gymnasium",
            "CEU Consumers Cooperative",
            "Bulwagang Maestra Osang",
            "Manufacturing Laboratory (Pharmacy)",
            "Vision and Eye Care Center",
            "College of Nursing",
            "College of Optometry",
            "Optometry Junior's Clinic",
            "Nursing Arts Laboratory",
            "College of Medical Technology",
            "Computer Laboratories",
            "ISC Canteen",
            "Travel Bureau",
            "Friend's Cafe",
            "ISC Mezzanine Function Rooms",
            "I.D. Section",
            "Management Information System Department",
            "Computer Education Department",
            "Information and Communication Technology Department",
            "School of Dentistry",
            "Laboratory Rooms",
            "School of Science and Technology",
            "Mathematics Department",
            "Psychology Department",
            "Gym and Fitness Room",
            "P.E. Department",
            "Swimming Pool",
            "Dental Clinics",
            "Food Booths",
            "M.S. Periodontics Clinic",
            "M.S. Orthodontics Clinic",
            "Simulations Rooms",
            "CEU-FAWU Office",
            "Baking Room and Cold Kitchen",
            "Food Laboratories",
            "Physical Plant and Facilities Department",
            "Student Organizations Center",
            "Science Laboratory Rooms",
            "Student Affairs Office",
            "University Council Office",
            "Community Outreach Department",
            "DCTH Canteen",
            "Property Department",
            "School of Accountancy and Management",
            "Market Research and Bank Simulation Room",
            "Quality and Productivity Rooms",
            "Accounting Laboratory",
            "Lecture Hall",
            "FFH Assembly Hall",
    };

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        final DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);

        conf =getResources().getConfiguration();


        //TextView t=(TextView)view.findViewById(R.id.textViewcode);
        //t.setText(conf.smallestScreenWidthDp);



        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.actvd);
        ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.select_dialog_item, Building_List);

        autoCompleteTextView.setDropDownBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.colorPrimaryDark)));
        autoCompleteTextView.setTextSize(15);
        autoCompleteTextView.setDropDownWidth(1200);
        autoCompleteTextView.setDropDownHeight(750);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);

        autoCompleteTextView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            if (search.getText().toString().equalsIgnoreCase("SAC")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("CDL")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("FFH")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("DCTH")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("Chapel")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("ISC")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("MVH")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            } else if (search.getText().toString().equalsIgnoreCase("SDVH")) {
                                Intent intent = new Intent("com.gelo.ceuapp.Navigation_Gif");
                                startActivity(intent);
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });

        ImageButton imgb_drawer = (ImageButton) view.findViewById(R.id.imgb_drawer);
        imgb_drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }

        });

        ImageButton btnm_ds = (ImageButton) view.findViewById(R.id.imgbmm_ds);
        btnm_ds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.dent_sci");
                retainn.setText("Dent Sci");
                startActivity(intent);
            }

        });

        ImageButton btnm_fgh = (ImageButton) view.findViewById(R.id.imgbmm_fgh);
        btnm_fgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.fgh");
                retainn.setText("FGH");
                startActivity(intent);
            }

        });

        ImageButton btnm_isc = (ImageButton) view.findViewById(R.id.imgbmm_isc);
        btnm_isc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.isc");
                retainn.setText("ISC");
                startActivity(intent);
            }

        });

        ImageButton btnm_tc = (ImageButton) view.findViewById(R.id.imgbmm_tc);
        btnm_tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.tech_center");
                retainn.setText("Tech Center");
                startActivity(intent);
            }

        });

        ImageButton btnm_ffh = (ImageButton) view.findViewById(R.id.imgbmm_ffh);
        btnm_ffh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.ffh");
                retainn.setText("FFH");
                startActivity(intent);
            }

        });

        ImageButton btnm_mvh = (ImageButton) view.findViewById(R.id.imgbmm_mvh);
        btnm_mvh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.mvh");
                retainn.setText("MVH");
                startActivity(intent);
            }

        });

        ImageButton btnm_dcth = (ImageButton) view.findViewById(R.id.imgbmm_dcth);
        btnm_dcth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.dcth");
                retainn.setText("DCTH");
                startActivity(intent);
            }

        });
        ImageButton btnm_phlh = (ImageButton) view.findViewById(R.id.imgbmm_phlh);
        btnm_phlh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.phlh");
                retainn.setText("PHLH");
                startActivity(intent);
            }

        });
        ImageButton btnm_fsh = (ImageButton) view.findViewById(R.id.imgbmm_fsh);
        btnm_fsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.fsh");
                retainn.setText("FSH");
                startActivity(intent);
            }

        });
        ImageButton btnm_chapel = (ImageButton) view.findViewById(R.id.imgbmm_chapel);
        btnm_chapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.chapel");
                retainn.setText("Chapel");
                startActivity(intent);
            }

        });
        ImageButton btnm_sac = (ImageButton) view.findViewById(R.id.imgbmm_sac);
        btnm_sac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.sac");
                retainn.setText("SAC");
                startActivity(intent);
            }

        });
        ImageButton btnm_north_quad = (ImageButton) view.findViewById(R.id.imgbmm_northquad);
        btnm_north_quad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.north_quad");
                retainn.setText("North Quad");
                startActivity(intent);
            }

        });
        ImageButton btnm_lah = (ImageButton) view.findViewById(R.id.imgbmm_lah);
        btnm_lah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.lah");
                retainn.setText("LAH");
                startActivity(intent);
            }

        });
        ImageButton btnm_cah = (ImageButton) view.findViewById(R.id.imgbmm_cah);
        btnm_cah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.cah");
                retainn.setText("CAH");
                startActivity(intent);
            }

        });
        ImageButton btnm_gdlsc = (ImageButton) view.findViewById(R.id.imgbmm_gdlsc);
        btnm_gdlsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.gdlsc");
                retainn.setText("GDLSC");
                startActivity(intent);
            }

        });
        ImageButton btnm_cdl = (ImageButton) view.findViewById(R.id.imgbmm_cdl);
        btnm_cdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.cdl");
                retainn.setText("CDL");
                startActivity(intent);
            }

        });
        ImageButton btnm_sdvh = (ImageButton) view.findViewById(R.id.imgbmm_sdvh);
        btnm_sdvh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.sdvh");
                retainn.setText("SDVH");
                startActivity(intent);
            }

        });


        search = (AutoCompleteTextView) view.findViewById(R.id.actvd);
        search_btn = (Button) view.findViewById(R.id.btn_search);
        search_btn.requestFocus();
        retainn = (EditText)view.findViewById(R.id.et_search2);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (search.getText().toString().equalsIgnoreCase("SAC")) {
                    Intent intent = new Intent("com.gelo.ceuapp.sac");
                    search.setText("");
                    retainn.setText("SAC");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("CDL") ||
                        (search.getText().toString().equalsIgnoreCase("Academic Affairs Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Library Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Probe Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Masscomm, Laboratory Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Social Sciences Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Filipino Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Social Arts and Humanities Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Campus Ministry"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("International Languages Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Teaching and Learning Technology Department (TLTD)"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Multimedia Instruction Room (MIR)"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("School of Education-Libreral Arts-Music-Social Work"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Music Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Tiongco Recital Hall"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Social Work Case Conference Room"))
                       /* ||
                        (search.getText().toString().equalsIgnoreCase("Library Department"))*/
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.cdl");
                    search.setText("");
                    retainn.setText("CDL");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("FFH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("FFH Assembly Hall"))

                ) {
                    Intent intent = new Intent("com.gelo.ceuapp.ffh");
                    search.setText("");
                    retainn.setText("FFH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("DCTH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Community Outreach Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("DCTH Canteen"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Property Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("School of Accountancy and Management"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Market Research and Bank Simulation Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Quality and Productivity Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Accounting Laboratory"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Lecture Hall"))
                ) {
                    Intent intent = new Intent("com.gelo.ceuapp.dcth");
                    search.setText("");
                    retainn.setText("DCTH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("Chapel")) {
                    Intent intent = new Intent("com.gelo.ceuapp.chapel");
                    search.setText("");
                    retainn.setText("Chapel");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("ISC")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Computer Laboratories"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("ISC Canteen"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Travel Bureau"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Friend's Cafe"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("ISC Mezzanine Function Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("I.D. Section"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Management Information System Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Computer Education Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Information and Communication Technology Department"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.isc");
                    search.setText("");
                    retainn.setText("ISC");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("MVH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Human Resource Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Non-Teaching Employee's Lounge"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Cafeteria"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Librada Avelino Auditorium"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.mvh");
                    search.setText("");
                    retainn.setText("MVH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("SDVH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Clinical Laboratory"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Health Services Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("SDV Lanai and Friendship Areas"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Diagnostic Center-Radiology Section"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Graduate School"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Marketing Communications Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Guidance and Counseling Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Psychology Laboratory"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Social Arts Laboratories"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Speech Laboratory"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.sdvh");
                    search.setText("");
                    retainn.setText("SDVH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("CAH")) {
                    Intent intent = new Intent("com.gelo.ceuapp.cah");
                    search.setText("");
                    retainn.setText("CAH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("Dent Sci")
                        ||
                        (search.getText().toString().equalsIgnoreCase("School of Dentistry"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Laboratory Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("School of Science and Technology"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Mathematics Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Psychology Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Gym and Fitness Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("P.E. Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Swimming Pool"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.dent_sci");
                    search.setText("");
                    retainn.setText("Dent Sci");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("FGH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Dental Clinics"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Food Booths"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("M.S. Periodontics Clinic"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("M.S. Orthodontics Clinic"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Simulations Rooms"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.fgh");
                    search.setText("");
                    retainn.setText("FGH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("FSH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("CEU-FAWU Office"))
                ) {
                    Intent intent = new Intent("com.gelo.ceuapp.fsh");
                    search.setText("");
                    retainn.setText("FSH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("GDLSC")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Bulwagang Maestra Osang"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Manufacturing Laboratory (Pharmacy)"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Vision and Eye Care Center"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("College of Nursing"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("College of Optometry"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Optometry Junior's Clinic"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Nursing Arts Laboratory"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("College of Medical Technology"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.gdlsc");
                    search.setText("");
                    retainn.setText("GDLSC");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("LAH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Auxilliary Services Department (MATPRO)"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Cash Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Chapel/Adoration Chapel"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Chaplain's Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Executive Meeting Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Executive Vice President's Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Professional and Continuing Education Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Office of the Corporate Secretary"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("President's Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Security Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("SRMD (Registrar's Office)"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Treasurer's Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Uniform Section"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Meeting Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Biological Science Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("University Publications"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Museum"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Physical Science Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("LAH Seminar Rooms 1,2 and 3"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Nursing Arts Laboratories"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Pharmacare Laboratory"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Alumni Relations Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Audit Department"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.lah");
                    search.setText("");
                    retainn.setText("LAH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("PHLH")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Baking Room and Cold Kitchen"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Food Laboratories"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Physical Plant and Facilities Department"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Student Organizations Center"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Science Laboratory Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Student Affairs Office"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("University Council Office"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.phlh");
                    search.setText("");
                    retainn.setText("PHLH");
                    startActivity(intent);
                } else if (search.getText().toString().equalsIgnoreCase("Tech Center")
                        ||
                        (search.getText().toString().equalsIgnoreCase("Study Area"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Food Booths"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("School of Nutrition and Hospitality Management"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Lecture or Demo Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Food Laboratories"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Linen and Laundry Room"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Hotel Suite"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Science Laboratory Rooms"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Extramurals Athletic Coordinator"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("Gymnasium"))
                        ||
                        (search.getText().toString().equalsIgnoreCase("CEU Consumers Cooperative"))
                        ) {
                    Intent intent = new Intent("com.gelo.ceuapp.tech_center");
                    search.setText("");
                    retainn.setText("Tech Center");
                    startActivity(intent);
                }
            }
        });


        return view;

    }





}