package com.oniktech.chempass;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by KinoDe on 12/4/2016.
 */

public class ChemicalsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Chemicals> mChemicalsList;

    //Constructor
    public ChemicalsListAdapter(Context mContext, List<Chemicals> mChemicalsList) {
        this.mContext = mContext;
        this.mChemicalsList = mChemicalsList;
    }

    @Override
    public int getCount() {
        return mChemicalsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mChemicalsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.chemical_list, null);
        TextView chemicalName = (TextView)v.findViewById(R.id.chemical_Name);

        //Set text for TextView
        chemicalName.setText(mChemicalsList.get(position).getChemical());

        //Save Chemical id to tag
        v.setTag(mChemicalsList.get(position).getId());

        return v;
    }
}
