package com.gelo.ceuapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.gelo.ceuapp.R;
import com.gelo.ceuapp.faqfolder.Offenses;
import com.gelo.ceuapp.faqfolder.ceuboard;
import com.gelo.ceuapp.faqfolder.ceuchoosemusic;
import com.gelo.ceuapp.faqfolder.ceuhistory;
import com.gelo.ceuapp.faqfolder.chooseenroll;
import com.gelo.ceuapp.faqfolder.othertransac;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class faq extends Fragment {

    AdView mAdView, mAdView2;
    private InterstitialAd interstitial;

    public faq() {
        // Required empty public constructor
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
                Intent intent = new Intent(getActivity(), Offenses.class);
                startActivity(intent);
            }

        });

        Button btn_ceuchoosemusic = (Button) view.findViewById(R.id.btn_ceuchoosemusic);
        btn_ceuchoosemusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ceuchoosemusic.class);
                startActivity(intent);
            }
        });

        Button btn_gotoenroll = (Button) view.findViewById(R.id.btn_enroll);
        btn_gotoenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), chooseenroll.class);
                startActivity(intent);
            }
        });

        Button btn_othertransac = (Button) view.findViewById(R.id.btn_othertransac);
        btn_othertransac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), othertransac.class);
                startActivity(intent);
            }
        });


        Button board = (Button) view.findViewById(R.id.btn_board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ceuboard.class);
                startActivity(intent);
            }
        });

        Button btn_ceu_history = (Button) view.findViewById(R.id.btn_ceuhistory);
        btn_ceu_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ceuhistory.class);
                startActivity(intent);
            }
        });

        mAdView = (AdView) view.findViewById(R.id.adView);
        mAdView2 = (AdView) view.findViewById(R.id.adView2);

        AdRequest adRequest = new AdRequest.Builder()
                //                .addTestDevice(getString(R.string.test_device_id))
                .build();

        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);

        //         Prepare the Interstitial Ad
        interstitial = new InterstitialAd(this.getActivity());
        //         Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_interstitial));

        interstitial.loadAd(adRequest);
        //         Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });

        return view;
    }


    private void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
