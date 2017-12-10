package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.api.services.calendar.model.CalendarNotification;

public class SplashPage extends Activity {

    private Button buttonbegin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        buttonbegin = (Button) findViewById(R.id.buttonbegin);

        buttonbegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchActivity();
            }

        });

    }

    private void launchActivity() {

        Intent intent = new Intent(this, CalendarTest.class);
        startActivity(intent);
    }
}