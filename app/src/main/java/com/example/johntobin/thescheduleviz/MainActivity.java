package com.example.johntobin.thescheduleviz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Bitmap;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import android.net.Uri;
import android.widget.Toast;
import android.content.ActivityNotFoundException;


public class MainActivity extends AppCompatActivity {

    Button goToCalendarTest;
    Button takeScreenshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToCalendarTest = (Button) findViewById(R.id.goToCalendarTest);
        goToCalendarTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CalendarTest.class);
                startActivity(i);
                finish();
            }
        });

        takeScreenshot = (Button) findViewById(R.id.screenshotTest);
        takeScreenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Bitmap ss = getScreenShot(rootView);
                store(ss, "Testfile");
            }
        });

    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void store(Bitmap bm, String fileName){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
            File dir = new File(dirPath);
            if(!dir.exists())
                dir.mkdirs();
            File file = new File(dirPath, fileName);
            try {
                FileOutputStream fOut = new FileOutputStream(file);
                bm.compress(Bitmap.CompressFormat.PNG, 85, fOut);
                fOut.flush();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), Environment.getExternalStorageState(), Toast.LENGTH_SHORT).show();
        }


    }

    private void shareImage(File file){
        Uri uri = Uri.fromFile(file);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");

        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        try {
            startActivity(Intent.createChooser(intent, "Share Screenshot"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this.getApplicationContext(), "No App Available", Toast.LENGTH_SHORT).show();
        }
    }
}
