package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    Animation animAlpha;
    private EditText cp, exam;
    private Button btn_calc, btn_clearonegrade;
    private TextView ttl;
    private InterstitialAd interstitial;
    private Button btn_next, btn_clear;
    private EditText et_grade, et_total_subj;
    private TextView tv_totalunits, tv_totalgrade, tv_totalaverage, tv_totalclicks;
    private Double array_spinner[];
    private Spinner loadunits;

    public studentgradecalcu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_studentgradecalcu, container, false);

        init(view);
        load_ads();
        showmytips();
        spinnerloader();
        //for button animation
        animAlpha = AnimationUtils.loadAnimation(getContext(), R.anim.anim_alpha);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateresult();
                v.startAnimation(animAlpha);
            }
        });


        btn_clearonegrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.setText("");
                exam.setText("");
                ttl.setText("Your Computed Grade");
                cp.requestFocus();
                v.startAnimation(animAlpha);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcuunits();
                tv_totalclicks.setText("Total Inputed Grade: " + clickcounter);
                total();
                v.startAnimation(animAlpha);
            }
        });


        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfunctionchangetotalsubj();
                v.startAnimation(animAlpha);
            }
        });

        //function on every text change on total subj
        et_total_subj.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (et_total_subj.getText().toString().matches("")) {
                    clearfunctionchangetotalsubj();
                } else if (et_total_subj.getText().toString() != "") {
                    btn_next.setEnabled(true);
                    et_grade.setEnabled(true);
                    loadunits.setEnabled(true);
                }

                return false;
            }
        });

        return view;
    }

    //loads all controls to application
    private void init(View view) {
        cp = (EditText) view.findViewById(R.id.et_cp1);
        exam = (EditText) view.findViewById(R.id.et_exam1);
        btn_calc = (Button) view.findViewById(R.id.btn_calculate);
        ttl = (TextView) view.findViewById(R.id.ttl_res);
        btn_clearonegrade = (Button) view.findViewById(R.id.btn_clearonegrade);
        loadunits = (Spinner) view.findViewById(R.id.spinner_units);

        numxunits = 0;
        numxgrades = 0;
        numtotalave = 0;
        clickcounter = 0;

        btn_next = (Button) view.findViewById(R.id.btn_computeave);
        btn_clear = (Button) view.findViewById(R.id.calc_btn_clear);


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

        //        preventcomputationiffinished();
    }

    //disables gwa controls
    private void preventcomputationiffinished() {
        btn_next.setEnabled(false);
        et_grade.setEnabled(false);
        loadunits.setEnabled(false);
    }

    //resettings controls of gwa
    private void clearfunctionchangetotalsubj() {
        numxunits = 0;
        numxgrades = 0;
        numtotalave = 0;
        clickcounter = 0;
        et_grade.setText("");
        et_total_subj.setText("");
        tv_totalunits.setText("Calculated Units: " + numxunits);
        tv_totalgrade.setText("Calculated Grade: " + numxgrades);
        tv_totalaverage.setText("GWA: " + numtotalave);
        tv_totalclicks.setText("Total Inputed Grade: " + clickcounter);
        et_total_subj.requestFocus();
        preventcomputationiffinished();
    }

    //calculate cp * 2
    private void calculateresult() {
        try {

            if (cp.getText().toString().matches("") || exam.getText().toString().matches("")) {
                Toast.makeText(getActivity(), "Complete the fields!", Toast.LENGTH_SHORT).show();
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

    //computes total gwa
    private void calcuunits() {
        try {
            if (et_grade.getText().toString().matches("") || et_total_subj.getText().toString().matches("")) {
                Toast.makeText(getContext(), "Fill all fields!", Toast.LENGTH_SHORT).show();
            } else {

                //Calculating Units
                xunits = Double.parseDouble(loadunits.getSelectedItem().toString()) + numxunits;
                numxunits = xunits;
                xresultunits = df.format(numxunits);

                //Calculating Grade (WRONG FORMULA) DOUBLE CHECK YOUR FUCKING REFERENCE
                multixgrade = Double.parseDouble(et_grade.getText().toString()) * Double.parseDouble(loadunits.getSelectedItem().toString());
                xgrades = multixgrade + numxgrades;
                numxgrades = xgrades;
                xresultgrades = df.format(xgrades);


                tv_totalunits.setText("Calculated Units:" + xresultunits);
                tv_totalgrade.setText("Calculated Grade: " + xresultgrades);

                et_grade.setText("");
                loadunits.requestFocus();
                clickcounter = clickcounter + 1;
            }


        } catch (Exception ex) {
            Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    //counts computedgrades
    private void total() {
        try {
            clickrecorder = Integer.parseInt(et_total_subj.getText().toString());
            if (clickcounter == clickrecorder) {
                double ion = Double.parseDouble(xresultgrades) / Double.parseDouble(xresultunits);
                xresultgrades = df.format(ion);
                tv_totalaverage.setText("GWA: " + xresultgrades);
                preventcomputationiffinished();
            }
        } catch (Exception ex) {
            Toast.makeText(getContext(), ex.toString(), Toast.LENGTH_SHORT).show();
        }


    }


    //my fucking Ad revenue
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

    //loading of intersitial
    private void displayInterstitial() {
        // If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    //message tips on calc start
    private void showmytips() {
        StringBuilder builder = new StringBuilder();
        builder.append("1. If you want to calculate only your 'Grade' and 'CP' use the top functions.\n").append("\n");
        builder.append("2. If you want to calculate your GWA use the bottom part calculations.\n").append("\n");
        builder.append("3. In using the bottom part, First you need to input your total subjects that needed to be computed.\n").append("\n");
        builder.append("4. After that you need to input your Units and Grade\n").append("\n");
        builder.append("5. After you input the data needed you can press the compute button.\n").append("\n");
        builder.append("6. After your computation you can press the CLEAR button to have a new calculation").append("\n");
        showMessage("Calculator Tips", builder.toString());
    }

    //builder for message
    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(message);
        builder.show();

    }

    private void spinnerloader() {
        array_spinner = new Double[5];
        array_spinner[0] = 1.0;
        array_spinner[1] = 2.0;
        array_spinner[2] = 3.0;
        array_spinner[3] = 4.0;
        array_spinner[4] = 5.0;
        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.spinnerunitslayout, array_spinner);
        loadunits.setAdapter(adapter);

    }

}