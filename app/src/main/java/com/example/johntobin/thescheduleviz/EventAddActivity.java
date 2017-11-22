package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EventAddActivity extends AppCompatActivity{


        Button buttonDone;
        Button buttonAddTitle;
        Button buttonUpdateEvent;
        EditText AddTitle;
        EditText UpdateEvent;

        DatabaseReference database = FirebaseDatabase.getInstance().getReference();


@Override
protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_add);

        AddTitle = (EditText) findViewById(R.id.editTextTitleEvent);
        UpdateEvent = (EditText) findViewById(R.id.editTextEventInfo);

        buttonAddTitle = (Button)findViewById(R.id.buttonAddTitle);
        buttonAddTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        if (!AddTitle.getText().toString().equalsIgnoreCase("")){
                                        database.child("Monday").child("EventTitle").setValue(AddTitle.getText().toString());


                        }


                }
        });

        buttonDone=(Button)findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
        });
        }
        }





