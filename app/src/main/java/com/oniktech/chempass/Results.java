package com.oniktech.chempass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent myIntent = getIntent();
        String select = myIntent.getStringExtra("data");

        TextView tv = (TextView) findViewById(R.id.result_text);
        tv.setText(select);


    }
}
