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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class studentgradecalcu extends Fragment {
    double myfuckingresult = 0;
    double icp, iexam;
    String ahoy;
    String xresult;
    DecimalFormat df = new DecimalFormat("#.00");
    mymethods mm = new mymethods();
    Operations currentoperations;
    String runningnumber = "";
    String leftValue = "";
    String rightValue = "";
    double resultsavg = 0;
    private ImageButton btn_calc_avg_me;
    private EditText cp, exam, numavg;
    private Button btn_calc, btn_1, btn_125, btn_15, btn_175, btn_2, btn_225, btn_25, btn_275, btn_3, btn_4, btn_5, btn_clear, btn_clearonegrade;
    private TextView ttl, avg_result;

    public studentgradecalcu() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_studentgradecalcu, container, false);

        init(view);
        load_clicks(view);
        buttonconditions();
        changesonnumavg();


        showmytips();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateresult();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avg_result.setText("Your Average Grade:");
                numavg.setText("");
                rightValue = "";
                leftValue = "";
                resultsavg = 0;
                runningnumber = "";
                currentoperations = null;
                buttonconditions();
            }
        });

        btn_clearonegrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.setText("");
                exam.setText("");
                ttl.setText("Your Computed Grade");
            }
        });

        return view;
    }

    private void buttonconditions() {
        if (numavg.getText().toString().matches("")) {
            buttonsdisabled();
        } else {
            buttonsenabled();
        }
    }

    private void changesonnumavg() {
        numavg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                buttonconditions();
                return false;
            }
        });
    }

    private void buttonsdisabled() {
        btn_1.setEnabled(false);
        btn_125.setEnabled(false);
        btn_15.setEnabled(false);
        btn_175.setEnabled(false);
        btn_2.setEnabled(false);
        btn_225.setEnabled(false);
        btn_25.setEnabled(false);
        btn_275.setEnabled(false);
        btn_3.setEnabled(false);
        btn_4.setEnabled(false);
        btn_5.setEnabled(false);
    }

    private void buttonsenabled() {
        btn_1.setEnabled(true);
        btn_125.setEnabled(true);
        btn_15.setEnabled(true);
        btn_175.setEnabled(true);
        btn_2.setEnabled(true);
        btn_225.setEnabled(true);
        btn_25.setEnabled(true);
        btn_275.setEnabled(true);
        btn_3.setEnabled(true);
        btn_4.setEnabled(true);
        btn_5.setEnabled(true);
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
        btn_clearonegrade = (Button) view.findViewById(R.id.btn_clearonegrade);
        btn_clear = (Button) view.findViewById(R.id.calc_btn_clear);
        btn_calc_avg_me = (ImageButton) view.findViewById(R.id.btn_calc_avg_me);


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

        btn_calc_avg_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    if (numavg.getText().toString().matches("") | resultsavg == 0) {
                        Toast.makeText(getContext(), "Please input your total subjects to be computed!", Toast.LENGTH_SHORT).show();
                    } else {

                        ahoy = numavg.getText().toString();

                        myfuckingresult = resultsavg / Double.parseDouble(ahoy);
                        xresult = df.format(myfuckingresult);
                        avg_result.setText(xresult);

                        Toast.makeText(getContext(), xresult, Toast.LENGTH_SHORT);
                    }


                } catch (Exception ex) {
                    showMessage("Error", ex.toString());
                }
            }
        });
    }

    private void numPressed(double number) {
        runningnumber += String.valueOf(number);
        avg_result.setText(runningnumber);
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


    private void processOperation(Operations operations) {

        try {

            if (currentoperations != null) {
                if (runningnumber != "") {
                    rightValue = runningnumber;
                    runningnumber = "";


                    switch (currentoperations) {
                        case ADD:

                            resultsavg = Double.parseDouble(leftValue) + Double.parseDouble(rightValue);
                            xresult = df.format(resultsavg);
                            break;
                    }
                    leftValue = String.valueOf(xresult);
                    avg_result.setText(leftValue);
                }
            } else {
                leftValue = runningnumber;
                runningnumber = "";
            }
            currentoperations = operations;
        } catch (Exception ex) {
            showMessage("Error", ex.toString());
        }
    }

    private void showmytips() {
        StringBuilder builder = new StringBuilder();
        builder.append("1. If you want to calculate only your 'Grade' and 'CP' use the top functions.\n").append("\n");
        builder.append("2. If you want to calculate your average grade use the bottom part calculations.\n").append("\n");
        builder.append("3. In using the bottom part, First you need to input your total subjects that needed to be computed\n").append("\n");
        builder.append("4. After that you may now click your grades to be computed.");
        showMessage("Calculator Tips", builder.toString());
    }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);

        builder.setMessage(message);
        builder.show();

    }


    private enum Operations {
        ADD
    }
}