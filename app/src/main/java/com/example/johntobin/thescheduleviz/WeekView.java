/*
package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.EventListener;


public class WeekView extends Activity implements View.OnClickListener{

    private Button btnWeekView;// button for week view
    private WeekView mWeekView; // I don't really know what this creates but holds week view

    //mWeekView.setMonthChangeListener(mMonthChangeListener);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        btnWeekView = (Button) findViewById(R.id.btnWeekView);
        btnWeekView.setOnClickListener(this); // set an action where button listener activates when clicked


        mWeekView = (WeekView) findViewById(R.id.weekView); // set a reference for the week view
        mWeekView.EventClickListener(this);
        mWeekView.onEventListener(mEventClickListener); //set an action when any event is clicked










    }
    @Override
    public void onClick(View view) {


        if (view.getId() == R.id.btnWeekView){ //if button week view is clicked

            btnWeekView.setMonthChangeListener(mMonthChangeListener);

            MonthLoader.MonthChangeListener mMonthChangeListener = new MonthLoader.MonthChangeListener() {
                @Override
                public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                    // Populate the week view with some events.
                    List<WeekViewEvent> events = getEvents(newYear, newMonth);
                    return events;
                }
            };





        }



    }







}
*/
