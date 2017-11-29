package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.os.Bundle;

import android.support.constraint.Guideline;
import android.support.v7.widget.LinearLayoutCompat;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.annotation.TargetApi;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

@TargetApi(20)
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
        //ll.setLayoutParams(layoutParams);


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

        float[][] allWeights = {new float[(day1summaries != null) ? day1summaries.length : 0], new float[(day2summaries != null) ? day2summaries.length : 0], new float[(day3summaries != null) ? day3summaries.length : 0]};
        float daysminutes = 24*60;

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
                    Guideline guide = new Guideline(this);
                    ConstraintLayout.LayoutParams gllp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT);
                    gllp.guidePercent = allWeights[k][i];
                    gllp.orientation = ConstraintLayout.LayoutParams.HORIZONTAL;
                    guide.setLayoutParams(gllp);
                    guide.setId(View.generateViewId());
                    c1.addView(guide);


                    TextView newEvent = new TextView(this);
                    newEvent.setText(allSummaries[k][i]);
                    ConstraintLayout.LayoutParams tparams = new ConstraintLayout.LayoutParams(300, 300);
                    tparams.topToBottom = guide.getId();
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

        setContentView(ll);

    }
}
