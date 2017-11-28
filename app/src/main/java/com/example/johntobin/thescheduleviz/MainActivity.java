package com.example.johntobin.thescheduleviz;

import android.app.Activity;
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
import android.app.WallpaperManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//NOTE TO SELF : YOU SHOULD INCLUDE THE BUTTONS THAT YOU JUST ADDED ON THE ACTIVITY EVENT
//XML AND LOOK AT SANJEEV'S VID TO GUIDE - THEN LINK IT TO FIREBASE DATABASE


public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    Button goToCalendarTest;
    Button takeScreenshot;

    // Firebase

    //DatabaseReference = mRootRef = FirebaseDatabase.getInstance.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToCalendarTest = (Button) findViewById(R.id.goToCalendarTest);
        goToCalendarTest.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.goToCalendarTest) {
            Intent intentGoToCalendarPage = new Intent(this, CalendarTest.class);
            this.startActivity(intentGoToCalendarPage);


            //put an else if statement?
        }
       // --------------------


        takeScreenshot = (Button) findViewById(R.id.screenshotTest);
        takeScreenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Bitmap ss = getScreenShot(rootView);
                store(ss, "Testfile.png");
            }
        });
//-------------------------------------
       /* @Override
            protected void OnStart() {
            super.onStart();
            DatabaseReference conditionRef = mRootRef.child("condition");
        }*/
//------------------------------------
    }

    public static Bitmap getScreenShot(View view) {
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);

        return bitmap;

    }
//comment back in for screenshot stuff? lauren + jillian (look up on google)
   /* public void setBackground(Bitmap pictureIn) {
        //this is our attempt to transform bitmap into imput stream, struggling with how to fix errors
        int byteSize = bitmap.getAllocationByteCount() * bitmap.getHeight();
        ByteBuffer byteBuffer = ByteBuffer.allocate(byteSize);
        bitmap.copyPixelsToBuffer(byteBuffer);
        byte[] byteArray = byteBuffer.array();
        ByteArrayInputStream bs = new ByteArrayInputStream(byteArray);

        WallpaperManager.getInstance(this).setStream(pictureIn, null, true, WallpaperManager.FLAG_LOCK);

    }*/

    public void store(Bitmap bm, String fileName){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            final File dirPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
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
