package com.gelo.ceuapp.fragments;


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


public class fragment_search extends Fragment {

    private final String[] faq_list = {"Board of Directors", "Board Members", "El Collar De Sampaguita", "Sampaguita La Flor De Manila", "Sampaguitang Mabango", "CEU Hymn", "CEU History", "Serious Offense", "Less Serious Offense", "Slight Offense", "Other Offenses", "Freshmen Enrollment", "Alien/Non-Resident Enrollment", "Second Degree Enrollment", "Continuing Student Enrollment", "Transferee Enrollment", "Enrollment Procedures", "Other Transactions", "Add and Drop", "Cross Enroll", "Evaluation for Graduating Students", "ID", "Promissory Note", "Re-Admission", "Readmission", "Refund", "Shifting"};

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
        } else if (search.equalsIgnoreCase("El Collar De Sampaguita")) {

        } else if (search.equalsIgnoreCase("Sampaguita La Flor De Manila")) {

        } else if (search.equalsIgnoreCase("Sampaguitang Mabango")) {

        } else if (search.equalsIgnoreCase("Enrollment Procedures")) {

        } else if (search.equalsIgnoreCase("Other Transactions")) {

        } else if (search.equalsIgnoreCase("CEU Hymn")) {

        } else if (search.equalsIgnoreCase("CEU History")) {

        } else if (search.equalsIgnoreCase("Serious Offense")) {

        } else if (search.equalsIgnoreCase("Less Serious Offense")) {

        } else if (search.equalsIgnoreCase("Slight Offense")) {

        } else if (search.equalsIgnoreCase("Other Offenses")) {

        } else if (search.equalsIgnoreCase("Freshmen Enrollment")) {

        } else if (search.equalsIgnoreCase("Alien/Non-Resident Enrollment")) {

        } else if (search.equalsIgnoreCase("Second Degree Enrollment")) {

        } else if (search.equalsIgnoreCase("Continuing Student Enrollment")) {

        } else if (search.equalsIgnoreCase("Transferee Enrollment")) {

        } else if (search.equalsIgnoreCase("Add and Drop")) {

        } else if (search.equalsIgnoreCase("Cross Enroll")) {

        } else if (search.equalsIgnoreCase("Evaluation for Graduating Students")) {

        } else if (search.equalsIgnoreCase("ID")) {

        } else if (search.equalsIgnoreCase("Promissory Note")) {

        } else if (search.equalsIgnoreCase("Re-Admission") || search.equalsIgnoreCase("Readmission")) {

        } else if (search.equalsIgnoreCase("Refund")) {

        } else if (search.equalsIgnoreCase("Shifting")) {

        }


    }

}


