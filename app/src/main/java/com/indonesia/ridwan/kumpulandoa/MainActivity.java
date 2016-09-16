package com.indonesia.ridwan.kumpulandoa;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.indonesia.ridwan.kumpulandoa.Adapter.AdapterRow;
import com.indonesia.ridwan.kumpulandoa.Database.DataHelper;

public class MainActivity extends AppCompatActivity {

    String[] daftar;
    ListView listView;
    protected Cursor cursor;
   // DataHelper dbHelper;
   SQLiteDBHelper dbHelper;
    public static MainActivity ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new SQLiteDBHelper(this); //DataHelper(this);
        //btnCreate();

        ma = this;
        dbHelper = new SQLiteDBHelper(this);//DataHelper(this);
        /**Membuat objek adapterrow */


        SeeDB();

    }

    /*public void btnCreate(){
        Button btn = (Button) findViewById(R.id.btnadd);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Create.class);
                startActivity(i);
            }
        });
    }*/

    public void SeeDB(){

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM doa",null);
        daftar = new  String[cursor.getCount()];
        cursor.moveToFirst();

        for (int i=0; i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(1).toString();
        }

        AdapterRow adapter  = new AdapterRow(MainActivity.this,daftar);

        listView = (ListView) findViewById(R.id.lis);
        /*listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,daftar));*/
        listView.setAdapter(adapter);
        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {

                final String selection = daftar[i];

                Intent z = new Intent(getApplicationContext(),Lihat.class);
                z.putExtra("x",selection);
                startActivity(z);

                /*final CharSequence[] dialogitem = {"Lihat","Upadte","Hapus"};

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Plih");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                Intent x = new Intent(getApplicationContext(),Lihat.class);
                                x.putExtra("v",selection);
                                startActivity(x);
                                break;
                            case 1:
                                Intent t = new Intent(getApplicationContext(),Update.class);
                                t.putExtra("v",selection);
                                startActivity(t);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("DELETE FROM doa WHERE title = '"+selection+"'");
                                SeeDB();
                                break;
                        }
                    }
                });*/
                //builder.create().show();
            }
        });
        /**unutk memberitahu jika ada perubahan data*/
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetInvalidated();
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
                Intent x = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(x);
                return true;
            case R.id.about:
                Intent in = new Intent(MainActivity.this,About.class);
                startActivity(in);
                return true;
            case R.id.exit:
                new AlertDialog.Builder(this).setMessage("Are you sure want to Exit ?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                MainActivity.this.finish();
                            }
                        }).setNegativeButton("No",null).show();
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setMessage("Are you sure want to Exit ?").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                }).setNegativeButton("No",null).show();
    }
}
