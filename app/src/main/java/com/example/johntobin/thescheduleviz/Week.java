package com.example.johntobin.thescheduleviz;

/**
 * Created by johntobin on 11/2/17.
 */

public class Week {
    private Day Sunday;
    private boolean SundayDisp;

    private Day Monday;
    private boolean MondayDisp;

    private Day Tuesday;
    private boolean TuesdayDisp;

    private Day Wednesday;
    private boolean WednesdayDisp;

    private Day Thursday;
    private boolean ThursdayDisp;

    private Day Friday;
    private boolean FridayDisp;

    private Day Saturday;
    private boolean SaturdayDisp;

    public void SetDayByName(String dayIn, Day dayObjIn){
        if(dayIn.equals("Sunday") || dayIn.equals("sunday") || dayIn.equals("Sun")){
            this.Sunday = dayObjIn;
        }
        if(dayIn.equals("Monday") || dayIn.equals("monday") || dayIn.equals("Mon")){
            this.Monday = dayObjIn;
        }
        if(dayIn.equals("Tuesday") || dayIn.equals("tuesday") || dayIn.equals("Tue")){
            this.Tuesday = dayObjIn;
        }
        if(dayIn.equals("Wednesday") || dayIn.equals("wednesday") || dayIn.equals("Wed")){
            this.Wednesday = dayObjIn;
        }
        if(dayIn.equals("Thursday") || dayIn.equals("thursday") || dayIn.equals("Thu")){
            this.Thursday = dayObjIn;
        }
        if(dayIn.equals("Friday") || dayIn.equals("friday") || dayIn.equals("Fri")){
            this.Friday = dayObjIn;
        }
        if(dayIn.equals("Saturday") || dayIn.equals("saturday") || dayIn.equals("Sat")){
            this.Saturday = dayObjIn;
        }
    }

    public void SetDispByName(String dayIn, boolean dispVal){
        if(dayIn.equals("Sunday") || dayIn.equals("sunday") || dayIn.equals("Sun")){
            this.SundayDisp = dispVal;
        }
        if(dayIn.equals("Monday") || dayIn.equals("monday") || dayIn.equals("Mon")){
            this.MondayDisp = dispVal;
        }
        if(dayIn.equals("Tuesday") || dayIn.equals("tuesday") || dayIn.equals("Tue")){
            this.TuesdayDisp = dispVal;
        }
        if(dayIn.equals("Wednesday") || dayIn.equals("wednesday") || dayIn.equals("Wed")){
            this.WednesdayDisp = dispVal;
        }
        if(dayIn.equals("Thursday") || dayIn.equals("thursday") || dayIn.equals("Thu")){
            this.ThursdayDisp = dispVal;
        }
        if(dayIn.equals("Friday") || dayIn.equals("friday") || dayIn.equals("Fri")){
            this.FridayDisp = dispVal;
        }
        if(dayIn.equals("Saturday") || dayIn.equals("saturday") || dayIn.equals("Sat")){
            this.SaturdayDisp = dispVal;
        }
    }

    public Day GetDayByName(String dayIn){
        if(dayIn.equals("Sunday") || dayIn.equals("sunday") || dayIn.equals("Sun")){
            return this.Sunday;
        }
        if(dayIn.equals("Monday") || dayIn.equals("monday") || dayIn.equals("Mon")){
            return this.Monday;
        }
        if(dayIn.equals("Tuesday") || dayIn.equals("tuesday") || dayIn.equals("Tue")){
            return this.Tuesday;
        }
        if(dayIn.equals("Wednesday") || dayIn.equals("wednesday") || dayIn.equals("Wed")){
            return this.Wednesday;
        }
        if(dayIn.equals("Thursday") || dayIn.equals("thursday") || dayIn.equals("Thu")){
            return this.Thursday;
        }
        if(dayIn.equals("Friday") || dayIn.equals("friday") || dayIn.equals("Fri")){
            return this.Friday;
        }
        if(dayIn.equals("Saturday") || dayIn.equals("saturday") || dayIn.equals("Sat")){
            return this.Saturday;
        }

        throw new java.lang.RuntimeException("Choose a valid day of the week.");
    }

    public boolean GetDispByName(String dayIn){
        if(dayIn.equals("Sunday") || dayIn.equals("sunday") || dayIn.equals("Sun")){
            return this.SundayDisp;
        }
        if(dayIn.equals("Monday") || dayIn.equals("monday") || dayIn.equals("Mon")){
            return this.MondayDisp;
        }
        if(dayIn.equals("Tuesday") || dayIn.equals("tuesday") || dayIn.equals("Tue")){
            return this.TuesdayDisp;
        }
        if(dayIn.equals("Wednesday") || dayIn.equals("wednesday") || dayIn.equals("Wed")){
            return this.WednesdayDisp;
        }
        if(dayIn.equals("Thursday") || dayIn.equals("thursday") || dayIn.equals("Thu")){
            return this.ThursdayDisp;
        }
        if(dayIn.equals("Friday") || dayIn.equals("friday") || dayIn.equals("Fri")){
            return this.FridayDisp;
        }
        if(dayIn.equals("Saturday") || dayIn.equals("saturday") || dayIn.equals("Sat")){
            return this.SaturdayDisp;
        }

        throw new java.lang.RuntimeException("Choose a valid day of the week.");
    }

}
