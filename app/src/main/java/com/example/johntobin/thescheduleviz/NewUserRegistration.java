package com.example.johntobin.thescheduleviz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NewUserRegistration extends AppCompatActivity {

    Button buttonConfirmNewUser;
    Button buttonGoBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_registration);

        buttonConfirmNewUser = (Button) findViewById(R.id.buttonConfirmNewUser);
        buttonGoBackToLogin = (Button) findViewById(R.id.buttonGoBackToLogin);
    }

        public void onClick(View view) {
            if (view.getId() == R.id.buttonGoBackToLogin){
                Intent intentOne = new Intent(this, LoginActivity.class);
                this.startActivity(intentOne);
                //put an else if statement here to describe what happens when the button is confirm new user
            }
    }





}


//the below code is taken from the "multipageapp" homework so that you can figure out how to
// get from page to page
/*
public class MainActivity extends Activity implements Button.OnClickListener {
    private Button buttonGoToTwo;
    private Button buttoncheckingthis;

        buttoncheckingthis = (Button) findViewById(R.id.buttoncheckingthis);
        buttoncheckingthis.setOnClickListener(this);


    }
    //start menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mainmenuInflater = getMenuInflater();
        mainmenuInflater.inflate(R.menu.mainmenu, menu);


        return super.onCreateOptionsMenu(menu);
    }



    @Override
    //go to activity two
    public void onClick(View view) {
        if (view.getId() == R.id.buttonGoToTwo) {
            Intent intentTwo = new Intent(this, ActivityTwo.class);
            this.startActivity(intentTwo);
            //go to CheckingThis Activity
        }else if (view.getId() == R.id.buttoncheckingthis) {
            Intent intentThree = new Intent(this, CheckingThis.class);
            this.startActivity(intentThree);
        }
    }
*/
