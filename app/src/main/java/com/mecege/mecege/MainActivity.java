package com.mecege.mecege;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_intro (View view) {
        startActivity(new Intent(getApplicationContext(), IntroActivity.class));
    }

    public void click_circuit (View view) {
        startActivity(new Intent(getApplicationContext(), CircuitActivity.class));
    }

    public void click_micro (View view) {
        startActivity(new Intent(getApplicationContext(), MicroActivity.class));
    }

    public void click_dd1 (View view) {
        startActivity(new Intent(getApplicationContext(), DD1Activity.class));
    }

    public void click_embedded (View view) {
        startActivity(new Intent(getApplicationContext(), EmbeddedActivity.class));
    }
}

