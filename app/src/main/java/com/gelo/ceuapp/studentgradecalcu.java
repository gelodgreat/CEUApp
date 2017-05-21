package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
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
    double xunits, xgrades, numxunits, numxgrades, numtotalave, multixgrade;
    String xresultgrades, xresultunits;
    int clickcounter = 0;
    int clickrecorder;
    private EditText cp, exam;
    private Button btn_calc, btn_clearonegrade;
    private TextView ttl;
    private InterstitialAd interstitial;
    private Button btn_next, btn_clear;
    private EditText et_units, et_grade, et_total_subj;
    private TextView tv_totalunits, tv_totalgrade, tv_totalaverage, tv_totalclicks;

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

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcuunits();
                clickcounter = clickcounter + 1;
                tv_totalclicks.setText("Total Inputed Grade: " + clickcounter);
                total();
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearfunctionchangetotalsubj();
            }
        });

        et_total_subj.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (et_total_subj.getText().toString().matches("")) {
                    clearfunctionchangetotalsubj();
                }

                return false;
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


        numxunits = 0;
        numxgrades = 0;
        numtotalave = 0;
        clickcounter = 0;

        btn_next = (Button) view.findViewById(R.id.btn_computeave);
        btn_clear = (Button) view.findViewById(R.id.calc_btn_clear);

        et_units = (EditText) view.findViewById(R.id.et_totalunits);
        et_grade = (EditText) view.findViewById(R.id.et_totalgrade);
        et_total_subj = (EditText) view.findViewById(R.id.et_totalsubjects);

        tv_totalunits = (TextView) view.findViewById(R.id.tv_totalunits);
        tv_totalgrade = (TextView) view.findViewById(R.id.tv_totalgrade);

        tv_totalaverage = (TextView) view.findViewById(R.id.tv_totalgwa);
        tv_totalclicks = (TextView) view.findViewById(R.id.tv_calculated_subjects);

        tv_totalunits.setText("Calculated Units: " + numxunits);
        tv_totalgrade.setText("Calculated Grade: " + numxgrades);
        tv_totalaverage.setText("GWA: " + numtotalave);
        tv_totalclicks.setText("Total Inputed Grade: " + clickcounter);

    }

    private void clearfunctionchangetotalsubj() {
        numxunits = 0;
        numxgrades = 0;
        numtotalave = 0;
        clickcounter = 0;
        et_grade.setText("");
        et_units.setText("");
        et_total_subj.setText("");
        tv_totalunits.setText("Calculated Units: " + numxunits);
        tv_totalgrade.setText("Calculated Grade: " + numxgrades);
        tv_totalaverage.setText("GWA: " + numtotalave);
        tv_totalclicks.setText("Total Inputed Grade: " + clickcounter);
        et_total_subj.requestFocus();
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

    private void calcuunits() {
        try {
            if (et_units.getText().toString().matches("") | et_grade.getText().toString().matches("") | et_total_subj.getText().toString().matches("")) {
                Toast.makeText(getContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
            } else {

                //Calculating Units
                xunits = Double.parseDouble(et_units.getText().toString()) + numxunits;
                numxunits = xunits;
                xresultunits = df.format(numxunits);

                //Calculating Grade (WRONG FORMULA) DOUBLE CHECK YOUR FUCKING REFERENCE
                multixgrade = Double.parseDouble(et_grade.getText().toString()) * Double.parseDouble(et_units.getText().toString());
                xgrades = multixgrade + numxgrades;
                numxgrades = xgrades;
                xresultgrades = df.format(xgrades);


                tv_totalunits.setText("Calculated Units:" + xresultunits);
                tv_totalgrade.setText("Calculated Grade: " + xresultgrades);


                et_grade.setText("");
                et_units.setText("");
                et_units.requestFocus();
            }


        } catch (Exception ex) {
            Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void total() {
        try {
            clickrecorder = Integer.parseInt(et_total_subj.getText().toString());
            if (clickcounter == clickrecorder) {
                double ion = Double.parseDouble(xresultgrades) / Double.parseDouble(xresultunits);
                xresultgrades = df.format(ion);
                tv_totalaverage.setText("GWA: " + xresultgrades);
            }
        } catch (Exception ex) {
            Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }


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


}