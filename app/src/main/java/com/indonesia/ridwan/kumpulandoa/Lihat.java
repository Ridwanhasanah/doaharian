package com.indonesia.ridwan.kumpulandoa;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.indonesia.ridwan.kumpulandoa.Database.DataHelper;

public class Lihat extends AppCompatActivity {

    protected Cursor cursor;
    //DataHelper dbHelper;

    SQLiteDBHelper dbHelper;
    TextView judul,isi,arti,ket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        dbHelper = new SQLiteDBHelper(this);//DataHelper(this);


        judul = (TextView) findViewById(R.id.judul);
        isi = (TextView) findViewById(R.id.isi);
        arti = (TextView) findViewById(R.id.arti);
        ket = (TextView)findViewById(R.id.ket);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM doa where title = '" +
                getIntent().getStringExtra("x")+"'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            judul.setText(cursor.getString(1).toString());
            isi.setText(cursor.getString(2).toString());
            arti.setText(cursor.getString(3).toString());
            ket.setText(cursor.getString(4).toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.daftarisi:
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                return true;

            case R.id.about:
                Intent in = new Intent(getApplicationContext(),About.class);
                startActivity(in);
                return true;
            case R.id.exit:
                new AlertDialog.Builder(this).setMessage("Are you sure want to Exit ?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Lihat.this.finish();

                            }
                        }).setNegativeButton("No",null).show();
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
