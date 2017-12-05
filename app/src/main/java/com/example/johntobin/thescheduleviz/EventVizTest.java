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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;

@TargetApi(24)
public class EventVizTest extends Activity {

    private String[] day1summaries;
    private String[] day1times;
    private Integer[] day1durations;
    private String[] day2summaries;
    private String[] day2times;
    private Integer[] day2durations;
    private String[] day3summaries;
    private String[] day3times;
    private Integer[] day3durations;

    private SimpleDateFormat sdfone = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private SimpleDateFormat sdftwo = new SimpleDateFormat("HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_display);
        //LinearLayout ml = new LinearLayout(this); //master LinearLayout
        //ml.setOrientation(LinearLayout.VERTICAL);

        LinearLayout ll = (LinearLayout) findViewById(R.id.subLL);
        int llheight = ll.getMeasuredHeight();


        // Get variables passed in through intent.
        int daycount = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList<String> tl = extras.getStringArrayList("mondayEventSummaries");
            day1summaries = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            tl = extras.getStringArrayList("mondayEventTimes");
            day1times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day1times != null) ? 1 : 0;
            ArrayList<Integer> durations = extras.getIntegerArrayList("mondayEventDurations");
            day1durations = (durations != null) ? durations.toArray(new Integer[durations.size()]) : null;


            tl = extras.getStringArrayList("tuesdayEventSummaries");
            day2summaries = (tl != null) ? tl.toArray(new String[tl.size()]): null;
            tl = extras.getStringArrayList("tuesdayEventTimes");
            day2times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day2times != null) ? 1 : 0;
            durations = extras.getIntegerArrayList("tuesdayEventDurations");
            day2durations = (durations != null) ? durations.toArray(new Integer[durations.size()]) : null;

            tl = extras.getStringArrayList("day3times");
            day3summaries = (tl != null) ? tl.toArray(new String[tl.size()]): null;
            tl = extras.getStringArrayList("day3summaries");
            day3times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day3times != null) ? 1 : 0;
            durations = extras.getIntegerArrayList("wednesdayEventDurations");
            day3durations = (durations != null) ? durations.toArray(new Integer[durations.size()]) : null;
            //The key argument here must match that used in the other activity
        }

        String[][] allSummaries = {day1summaries, day2summaries, day3summaries};
        String[][] allTimes = {day1times, day2times, day3times};
        Integer[][] allDurations = {day1durations, day2durations, day3durations};

        Date midnight = new Date();
        try {
            midnight = sdftwo.parse("00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        float[][] allWeights = {new float[(day1summaries != null) ? day1summaries.length : 0], new float[(day2summaries != null) ? day2summaries.length : 0], new float[(day3summaries != null) ? day3summaries.length : 0]};

        int daysminutes = 24*60;

        for(int k = 0; k < allSummaries.length; ++k){
            int remaining = 100;
            for(int i = 0; i < ((allSummaries[k] != null) ? allSummaries[k].length : 0); ++i){
                Date datetosubtract = new Date();
                try {
                    datetosubtract = sdfone.parse(allTimes[k][i]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                float diff = (datetosubtract.getHours() - midnight.getHours())*60 + (datetosubtract.getMinutes() - midnight.getMinutes());
                float pct = (diff/daysminutes);
                allWeights[k][i] = pct;
            }
            if(allSummaries[k] != null){
                LinearLayout l1 = new LinearLayout(this);
                l1.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                lparams.weight = 50;
                l1.setLayoutParams(lparams);

                // Make constraint layout.
                ConstraintLayout c1 = new ConstraintLayout(this);
                ConstraintLayout.LayoutParams cparams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
                cparams.orientation = ConstraintLayout.LayoutParams.VERTICAL;
                c1.setLayoutParams(cparams);


                for(int i = 0; i < allSummaries[k].length; ++i){
                    Guideline topguide = new Guideline(this);
                    ConstraintLayout.LayoutParams gllptop = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    gllptop.guidePercent = allWeights[k][i];
                    gllptop.orientation = ConstraintLayout.LayoutParams.HORIZONTAL;
                    topguide.setLayoutParams(gllptop);
                    topguide.setId(View.generateViewId());
                    c1.addView(topguide);

                    float textheightpct = ((float) allDurations[k][i]) / daysminutes;
                    Guideline bottomguide = new Guideline(this);
                    ConstraintLayout.LayoutParams gllpbot = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    gllpbot.guidePercent = allWeights[k][i] + textheightpct;
                    gllpbot.orientation = ConstraintLayout.LayoutParams.HORIZONTAL;
                    bottomguide.setLayoutParams(gllpbot);
                    bottomguide.setId(View.generateViewId());
                    c1.addView(bottomguide);

                    TextView newEvent = new TextView(this);
                    newEvent.setText(allSummaries[k][i]);
                    if(i % 2 == 0){
                        newEvent.setBackgroundColor(Color.parseColor("#424bf4"));
                    }
                    else{
                        newEvent.setBackgroundColor(Color.parseColor("#f44141"));
                    }

                    ConstraintLayout.LayoutParams tparams = new ConstraintLayout.LayoutParams(600, 0);
                    tparams.topToBottom = topguide.getId();
                    //tparams.endToEnd = bottomguide.getId();
                    tparams.bottomMargin = (int) textheightpct;
                    //tparams.endToEnd = bottomguide.getId();
                    tparams.verticalWeight = 1;
                    newEvent.setLayoutParams(tparams);
                    c1.addView(newEvent);
                }
                l1.addView(c1);



                //TextView tevent = new TextView(this);
                //tevent.setText("This is test text.");
                //l1.addView(tevent);
                ll.addView(l1);

            }
        }

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

        //ml.addView(ll);
        //ml.addView(ssButton);
        //setContentView(ll);

    }
}
