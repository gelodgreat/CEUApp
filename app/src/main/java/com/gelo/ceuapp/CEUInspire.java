package com.gelo.ceuapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CEUInspire extends Fragment {

    EditText et_aboutt;

    String[]note={
            "Philippians 1:6 And I am sure of this, that he who began a good work in you will bring it to completion at the day of Jesus Christ.",
            "Joshua 1:9 \n…Have I not commanded you? Be strong and courageous. Do not be frightened, and do not be dismayed, for the Lord your God is with you wherever you go.",
            "1 Kings 8:57 \nThe Lord our God be with us, as he was with our fathers. May he not leave us or forsake us.",
            "Ephesians 2:10 \nFor we are his workmanship, created in Christ Jesus for good works, which God prepared beforehand, that we should walk in them.",
            "Romans 8:28 \nAnd we know that for those who love God all things work together for good, for those who are called according to his purpose.",
            "Philippians 4:13 \nI can do all things through him who strengthens me.",
            "Colossians 3:23 \nWhatever you do, work at it with all your heart, as working for the Lord, not for human masters,",
            "Proverbs 16:3 \nCommit to the Lord Whatever you do and HE will establish your plans.",
            "Psalm 118:24 \nThis is the day that the Lord has made, we will rejoice and be glad in it.",
            "Galatians 6:9 \nLet us not become weary in doing good, for at the proper time we will reap a harvest if we do not give up.",
            "Failure defeats losers, failure inspires winners – Robert T. Kiyosaki",
            "Some people dream of great accomplishments, while others stay awake and do them – Anonymous",
            "I cannot give you the formula for success, but I can give you the formula for failure, which is: Try to please everybody. – Herbert B. Swope",
            "If you have always done it that way, it is probably wrong. – Charles Kettering",
            "Being different is one of the most beautiful things on earth. – Anonymous",
            "Creativity is intelligence having fun. – Albert Einsten",
            "The expert in anything was once a beginner. – Helen Hayes",
            "You must be the change you wish to see in the world. – Mahatma Gandhi"


    };

    int caller=(int) (18.0*Math.random());


    public CEUInspire() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ceuinspire, container, false);

        final View view = inflater.inflate(R.layout.fragment_ceuinspire, container, false);

        TextView q=(TextView)view.findViewById(R.id.quote);
        q.setText(note[caller]);


        return view;
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

}
