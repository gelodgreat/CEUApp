package com.gelo.ceuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by AngeloDesktop on 9 May 2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "ceumemo";
    public static final String CEUMemoDB = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, memos TEXT)";
    public static final String DropExistingDB = "DROP TABLE IF EXIST " + TABLE_NAME;
    private static final String DATABASE_NAME = "ceumemodb.db";


    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CEUMemoDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropExistingDB);
        onCreate(db);
    }

    public boolean insertingmemo(String memo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("memos", memo);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != 1;

    }

    public Cursor get_all_memo() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    public Integer delete_memo(String memos) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "memos = ?", new String[]{memos});
    }

}
