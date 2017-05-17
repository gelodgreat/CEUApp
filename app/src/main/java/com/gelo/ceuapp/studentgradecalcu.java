package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class studentgradecalcu extends Fragment {

    double icp, iexam;
    DecimalFormat df = new DecimalFormat("#.00");
    mymethods mm = new mymethods();
    String leftValue = "";
    String rightValue = "";
    String ahoy = "";

    Operations currentoperations;
    double resultsavg = 0;


    private ImageView btn_calc_avg;
    private EditText cp, exam, numavg;
    private Button btn_calc, btn_1, btn_125, btn_15, btn_175, btn_2, btn_225, btn_25, btn_275, btn_3, btn_4, btn_5, btn_clear;
    private TextView ttl, avg_result;


    private String runningnumber = "";

    public studentgradecalcu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_studentgradecalcu, container, false);

        init(view);
        load_clicks(view);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateresult();
            }
        });

        return view;
    }

    private void init(View view) {

        cp = (EditText) view.findViewById(R.id.et_cp1);
        exam = (EditText) view.findViewById(R.id.et_exam1);
        btn_calc = (Button) view.findViewById(R.id.btn_calculate);
        ttl = (TextView) view.findViewById(R.id.ttl_res);

        numavg = (EditText) view.findViewById(R.id.tv_numavg);
        avg_result = (TextView) view.findViewById(R.id.tv_results);
        btn_1 = (Button) view.findViewById(R.id.btn_one);
        btn_125 = (Button) view.findViewById(R.id.btn_125);
        btn_15 = (Button) view.findViewById(R.id.btn_15);
        btn_175 = (Button) view.findViewById(R.id.btn_175);
        btn_2 = (Button) view.findViewById(R.id.btn_two);
        btn_225 = (Button) view.findViewById(R.id.btn_225);
        btn_25 = (Button) view.findViewById(R.id.btn_25);
        btn_275 = (Button) view.findViewById(R.id.btn_275);
        btn_3 = (Button) view.findViewById(R.id.btn_three);
        btn_4 = (Button) view.findViewById(R.id.btn_four);
        btn_5 = (Button) view.findViewById(R.id.btn_5);
        btn_clear = (Button) view.findViewById(R.id.calc_btn_clear);
        btn_calc_avg = (ImageView) view.findViewById(R.id.btn_calc_avg);

        numavg.setInputType(InputType.TYPE_CLASS_NUMBER);
        cp.setInputType(InputType.TYPE_CLASS_NUMBER);
        exam.setInputType(InputType.TYPE_CLASS_NUMBER);

    }

    private void load_clicks(View view) {
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(1.0);
                processOperation(Operations.ADD);
            }
        });

        btn_125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(1.25);
                processOperation(Operations.ADD);
            }
        });

        btn_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(1.5);
                processOperation(Operations.ADD);
            }
        });

        btn_175.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(1.75);
                processOperation(Operations.ADD);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(2.0);
                processOperation(Operations.ADD);
            }
        });

        btn_225.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(2.25);
                processOperation(Operations.ADD);
            }
        });

        btn_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(2.5);
                processOperation(Operations.ADD);
            }
        });

        btn_275.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(2.75);
                processOperation(Operations.ADD);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(3.0);
                processOperation(Operations.ADD);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(4.0);
                processOperation(Operations.ADD);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(5.0);
                processOperation(Operations.ADD);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avg_result.setText("");
                numavg.setText("");
                rightValue = "";
                leftValue = "";
                resultsavg = 0;
                runningnumber = "";
                currentoperations = null;
            }
        });

        btn_calc_avg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void numPressed(double number) {
        runningnumber += String.valueOf(number);
        avg_result.setText(runningnumber);
    }

    private void calculateresult() {

        if (cp.getText().toString().matches("") | exam.getText().toString().matches("")) {
            Toast.makeText(getActivity(), "Complete the Value", Toast.LENGTH_LONG).show();
        } else {
            icp = Double.parseDouble(cp.getText().toString());
            iexam = Double.parseDouble(exam.getText().toString());

            Double result = mm.calc(icp, iexam);

            String xresult = df.format(result);
            ttl.setText("Your Grade is: " + xresult);
        }
    }

    private void processOperation(Operations operations) {
        ahoy = numavg.getText().toString();

        if (currentoperations != null) {
            if (runningnumber != "") {
                rightValue = runningnumber;
                runningnumber = "";

                switch (currentoperations) {
                    case ADD:
                        resultsavg = Double.parseDouble(leftValue) + Double.parseDouble(rightValue);
                        break;
                }
                leftValue = String.valueOf(resultsavg);
                avg_result.setText(leftValue);
            }
        } else {
            leftValue = runningnumber;
            runningnumber = "";
        }
        currentoperations = operations;
    }

    private enum Operations {
        ADD, AVG
    }


}
