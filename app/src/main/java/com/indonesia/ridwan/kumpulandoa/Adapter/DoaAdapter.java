package com.indonesia.ridwan.kumpulandoa.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.indonesia.ridwan.kumpulandoa.Doa;
import com.indonesia.ridwan.kumpulandoa.R;

import java.util.ArrayList;

/**
 * Created by hasanah on 9/16/16.
 */
public class DoaAdapter extends BaseAdapter {

    private ArrayList<Doa> listdoa = null;
    private static LayoutInflater inflater = null;
    private Context context;

    public DoaAdapter(Activity activity){
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        context = activity.getApplicationContext();
    }

    public void updatelistdoa(ArrayList<Doa> newListDoa){
        this.listdoa = newListDoa;
    }

    @Override
    public int getCount() {
        return this.listdoa.size();
    }

    public Doa getItem(int position){
        return this.listdoa.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @SuppressLint("InflateParams") @Override
    public View getView (int position, View view, ViewGroup viewGroup){
        View v = view;
        if (v == null){
            v = inflater.inflate(R.layout.rowlist,null);
        }

        Doa psn = this.listdoa.get(position);

        TextView texrow = (TextView)v.findViewById(R.id.texrow);

        texrow.setText(psn.getDoaTitle());

        return v;
    }

}
