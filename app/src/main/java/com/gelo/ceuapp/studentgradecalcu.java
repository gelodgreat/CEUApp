package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.text.DecimalFormat;


public class studentgradecalcu extends Fragment {
    double icp, iexam;
    DecimalFormat df = new DecimalFormat("#.00");
    mymethods mm = new mymethods();
    private EditText cp, exam;
    private Button btn_calc, btn_clearonegrade;
    private TextView ttl;
    private InterstitialAd interstitial;

    public studentgradecalcu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_studentgradecalcu, container, false);

        init(view);
        load_ads();

        showmytips();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateresult();
            }
        });


        btn_clearonegrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.setText("");
                exam.setText("");
                ttl.setText("Your Computed Grade");
                cp.requestFocus();
            }
        });

        return view;
    }

    private void init(View view) {
        cp = (EditText) view.findViewById(R.id.et_cp1);
        exam = (EditText) view.findViewById(R.id.et_exam1);
        btn_calc = (Button) view.findViewById(R.id.btn_calculate);
        ttl = (TextView) view.findViewById(R.id.ttl_res);
        btn_clearonegrade = (Button) view.findViewById(R.id.btn_clearonegrade);
    }


    private void calculateresult() {
        try {

            if (cp.getText().toString().matches("") | exam.getText().toString().matches("")) {
                Toast.makeText(getActivity(), "Complete the Value", Toast.LENGTH_SHORT).show();
            } else {
                icp = Double.parseDouble(cp.getText().toString());
                iexam = Double.parseDouble(exam.getText().toString());

                Double result = mm.calc(icp, iexam);

                String xresult = df.format(result);
                ttl.setText("Your Grade is: " + xresult);
            }
        } catch (Exception ex) {
            showMessage("Error", ex.toString());
        }
    }

    private void showmytips() {
        StringBuilder builder = new StringBuilder();
        builder.append("1. If you want to calculate only your 'Grade' and 'CP' use the top functions.\n").append("\n");
        builder.append("2. If you want to calculate your average grade use the bottom part calculations.\n").append("\n");
        builder.append("3. In using the bottom part, First you need to input your total subjects that needed to be computed\n").append("\n");
        builder.append("4. After that you may now click your grades to be computed.\n").append("\n");
        builder.append("5. After you calculate your average grade click 'CLEAR' button to reset the values.");
        showMessage("Calculator Tips", builder.toString());
    }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(message);
        builder.show();

    }

    //ADS
    private void load_ads() {
        AdRequest adRequest = new AdRequest.Builder()
                //                .addTestDevice(getString(R.string.test_device_id))
                .build();
        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(this.getActivity());
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_interstitial));

        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                displayInterstitial();
            }
        });
    }

    private void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}