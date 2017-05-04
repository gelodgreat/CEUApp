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


/**
 * A simple {@link Fragment} subclass.
 */
public class about extends Fragment {

    public static EditText et_about;

    public about() {
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

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        Button btn_devs = (Button) view.findViewById(R.id.btn_devs);
        Button btn_apps = (Button) view.findViewById(R.id.btn_apps);
        Button btn_disclaimer = (Button) view.findViewById(R.id.btn_disclaimer);
        et_about = (EditText) view.findViewById(R.id.et_about);

        btn_devs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent= new Intent("com.gelo.ceuapp.aboutform");
                //Intent intent = new Intent("com.gelo.ceuapp.About_developers");
                Intent intent = new Intent("com.gelo.ceuapp.DevelperPage");
                et_about.setText("devs");
                startActivity(intent);
            }
        });

        btn_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Disclaimer");
                et_about.setText("apps");
                startActivity(intent);

            }
        });

        btn_disclaimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Disclaimer");
                et_about.setText("disclaimer");
                startActivity(intent);
            }
        });


        return view;

    }


}





