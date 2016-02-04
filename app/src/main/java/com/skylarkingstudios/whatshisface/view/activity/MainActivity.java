package com.skylarkingstudios.whatshisface.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skylarkingstudios.whatshisface.R;

public class MainActivity extends AppCompatActivity {

    Button movieFeature;
    Button actorFeature;

    // Main activity using bare-bones layout until Movie module is finished and Actor module is set up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pressedMovies(View v) {
        Intent i = new Intent(MainActivity.this, MovieSearchActivity.class);
        startActivity(i);
    }
}
