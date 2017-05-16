package com.gelo.ceuapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class studentgradecalcu extends Fragment {

    double icp, iexam;
    DecimalFormat df = new DecimalFormat("#.00");
    private EditText cp, exam;
    private Button btn_calc;
    private TextView ttl;
    mymethods mm = new mymethods();

    public studentgradecalcu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_studentgradecalcu, container, false);

        init(view);

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

        cp.setInputType(InputType.TYPE_CLASS_NUMBER);
        exam.setInputType(InputType.TYPE_CLASS_NUMBER);

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


}
