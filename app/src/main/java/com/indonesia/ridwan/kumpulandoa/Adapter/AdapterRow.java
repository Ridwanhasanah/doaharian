package com.indonesia.ridwan.kumpulandoa.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.indonesia.ridwan.kumpulandoa.R;

/**
 * Created by hasanah on 9/14/16.
 */
public class AdapterRow extends ArrayAdapter<String>{

    private final Activity mContext;
    private String[] mJ;

    public AdapterRow (Activity context, String[] J){
        super(context, R.layout.rowlist,J);
        mContext=context;
        mJ = J;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View view = inflater.inflate(R.layout.rowlist,null,true);
        TextView textrow = (TextView)view.findViewById(R.id.texrow);
        textrow.setText(mJ[position]);
        return view;
    }
}
