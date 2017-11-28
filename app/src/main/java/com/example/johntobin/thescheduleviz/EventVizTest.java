package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class EventVizTest extends Activity {

    private String[] day1summaries;
    private String[] day1times;
    private String[] day2summaries;
    private String[] day2times;
    private String[] day3summaries;
    private String[] day3times;

    private SimpleDateFormat sdfone = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private SimpleDateFormat sdftwo = new SimpleDateFormat("HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout ll = new LinearLayout(this); //root LinearLayout
        ll.setOrientation(LinearLayout.HORIZONTAL);//with horizontal orientation
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,1f);

        LinearLayout l3 = new LinearLayout(this); //sub linearlayout
        l3.setWeightSum(100f);
        l3.setOrientation(LinearLayout.VERTICAL); //with vertical orientation
        l3.setLayoutParams(layoutParams);


        // Get variables passed in through intent.
        int daycount = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ArrayList<String> tl = extras.getStringArrayList("mondayEventSummaries");
            day1summaries = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            tl = extras.getStringArrayList("mondayEventTimes");
            day1times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day1times != null) ? 1 : 0;

            tl = extras.getStringArrayList("tuesdayEventSummaries");
            day2summaries = (tl != null) ? tl.toArray(new String[tl.size()]): null;
            tl = extras.getStringArrayList("tuesdayEventTimes");
            day2times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day2times != null) ? 1 : 0;

            tl = extras.getStringArrayList("day3times");
            day3summaries = (tl != null) ? tl.toArray(new String[tl.size()]): null;
            tl = extras.getStringArrayList("day3summaries");
            day3times = (tl != null) ? tl.toArray(new String[tl.size()]) : null;
            daycount += (day3times != null) ? 1 : 0;
            //The key argument here must match that used in the other activity
        }

        String[][] allSummaries = {day1summaries, day2summaries, day3summaries};
        String[][] allTimes = {day1times, day2times, day3times};

        Date midnight = new Date();
        try {
            midnight = sdftwo.parse("00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int[][] allWeights = {new int[(day1summaries != null) ? day1summaries.length+1 : 0], new int[(day2summaries != null) ? day2summaries.length+1 : 0], new int[(day3summaries != null) ? day3summaries.length+1 : 0]};
        long daysminutes = 24*60;

        for(int k = 0; k < allSummaries.length; ++k){
            int remaining = 100;
            for(int i = 0; i < ((allSummaries[k] != null) ? allSummaries[k].length : 0); ++i){
                Date datetosubtract = new Date();
                try {
                    datetosubtract = sdfone.parse(allTimes[k][i]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = (datetosubtract.getHours() - midnight.getHours())*60 + (datetosubtract.getMinutes() - midnight.getMinutes());
                if(i == 0){
                    int pct = (int) (diff/daysminutes)*100;
                    allWeights[k][0] = pct;
                    remaining -= allWeights[k][0];
                }
                else{
                    int pct = (int) (diff/daysminutes)*100;
                    allWeights[k][i] = (int) pct - allWeights[k][i-1];
                    remaining -=  allWeights[k][i];
                    if(i == allSummaries[k].length){
                        allWeights[k][i+1] = remaining;
                    }
                }
            }
            if(allSummaries[k] != null){
                LinearLayout l2 = new LinearLayout(this); //sub linearlayout
                l2.setWeightSum(100f);
                l2.setOrientation(LinearLayout.VERTICAL); //with vertical orientation
                l2.setLayoutParams(layoutParams);

                TextView blankEvent = new TextView(this);
                blankEvent.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, allWeights[k][0]));
                l2.addView(blankEvent);
                for(int i = 1; i < allSummaries[k].length+1; ++i){
                    TextView newEvent = new TextView(this);
                    newEvent.setText(allSummaries[k][i-1]);
                    newEvent.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, allWeights[k][i]));
                    l2.addView(newEvent);
                }
                ll.addView(l2);
            }
        }

        setContentView(ll);

    }
}
