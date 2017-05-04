package com.gelo.ceuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class faq extends Fragment {

    public faq() {
        // Required empty public constructor
    }

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

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
        final View view = inflater.inflate(R.layout.fragment_faq, container, false);

        MobileAds.initialize(getActivity().getApplicationContext(), getString(R.string.ad_app_id));


        Button btn_offense = (Button) view.findViewById(R.id.btn_offense);
        btn_offense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Offenses");
                startActivity(intent);
            }

        });

        Button btn_ceuchoosemusic = (Button) view.findViewById(R.id.btn_ceuchoosemusic);
        btn_ceuchoosemusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.ceuchoosemusic");
                startActivity(intent);
            }
        });

        Button btn_gotoenroll = (Button) view.findViewById(R.id.btn_enroll);
        btn_gotoenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.chooseenroll");
                startActivity(intent);
            }
        });

        Button btn_othertransac = (Button) view.findViewById(R.id.btn_othertransac);
        btn_othertransac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.othertransac");
                startActivity(intent);
            }
        });


        Button board = (Button) view.findViewById(R.id.btn_board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.ceuboard");
                startActivity(intent);
            }
        });


        AdView mAdView, mAdView2;
        mAdView = (AdView) view.findViewById(R.id.adView);
        mAdView2 = (AdView) view.findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder()
                //                .addTestDevice(getString(R.string.test_device_id))
                .build();

        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(this.getActivity());
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_interstitial));

        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });


        //        AdRequest adRequest = new AdRequest.Builder().build();
        //        mAdView2.loadAd(adRequest);
        //        mAdView.loadAd(adRequest);


        return view;
    }


    private void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
