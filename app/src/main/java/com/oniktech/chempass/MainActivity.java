package com.oniktech.chempass;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/* Created by aepplijonathan on 12/04/2016 */

public class MainActivity extends Activity {
    private ListView lvChemicals;
    private ChemicalsListAdapter adapter;
    private List<Chemicals> mChemicalsList;

    String[] chemicalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chemicalList = getResources().getStringArray(R.array.chemicals_array);
        lvChemicals = (ListView) findViewById(R.id.listview_chemicals);
        int x = 1;
        mChemicalsList = new ArrayList<>();
        mChemicalsList.add(new Chemicals(inArray(chemicalList), x++));

        //Init adapter
        adapter = new ChemicalsListAdapter(getApplicationContext(), mChemicalsList);
        lvChemicals.setAdapter(adapter);

        lvChemicals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                Toast.makeText(getApplicationContext(), "Clicked chemical id = " + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static String inArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            return array[i];
        }
        return null;
    }
}