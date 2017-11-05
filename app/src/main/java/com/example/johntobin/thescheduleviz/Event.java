package com.example.johntobin.thescheduleviz;

/**
 * Created by johntobin on 11/2/17.
 */

import java.sql.Time;

public class Event {

    private String EventName;
    private String Location;

    private Time startTime;
    private Time endTime;

    private boolean[] reoccuringOn;


    // Constructor with no arguments. Use when you want to initialize a blank event.
    public Event(){
        this.reoccuringOn = new boolean[]{false, false, false, false, false, false, false};
    }

    public Event(String EventNameIn, String LocationIn){
        this.reoccuringOn = new boolean[]{false, false, false, false, false, false, false};

        if(EventNameIn.length() <= 30){
            this.EventName = EventNameIn;
        }
        else{
            // Cut off any extra characters.
            // This may need to be change but it should be fine for now.
            this.EventName = EventNameIn.substring(0, 30);
        }
        if(LocationIn.length() <= 30){
            this.Location = LocationIn;
        }
        else{
            // Cut off any extra characters.
            // This may need to be change but it should be fine for now.
            this.Location = LocationIn.substring(0, 30);
        }

    }

    public Event(String EventNameIn, String LocationIn, Time StartTimeIn, Time EndTimeIn){
        this.reoccuringOn = new boolean[]{false, false, false, false, false, false, false};

        if(EventNameIn.length() <= 30){
            this.EventName = EventNameIn;
        }
        else{
            // Cut off any extra characters.
            // This may need to be change but it should be fine for now.
            this.EventName = EventNameIn.substring(0, 30);
        }
        if(LocationIn.length() <= 30){
            this.Location = LocationIn;
        }
        else{
            // Cut off any extra characters.
            // This may need to be change but it should be fine for now.
            this.Location = LocationIn.substring(0, 30);
        }

        if(StartTimeIn.before(EndTimeIn)){
            this.startTime = StartTimeIn;
            this.endTime = EndTimeIn;
        }
        else{
            throw new java.lang.RuntimeException("The event's start time must come before the event's end time.");
        }

    }

    public boolean validate(){
        boolean returnVal = true;
        if(!this.startTime.before(this.endTime)){
            returnVal = false;
        }

        if(this.EventName.length() > 30){
            returnVal = false;
        }

        if(this.Location.length() > 30){
            returnVal = false;
        }

        if(this.reoccuringOn.length != 7){
            returnVal = false;
        }

        return returnVal;
    }

    public void setReoccurance(String dateIn, boolean setVal){
        if(dateIn.equals("Sunday") || dateIn.equals("sunday") || dateIn.equals("Sun")){
            this.reoccuringOn[0] = setVal;
        }
        if(dateIn.equals("Monday") || dateIn.equals("monday") || dateIn.equals("Mon")){
            this.reoccuringOn[1] = setVal;
        }
        if(dateIn.equals("Tuesday") || dateIn.equals("tuesday") || dateIn.equals("Tue")){
            this.reoccuringOn[2] = setVal;
        }
        if(dateIn.equals("Wednesday") || dateIn.equals("wednesday") || dateIn.equals("Wed")){
            this.reoccuringOn[3] = setVal;
        }
        if(dateIn.equals("Thursday") || dateIn.equals("thursday") || dateIn.equals("Thu")){
            this.reoccuringOn[4] = setVal;
        }
        if(dateIn.equals("Friday") || dateIn.equals("friday") || dateIn.equals("Fri")){
            this.reoccuringOn[5] = setVal;
        }
        if(dateIn.equals("Saturday") || dateIn.equals("saturday") || dateIn.equals("Sat")){
            this.reoccuringOn[6] = setVal;
        }
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        if(location.length() <= 30){
            Location = location;
        }
        else{
            Location = location.substring(0, 30);
        }

    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        if(eventName.length() <= 30){
            EventName = eventName;
        }
        else{
            EventName = eventName.substring(0, 30);
        }
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }


    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
