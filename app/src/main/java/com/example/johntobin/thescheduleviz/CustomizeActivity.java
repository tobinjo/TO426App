package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CustomizeActivity extends AppCompatActivity {

    Button buttonBackToWeeklyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        buttonBackToWeeklyPage = (Button) findViewById(R.id.buttonBackToWeeklyPage);
    }
}
