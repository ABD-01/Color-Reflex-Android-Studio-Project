package com.colorreflexer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchColors(View view) {
        Intent intent = new Intent(this, ColorRandom.class);
        startActivity(intent);
    }

    public void launchColors_2(View view) {
        Intent intent = new Intent(this, ColorRandom_2.class);
        startActivity(intent);
    }
}
