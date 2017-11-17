package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ConfirmationActivity extends AppCompatActivity {

    Button buttonConfirmSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        buttonConfirmSchedule = (Button) findViewById(R.id.buttonConfirmSchedule);



    }
}
