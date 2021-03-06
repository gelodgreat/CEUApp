package com.gelo.ceuapp.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.gelo.ceuapp.R;
import com.gelo.ceuapp.database.SQLiteHelper;

import java.util.ArrayList;


public class memo extends Fragment {


    private Button btn_add, btn_del, btn_clear;
    private EditText et_gomemo;
    private GridView gv_memolist;
    private SQLiteHelper myDB;
    private String selectedItem;
    private ArrayList<String> test = new ArrayList<String>();

    public memo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_memo, container, false);

        btn_clear = (Button) view.findViewById(R.id.memo_btn_clear);
        btn_add = (Button) view.findViewById(R.id.memo_btn_add);
        btn_del = (Button) view.findViewById(R.id.memo_btn_delete);
        et_gomemo = (EditText) view.findViewById(R.id.et_gomemo);
        gv_memolist = (GridView) view.findViewById(R.id.memo_list);

        myDB = new SQLiteHelper(getActivity().getApplicationContext());


        et_gomemo.setHint("Your one stop Escolarian Memo " + ("\ud83d\ude06"));

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_memo();
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                del_data();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_gomemo.setText("");
                get_data();
            }
        });

        gv_memolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = parent.getItemAtPosition(position).toString();
                et_gomemo.setText(selectedItem);

                String sm = et_gomemo.getText().toString().trim();
                showMessage("Your Memo " + ("\ud83d\ude0d"), sm);
            }
        });


        get_data();
        return view;
    }

    private void add_memo() {
        if (et_gomemo.getText().toString().trim().matches("")) {
            Toast.makeText(getActivity().getApplicationContext(), "Are you really adding a memo? I'm empty you know! " + ("\ud83d\ude12"), Toast.LENGTH_SHORT).show();
        } else {
            myDB.insertingmemo(et_gomemo.getText().toString().trim());
            Toast.makeText(getActivity().getApplicationContext(), "Noted! " + ("\ud83d\ude06"), Toast.LENGTH_SHORT).show();
            et_gomemo.setText("");
            get_data();
        }
    }

    private void del_data() {
        Integer deletedRows = myDB.delete_memo(et_gomemo.getText().toString());

        if (et_gomemo.getText().toString().trim().matches("")) {
            Toast.makeText(getContext(), "I'm empty, Please fill me. " + ("\ud83d\ude22"), Toast.LENGTH_SHORT).show();
        } else {
            if (deletedRows > 0) {

                Toast.makeText(getContext(), "Memo Deleted! " + ("\ud83d\ude22"), Toast.LENGTH_SHORT).show();
                et_gomemo.setText("");
                get_data();


            } else {
            }
        }
    }

    private void get_data() {
        Cursor cursor = myDB.get_all_memo();


        if (cursor.getCount() <= 0) {
            Toast.makeText(getActivity(), "No Memo Found. " + ("\ud83d\ude1e"), Toast.LENGTH_SHORT).show();
            gv_memolist.setAdapter(null);

        } else {

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


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }
    //
    //    private void savekomunato(){
    //
    //        AlertDialog.Builder alertdialog = new AlertDialog.Builder(getContext());
    //        alertdialog.setTitle("Memo Deletion");
    //        alertdialog.setMessage("Delete this memo? :'(");
    //
    //        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    //            @Override
    //            public void onClick(DialogInterface dialog, int which) {
    //
    //            }
    //        });
    //
    //        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
    //            @Override
    //            public void onClick(DialogInterface dialog, int which) {
    //
    //            }
    //        });
    //    }


}
