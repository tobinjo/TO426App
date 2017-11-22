package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WeeklyRoundupActivity extends AppCompatActivity {

    Button buttonConfirmDaySelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_roundup);

        buttonConfirmDaySelection = (Button) findViewById(R.id.buttonConfirmDaySelection);
        buttonConfirmDaySelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
