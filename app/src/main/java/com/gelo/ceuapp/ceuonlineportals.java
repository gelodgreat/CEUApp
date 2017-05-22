package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class ceuonlineportals extends Fragment {

    private BottomNavigationItemView mainsite, onlinegrades, campusguidefbpage;
    private WebView wv_onlineportal;

    public ceuonlineportals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ceuonlineportals, container, false);

        init(view);
        loadwebsettings();
        offlinemode();

        mainsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_onlineportal.loadUrl("https://www.ceu.edu.ph");

            }
        });

        onlinegrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_onlineportal.loadUrl("https://grades.ceu.edu.ph");

            }
        });

        campusguidefbpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_onlineportal.loadUrl("https://www.facebook.com/campusguideceumanila");
            }
        });

        return view;
    }

    private void init(View view) {
        mainsite = (BottomNavigationItemView) view.findViewById(R.id.nav_ceuwebsite);
        onlinegrades = (BottomNavigationItemView) view.findViewById(R.id.nav_onlinegrades);
        campusguidefbpage = (BottomNavigationItemView) view.findViewById(R.id.nav_campusguidefbpage);
        wv_onlineportal = (WebView) view.findViewById(R.id.wv_onlineportal);
    }

    private void loadwebsettings() {
        wv_onlineportal.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        wv_onlineportal.getSettings().setAppCacheEnabled(true);
        WebSettings webSettings = wv_onlineportal.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv_onlineportal.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
    }

    private void offlinemode() {
        Boolean net = ((MainActivity) getActivity()).isNetworkAvailable();
        if (net == false) { // loading offline
            wv_onlineportal.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

            wv_onlineportal.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    wv_onlineportal.loadUrl("file:///android_asset/nointernet.html");

                }
            });
        }
    }


}
