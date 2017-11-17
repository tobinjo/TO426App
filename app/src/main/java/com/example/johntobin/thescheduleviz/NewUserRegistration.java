package com.example.johntobin.thescheduleviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class NewUserRegistration extends AppCompatActivity {

    Button buttonConfirmNewUser;
    Button buttonGoBackToLogin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_registration);

        buttonConfirmNewUser = (Button) findViewById(R.id.buttonConfirmNewUser);
        buttonGoBackToLogin = (Button) findViewById(R.id.buttonGoBackToLogin);


    }
}
