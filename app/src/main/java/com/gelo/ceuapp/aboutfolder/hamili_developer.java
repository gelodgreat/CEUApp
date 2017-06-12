package com.gelo.ceuapp.aboutfolder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gelo.ceuapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class hamili_developer extends Fragment {


    public hamili_developer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_hamili_developer, container, false);

        WebView wv = (WebView) view.findViewById(R.id.wv_abouthamili);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
        wv.loadUrl("file:///android_asset/hamiliabout.html");

        return view;
    }


}
