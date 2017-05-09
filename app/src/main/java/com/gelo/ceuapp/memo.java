package com.gelo.ceuapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class memo extends Fragment {


    private Button btn_add, btn_del;
    private EditText et_gomemo;
    private GridView gv_memolist;
    private SQLiteHelper myDB;


    public memo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragmentfffff
        final View view = inflater.inflate(R.layout.fragment_memo, container, false);
        btn_add = (Button) view.findViewById(R.id.memo_btn_add);
        btn_del = (Button) view.findViewById(R.id.memo_btn_delete);
        et_gomemo = (EditText) view.findViewById(R.id.et_gomemo);
        gv_memolist = (GridView) view.findViewById(R.id.memo_list);
        myDB = new SQLiteHelper(getActivity().getApplicationContext());


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_gomemo.getText().toString().matches("")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Are you mocking me? Fill me slave!", Toast.LENGTH_LONG).show();
                } else {
                    myDB.insertingmemo(et_gomemo.getText().toString().trim());
                    Toast.makeText(getActivity().getApplicationContext(), "Noted!", Toast.LENGTH_LONG).show();
                    et_gomemo.setText("");
                    get_data();
                }
            }
        });

        get_data();
        return view;
    }

    private void get_data() {
        Cursor cursor = myDB.get_all_memo();

        if (cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "No Memo Found", Toast.LENGTH_LONG).show();
        } else {
            ArrayList<String> test = new ArrayList<String>();
            test.clear();
            ArrayAdapter adapter = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_expandable_list_item_1, test);
            gv_memolist.setAdapter(adapter);
            while (cursor.moveToNext()) {

                String memo = cursor.getString(1);
                test.add(memo);
            }

            adapter.notifyDataSetChanged();
        }


    }


}
