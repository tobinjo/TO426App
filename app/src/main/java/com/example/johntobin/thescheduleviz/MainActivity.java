package com.example.johntobin.thescheduleviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToCalendarTest;
    Button takeScreenshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToCalendarTest = (Button) findViewById(R.id.goToCalendarTest);
        goToCalendarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CalendarTest.class);
                startActivity(i);
                finish();
            }
        });

        takeScreenshot = (Button) findViewById(R.id.goToCalendarTest);
        takeScreenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
