package com.gelo.ceuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Colleges extends Fragment {

    public static String title;
    public static EditText et_aboutt;

    public Colleges() {
        // Required empty public constructor
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        et_aboutt = (EditText) getView().findViewById(R.id.et_aboutt);
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
        //return inflater.inflate(R.layout.fragment_colleges, container, false);
        final View view = inflater.inflate(R.layout.fragment_colleges, container, false);
        final DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer_layout);

        ImageView img_scitech = (ImageView) view.findViewById(R.id.img_scitech);
        img_scitech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "School of Science and Technology";
                startActivity(intent);

                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_Pharma = (ImageView) view.findViewById(R.id.img_pharma);
        img_Pharma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "School of Pharmacy";
                startActivity(intent);

                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_dent = (ImageView) view.findViewById(R.id.img_dent);
        img_dent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "School of Dentistry";
                startActivity(intent);

                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_opto = (ImageView) view.findViewById(R.id.img_opto);
        img_opto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Optometry";
                startActivity(intent);

                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_mt = (ImageView) view.findViewById(R.id.img_mt);
        img_mt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Medical Technology";
                startActivity(intent);

                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_gradschool = (ImageView) view.findViewById(R.id.img_gradschool);
        img_gradschool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Graduate School";
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_nhm = (ImageView) view.findViewById(R.id.img_nhm);
        img_nhm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Nutrition and Hospitality Management";
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_nursing = (ImageView) view.findViewById(R.id.img_nursing);
        img_nursing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Nursing";
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_sam = (ImageView) view.findViewById(R.id.img_sam);
        img_sam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Accountancy and Management";
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });

        ImageView img_selams = (ImageView) view.findViewById(R.id.img_selams);
        img_selams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.gelo.ceuapp.Information");
                title = "College of Education-Liberal Arts-Music-Social Work";
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.animation, R.anim.animation2);

            }

        });


        return view;
    }

}
