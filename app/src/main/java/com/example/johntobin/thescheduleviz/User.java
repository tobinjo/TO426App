package com.example.johntobin.thescheduleviz;

/**
 * Created by johntobin on 11/2/17.
 */

import android.graphics.Color;

public class User {


    private String username;
    private String firstname;
    private String lastname;
    // Password storage should be taken care of by firebase.


    private double NumDaysToDisplay;
    private Color primaryColor;
    private Color secondaryColor;

    private Week week;

    User(String usernameIn, String firstnameIn, String lastnameIn){
        this.username = usernameIn;
        this.firstname = firstnameIn;
        this.lastname = lastnameIn;

        this.NumDaysToDisplay = 3;
        this.week = new Week();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getNumDaysToDisplay() {
        return NumDaysToDisplay;
    }

    public void setNumDaysToDisplay(double numDaysToDisplay) {
        NumDaysToDisplay = numDaysToDisplay;
    }

}
