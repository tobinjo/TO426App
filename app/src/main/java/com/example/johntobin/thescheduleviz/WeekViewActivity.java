package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekViewEvent;
import com.alamkanak.weekview.WeekView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.EventListener;
import java.util.List;


public class WeekViewActivity extends Activity {

    private Button btnScreenshot;// button for week view
    private WeekView mWeekView; // I don't really know what this creates but holds week view



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);


        mWeekView = (WeekView) findViewById(R.id.weekView); // set a reference for the week view
        btnScreenshot = (Button) findViewById(R.id.screenshotAndSet2);

        mWeekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

                List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR, 1);
                endTime.set(Calendar.MONTH, newMonth-1);
                WeekViewEvent event = new WeekViewEvent(1, "Test Event 1", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 4);
                endTime.set(Calendar.MINUTE, 30);
                endTime.set(Calendar.MONTH, newMonth-1);
                event = new WeekViewEvent(10, "Test Event 2", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 4);
                startTime.set(Calendar.MINUTE, 20);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.set(Calendar.HOUR_OF_DAY, 5);
                endTime.set(Calendar.MINUTE, 0);
                event = new WeekViewEvent(10, "Test Event 3", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 30);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 2);
                endTime.set(Calendar.MONTH, newMonth-1);
                event = new WeekViewEvent(2, "Test Event 4", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, 5);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                startTime.add(Calendar.DATE, 1);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                endTime.set(Calendar.MONTH, newMonth - 1);
                event = new WeekViewEvent(3, "Test Event 5", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 15);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(4, "Test Event 6", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, 1);
                startTime.set(Calendar.HOUR_OF_DAY, 3);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, "Test Event 7", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);

                startTime = Calendar.getInstance();
                startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
                startTime.set(Calendar.HOUR_OF_DAY, 15);
                startTime.set(Calendar.MINUTE, 0);
                startTime.set(Calendar.MONTH, newMonth-1);
                startTime.set(Calendar.YEAR, newYear);
                endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, 3);
                event = new WeekViewEvent(5, "Test Event 8", startTime, endTime);
                event.setColor(getResources().getColor(R.color.colorCustomBlue));
                events.add(event);
                return events;
            }
        });

    }







}
