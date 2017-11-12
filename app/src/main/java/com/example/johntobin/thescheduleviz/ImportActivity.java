package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ImportActivity extends AppCompatActivity {

    Button buttonImportGoogleCalendar;
    Button buttonImportFromICal;
    Button buttonManuallyImport

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        buttonImportGoogleCalendar = (Button) findViewById(R.id.buttonImportGoogleCalendar);
        buttonImportFromICal = (Button) findViewById(R.id.buttonImportFromICal);
        buttonManuallyImport = (Button) findViewById(R.id.buttonManuallyImport);

    }
}
