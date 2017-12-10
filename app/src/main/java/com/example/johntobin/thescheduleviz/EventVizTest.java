package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Button;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.graphics.Bitmap.CompressFormat;
import android.content.Context;
import android.graphics.Color;

import org.w3c.dom.Text;

import com.alamkanak.weekview.DateTimeInterpreter;
import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

@TargetApi(24)
public class EventVizTest extends Activity {

    private SimpleDateFormat sdfone = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private SimpleDateFormat sdftwo = new SimpleDateFormat("HH:mm:ss");

    private WeekView mWeekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_display);
        mWeekView = (WeekView) findViewById(R.id.weekView2);

        Bundle extras = getIntent().getExtras();
        int textColor = extras.getInt("textColor");
        mWeekView.setEventTextColor(textColor);
        final int eventColor = extras.getInt("eventColor");
        int backgroundColor = extras.getInt("backgroundColor");
        mWeekView.setDayBackgroundColor(backgroundColor);


        mWeekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
            @Override
            public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                List<WeekViewEvent> events = new ArrayList<WeekViewEvent>();
                Bundle extras = getIntent().getExtras();
                if (extras != null){
                    ArrayList<String> eventNames = extras.getStringArrayList("eventNames");
                    ArrayList<Integer> eventStartTimesMth = extras.getIntegerArrayList("eventStartTimesMth");
                    ArrayList<Integer> eventStartTimesD = extras.getIntegerArrayList("eventStartTimesD");
                    ArrayList<Integer> eventStartTimesH = extras.getIntegerArrayList("eventStartTimesH");
                    ArrayList<Integer> eventStartTimesM = extras.getIntegerArrayList("eventStartTimesM");
                    ArrayList<Integer> eventEndTimesH = extras.getIntegerArrayList("eventEndTimesH");
                    ArrayList<Integer> eventEndTimesM = extras.getIntegerArrayList("eventEndTimesM");

                    for(int i = 0; i < eventNames.size(); ++i){
                        Calendar startTime = Calendar.getInstance();
                        startTime.set(Calendar.DAY_OF_MONTH, eventStartTimesD.get(i));
                        startTime.set(Calendar.HOUR_OF_DAY, eventStartTimesH.get(i));
                        startTime.set(Calendar.MINUTE, eventStartTimesM.get(i));
                        startTime.set(Calendar.MONTH, newMonth-1);
                        startTime.set(Calendar.YEAR, newYear);
                        Calendar endTime = (Calendar) startTime.clone();
                        endTime.set(Calendar.HOUR_OF_DAY, eventEndTimesH.get(i));
                        endTime.set(Calendar.MINUTE, eventEndTimesM.get(i));
                        WeekViewEvent event = new WeekViewEvent(i, eventNames.get(i), startTime, endTime);
                        event.setColor(eventColor);
                        events.add(event);
                    }

                }

                return events;
            }
        });


        final Context whatever = this;


        final Button ssButton= findViewById(R.id.screenshotAndSet);
        ssButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                ssButton.setVisibility(View.GONE);
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Bitmap ss = MainActivity.getScreenShot(rootView);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ss.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
                byte[] bitmapdata = bos.toByteArray();
                ByteArrayInputStream bs = new ByteArrayInputStream(bitmapdata);

                try {
                    WallpaperManager.getInstance(whatever).setStream(bs, null, true, WallpaperManager.FLAG_LOCK);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ssButton.setVisibility(View.VISIBLE);
            }
        });


    }
}
