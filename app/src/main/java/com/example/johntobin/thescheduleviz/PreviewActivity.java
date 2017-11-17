package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PreviewActivity extends AppCompatActivity {

    Button buttonFinalize;
    Button buttonGoBackToCustomize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        buttonFinalize = (Button) findViewById(R.id.buttonFinalize);
        buttonGoBackToCustomize = (Button) findViewById(R.id.buttonGoBackToCustomize);
    }
}
