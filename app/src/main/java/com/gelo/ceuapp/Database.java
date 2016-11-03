package com.gelo.ceuapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ANDREW on 12/7/2015.
 */
public class Database extends SQLiteOpenHelper{

    public static final String db_name="Ceuapp.db";
    public static final String tbl_name="places";
    public static final String col1="id";
    public static final String col2="desc";
    public static final String col3="locator";


    public Database(Context context) {
        super(context, db_name, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+tbl_name+" (id integer primary key, desc text, locator text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+tbl_name);
        onCreate(db);

    }
}
