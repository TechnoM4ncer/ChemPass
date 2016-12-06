package com.oniktech.chempass;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
        mChemicalsList = new ArrayList<>();

        Arrays.sort(chemicalList);

        addToList(chemicalList);


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

    public void addToList(String[] array) {
        for (int y = 0; y < array.length; y++) {
            mChemicalsList.add(new Chemicals (array[y], y));
        }
    }

}