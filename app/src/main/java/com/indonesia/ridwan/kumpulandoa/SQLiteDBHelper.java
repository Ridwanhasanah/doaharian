package com.indonesia.ridwan.kumpulandoa;

/**
 * Created by hasanah on 9/16/16.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "doa.db";
    private static final String DB_PATH_SUFFIX = "/databases/";

    private  static final String TABLE_LABELS = "doa";
    static Context context;

    public SQLiteDBHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;
    }

    public ArrayList<Doa> toArray(){
        return this.toArray();
    }

    public ArrayList<Doa> toArray(String filterText){
        Cursor cursor = null;
        ArrayList<Doa> allDoa = null;

        try{
            allDoa = new ArrayList<Doa>();

            SQLiteDatabase db = this.getReadableDatabase();
            cursor = db.rawQuery("SELECT * FROM"+TABLE_LABELS,null);
            if (cursor.getCount()>0){
                int indexId = cursor.getColumnIndex("id");
                int indexTitle = cursor.getColumnIndex("title");
                int indexIsi = cursor.getColumnIndex("isi");
                int indexArti = cursor.getColumnIndex("arti");
                int indexKet = cursor.getColumnIndex("ket");
                cursor.moveToFirst();
                do {
                    int doaId = cursor.getInt(indexId);
                    String doaTitle = cursor.getString(indexTitle);
                    String doaIsi = cursor.getString(indexIsi);
                    String doaArti = cursor.getString(indexArti);
                    String doaKet = cursor.getString(indexKet);

                    Doa isix = new Doa();
                    isix.setDoaId(doaId);
                    isix.setDoaTitle(doaTitle);
                    isix.setDoaIsi(doaIsi);
                    isix.setDoaArti(doaArti);
                    isix.setDoaKet(doaKet);

                    allDoa.add(isix);
                    cursor.moveToNext();
                }while (!cursor.isAfterLast());
            }
        }finally {
            if (cursor != null){
                cursor.close();
            }
        }return allDoa;
    }

    public void CopyDataBaseAsset()throws IOException{
        InputStream myInput = context.getAssets().open(DATABASE_NAME);

        String outFileName = getDatabasePath();

        File f = new File(context.getApplicationInfo().dataDir+DB_PATH_SUFFIX);
        if (!f.exists())
            f.mkdir();

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) >0){
            myOutput.write(buffer,0,length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public static String getDatabasePath(){
        return context.getApplicationInfo().dataDir + DB_PATH_SUFFIX + DATABASE_NAME;

    }

    public SQLiteDatabase openDataBase() throws SQLException{
        File dbFile = context.getDatabasePath(DATABASE_NAME);

        if (!dbFile.exists()){
            try{
                CopyDataBaseAsset();
                System.out.println("Copying sucess from Assets folder");
            }catch (IOException e ){
                throw new RuntimeException("Error creating source databse",e);
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

