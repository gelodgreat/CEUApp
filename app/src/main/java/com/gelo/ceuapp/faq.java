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
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class faq extends Fragment {

public static EditText et_aboutt;

    public faq() {
        // Required empty public constructor
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        et_aboutt = (EditText)getView().findViewById(R.id.et_aboutt);
        //noinspection SimplifiableIfStatement
        if (id == R.id.aboutdevss) {

            Intent intent= new Intent(getActivity(),aboutform.class);
            et_aboutt.setText("devs");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.aboutapps){
            Intent intent= new Intent(getActivity(),aboutform.class);
            et_aboutt.setText("apps");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.aboutdisclaimer){
            Intent intent= new Intent(getActivity(),aboutform.class);
            et_aboutt.setText("disclaimer");
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_faq, container, false);

        Button btn_offense = (Button) view.findViewById(R.id.btn_offense);
        btn_offense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.Offenses");
                startActivity(intent);
            }

        });

        Button btn_ceuchoosemusic = (Button) view.findViewById(R.id.btn_ceuchoosemusic);
        btn_ceuchoosemusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceuchoosemusic");
                startActivity(intent);
            }
        });

        Button btn_gotoenroll = (Button) view.findViewById(R.id.btn_enroll);
        btn_gotoenroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.chooseenroll");
                startActivity(intent);
            }
        });

        Button btn_othertransac = (Button)view.findViewById(R.id.btn_othertransac);
        btn_othertransac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.othertransac");
                startActivity(intent);
            }
        });


        Button board = (Button)view.findViewById(R.id.btn_board);
        board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent("com.gelo.ceuapp.ceuboard");
                startActivity(intent);
            }
        });


        return view;
    }

}
