package com.example.johntobin.thescheduleviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImportActivity extends AppCompatActivity {

    Button buttonImportGoogleCalendar;
    Button buttonImportFromICal;
    Button buttonManuallyImport;

    Button buttonBackFromImport; //jasmine added back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import);

        buttonImportGoogleCalendar = (Button) findViewById(R.id.buttonImportGoogleCalendar);
        buttonImportFromICal = (Button) findViewById(R.id.buttonImportFromICal);
        buttonManuallyImport = (Button) findViewById(R.id.buttonManuallyImport);

        buttonBackFromImport = (Button) findViewById(R.id.buttonBackFromImport); //jasmine added back button

        buttonBackFromImport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }


        });
    }
    private void launchActivity() {

        Intent goToSplash = new Intent(this, SplashPage.class);
        startActivity(goToSplash);
    }
}



