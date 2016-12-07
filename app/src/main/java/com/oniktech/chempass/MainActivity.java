package com.oniktech.chempass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ListView
        ListView lvChemicals = (ListView) findViewById(R.id.listViewChemicals);

        //Create ArrayList for chemicals
        ArrayList<String> mChemicalsList = new ArrayList<>();

        //Add chemicals to ArrayList from arr resource
        mChemicalsList.addAll(Arrays.asList(getResources().getStringArray(R.array.chemicals_array)));

        //Sort alphabetically
        Collections.sort(mChemicalsList);

        //Create ArrayAdapter
        adapter = new ArrayAdapter<> (MainActivity.this,
                android.R.layout.simple_list_item_1,
                mChemicalsList);
        lvChemicals.setAdapter(adapter);

        //Create onClickListener for ArrayAdapter
        lvChemicals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Go to next Activity via Intent with chemical selected
                String select = adapter.getItem(position);
                Intent myIntent = new Intent(MainActivity.this, Results.class);
                myIntent.putExtra("data", select);
                startActivity(myIntent);
            }
        });
    }
    //Create search bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

        //Search bar functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}