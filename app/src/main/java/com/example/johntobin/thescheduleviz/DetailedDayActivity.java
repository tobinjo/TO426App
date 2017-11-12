package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class DetailedDayActivity extends AppCompatActivity {

    Button buttonBackToWeeklySchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_day);

        buttonBackToWeeklySchedule = (Button) findViewById(R.id.buttonBackToWeeklySchedule);

    }
}
