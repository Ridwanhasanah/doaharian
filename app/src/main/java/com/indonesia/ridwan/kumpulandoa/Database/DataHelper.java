package com.indonesia.ridwan.kumpulandoa.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hasanah on 9/13/16.
 */
public class DataHelper /*extends SQLiteOpenHelper*/ {

    /*private static final String DB_NAME = "doa.db";
    private static final int DATABSE_VERSION = 1;

    public DataHelper(Context context){
        super (context, DB_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE doa(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NULL, isi TEXT NULL, arti TEXT NULL, ket TEXT NULL);";
        Log.d("DATA","onCreate: "+sql);
        db.execSQL(sql);
        sql = "INSERT INTO doa (id, title, isi, arti, ket) VALUES (null,'tes','isinya','artinya','ketnya') ;";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }*/
}
