package com.gelo.ceuapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.gelo.ceuapp.R;
import com.gelo.ceuapp.faqfolder.ceuchoosemusic;
import com.gelo.ceuapp.faqfolder.ceumusic;
import com.gelo.ceuapp.faqfolder.enrollmentproc;
import com.gelo.ceuapp.faqfolder.othertransac;


public class fragment_search extends Fragment {

    private final String[] faq_list = {"Board of Directors", "Board Members", "El Collar De Sampaguita", "Sampaguita La Flor De Manila", "Sampaguitang Mabango", "CEU Hymn", "CEU History", "Serious Offense", "CEU Music", "Less Serious Offense", "Slight Offense", "Other Offenses", "Freshmen Enrollment", "Alien/Non-Resident Enrollment", "Second Degree Enrollment", "Continuing Student Enrollment", "Transferee Enrollment", "Enrollment Procedures", "Other Transactions", "Add and Drop", "Cross Enroll", "Evaluation for Graduating Students", "ID", "Promissory Note", "Re-Admission", "Readmission", "Refund", "Shifting"};

    WebView wv_loadings_faq, wv_faq_search;
    AutoCompleteTextView autoCompleteTextView;

    private String search = "";

    public fragment_search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_search, container, false);

        wv_loadings_faq = (WebView) view.findViewById(R.id.wv_loadings_faq);
        wv_loadings_faq.loadUrl("file:///android_asset/searching.html");

        wv_faq_search = (WebView) view.findViewById(R.id.wv_faq_search);

        WebSettings wv = wv_faq_search.getSettings();
        wv.setBuiltInZoomControls(true);
        wv.setSupportZoom(true);
        wv.setJavaScriptEnabled(true);
        wv.setDisplayZoomControls(false);


        autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.actvd_faq_search);

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.dropdownproperties, faq_list);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                search_filtering();
            }
        });

        return view;
    }


    private void search_filtering() {
        search = autoCompleteTextView.getText().toString();
        wv_loadings_faq.setVisibility(View.GONE);
        wv_faq_search.setVisibility(View.VISIBLE);


        if (search.equalsIgnoreCase("Board of Directors") || search.equalsIgnoreCase("Board Members")) {
            wv_faq_search.loadUrl("file:///android_asset/board_of_directors.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Enrollment Procedures")) {
            Intent intent = new Intent(getActivity(), enrollmentproc.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Other Transactions")) {
            Intent intent = new Intent(getActivity(), othertransac.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("CEU History")) {
            wv_faq_search.loadUrl("file:///android_asset/history_hamili.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("CEU Music")) {
            Intent intent = new Intent(getActivity(), ceuchoosemusic.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("El Collar De Sampaguita")) {
            ceuchoosemusic.et_choosemusic.setText("elcollar");
            Intent intent = new Intent(getActivity(), ceumusic.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Sampaguita La Flor De Manila")) {
            ceuchoosemusic.et_choosemusic.setText("laflor");
            Intent intent = new Intent(getActivity(), ceumusic.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Sampaguitang Mabango")) {
            ceuchoosemusic.et_choosemusic.setText("mabango");
            Intent intent = new Intent(getActivity(), ceumusic.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("CEU Hymn")) {
            ceuchoosemusic.et_choosemusic.setText("hymn");
            Intent intent = new Intent(getActivity(), ceumusic.class);
            startActivity(intent);
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Serious Offense")) {
            wv_faq_search.loadUrl("file:///android_asset/serious_offenses.html");
            autoCompleteTextView.setText("");

        } else if (search.equalsIgnoreCase("Less Serious Offense")) {
            wv_faq_search.loadUrl("file:///android_asset/less_serious_offenses.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Slight Offense")) {
            wv_faq_search.loadUrl("file:///android_asset/slight_offenses.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Other Offenses")) {
            wv_faq_search.loadUrl("file:///android_asset/other_offenses_and_sanctions.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Freshmen Enrollment")) {
            wv_faq_search.loadUrl("file:///android_asset/enrollment_freshmen.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Alien/Non-Resident Enrollment")) {
            wv_faq_search.loadUrl("file:///android_asset/enrollment_aliens_nonresident_ofw.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Second Degree Enrollment")) {
            wv_faq_search.loadUrl("file:///android_asset/enrollment_second_degree.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Continuing Student Enrollment")) {
            wv_faq_search.loadUrl("file:///android_asset/enrollment_continuing_students.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Transferee Enrollment")) {
            wv_faq_search.loadUrl("file:///android_asset/enrollment_transferees.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Add and Drop")) {
            wv_faq_search.loadUrl("file:///android_asset/add_drop_subjects.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Cross Enroll")) {
            wv_faq_search.loadUrl("file:///android_asset/cross_enroll.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Evaluation for Graduating Students")) {
            wv_faq_search.loadUrl("file:///android_asset/evaluation_for_grad.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("ID")) {
            wv_faq_search.loadUrl("file:///android_asset/id.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Promissory Note")) {
            wv_faq_search.loadUrl("file:///android_asset/promissory_note.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Re-Admission") || search.equalsIgnoreCase("Readmission")) {
            wv_faq_search.loadUrl("file:///android_asset/readmission.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Refund")) {
            wv_faq_search.loadUrl("file:///android_asset/refund.html");
            autoCompleteTextView.setText("");
        } else if (search.equalsIgnoreCase("Shifting")) {
            wv_faq_search.loadUrl("file:///android_asset/shifting.html");
            autoCompleteTextView.setText("");
        }


    }

}


