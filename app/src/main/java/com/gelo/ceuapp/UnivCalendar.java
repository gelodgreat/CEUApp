package com.gelo.ceuapp;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static android.content.Context.CONNECTIVITY_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnivCalendar extends Fragment {

    public UnivCalendar() {
        // Required empty public constructor
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        EditText et_aboutt = (EditText) getView().findViewById(R.id.et_aboutt);
        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutdevss) {

            Intent intent = new Intent(getActivity(), aboutform.class);
            et_aboutt.setText("devs");
            startActivity(intent);
            return true;
        } else if (id == R.id.aboutapps) {
            Intent intent = new Intent(getActivity(), aboutform.class);
            et_aboutt.setText("apps");
            startActivity(intent);
            return true;
        } else if (id == R.id.aboutdisclaimer) {
            Intent intent = new Intent(getActivity(), aboutform.class);
            et_aboutt.setText("disclaimer");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_univ_calendar, container, false);

        WebView wv = (WebView) view.findViewById(R.id.wv_uvc);
        wv.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        wv.getSettings().setAppCacheEnabled(true);
        WebSettings webSettings = wv.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);
        wv.setBackgroundColor(15658734);
        webSettings.setDisplayZoomControls(false);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Boolean net = ((MainActivity) getActivity()).isNetworkAvailable();
        if (net==false) { // loading offline
            wv.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }

        wv.loadUrl( "https://raw.githubusercontent.com/andrewhamili/CEUApp/master/app/src/main/assets/Calendar.html" );

        /*String add="https://raw.githubusercontent.com/andrewhamili/CEUApp/master/app/src/main/AndroidManifest.xml";


        try {
            URLConnection cn=new URL(add).openConnection();
            cn.connect();
            InputStream stream =cn.getInputStream();

            File download = new File(getContext().getCacheDir(), "AndroidManifest.xml");

            wv.loadUrl();

        } catch (IOException e) {
            e.printStackTrace();
        }*/


        return view;


    }

}
