package com.gelo.ceuapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AngeloDesktop on 11 May 2017.
 */


public class CustomListAdapter extends ArrayAdapter<String> {

    public ListBuildings ls = new ListBuildings();
    private Activity context;
    private String[] bldgname;
    private Integer[] imgid;
    private TextView txtname, txtdesc;
    private ImageView img_bldg;

    public CustomListAdapter(Activity context, String[] bldgname, Integer[] imgid) {
        super(context, R.layout.list_bldg_single, bldgname);

        this.context = context;
        this.bldgname = bldgname;
        this.imgid = imgid;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.list_bldg_single, null, true);

        txtname = (TextView) rowview.findViewById(R.id.txt_bldg_name);
        txtdesc = (TextView) rowview.findViewById(R.id.txt_bldg_desc);
        img_bldg = (ImageView) rowview.findViewById(R.id.img_bldg);

        txtname.setText(bldgname[position]);
        txtdesc.setText("Description: " + bldgname[position]);
        img_bldg.setImageResource(imgid[position]);

        ls.touched = txtname.getText().toString();
        return rowview;
    }
}
