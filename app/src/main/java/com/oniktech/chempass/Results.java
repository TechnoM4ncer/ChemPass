package com.oniktech.chempass;


import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    String result;
    String resultImage;
    String resultDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Get Intent from MainActivity
        Intent myIntent = getIntent();
        result = myIntent.getStringExtra("data");

        //Get the TextView and set the text value
        TextView tv = (TextView) findViewById(R.id.result_text);
        tv.setText(result);

        //Assign Image to ImageView
        showImage();
    }

    //Displays image for the chemical on top of activity
    private void showImage() {
        ImageView imageView = (ImageView) findViewById(R.id.result_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
    }
}