package badass.calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Owner
 */
public class Week {
    private final GregorianCalendar[] days;
    /**
     * Creates a new Week object initialized to the current week
     */
    public Week(){
        this.days  = new GregorianCalendar[5];
        GregorianCalendar init = new GregorianCalendar();
        //roll back to monday
        while(init.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY){
            init.add(Calendar.DAY_OF_MONTH,-1);
        }
        //fill the array with consecutive days
        for(int i = 0;i < days.length;i++){
            days[i]=(GregorianCalendar)init.clone();
            init.add(Calendar.DAY_OF_MONTH,1);
        }
    }
    
    /**
     * Sets Week object to next Week
     */
    public void nextWeek(){
        GregorianCalendar init;
        for(int i = 0;i < days.length;i++){
            init = (GregorianCalendar) days[i];
            init.add(Calendar.DAY_OF_MONTH, 7);
            days[i] = init;
        }
    }
    
    /**
     * Sets Week object to previous Week
     */
    public void previousWeek(){
        GregorianCalendar init;
        for(int i = 0;i < days.length;i++){
            init = (GregorianCalendar) days[i];
            init.add(Calendar.DAY_OF_MONTH, -7);
            days[i] = init;
        }
    }
    
    /**
     * Gets the first day of the week
     * @return String date (MM/dd/YY) for example: 2/15/2003
     */
    public String getStartDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        String str = sdf.format(days[0].getTime());
        return str;
    }
    
    /**
     * Gets the last day of the week
     * @return String date (MM/dd/YYYY) for example: 7/24/1990
     */
    public String getEndDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        String str = sdf.format(days[4].getTime());
        return str;
    }
    
    /**
     * Returns all periods within the Week
     * @return Period[][] periods
     */
    public Period[][] getPeriods() {
        Period[][] week = new Period[5][8];
        for(int d = 0; d < days.length; d++){
            for(int p = 0;p < 8;p++){
                int period = p+1;
                //Make a period
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
                String str = sdf.format(days[d].getTime());
                Period pr = new Period(str, period);
                //Check if period is in reservationmap
                if(DatabaseManager.reservationmap.containsKey(pr)){
                    //If so, get associated Reservation and add it
                    pr.addReservation(DatabaseManager.reservationmap.get(pr));
                }
                week[d][p] = pr;
            }
        }
        return week;
    }
    
    /**
     * Gets the name of a day in relation the the week
     * @param index index of day in week with 0=Sunday
     * @return String name of day
     */
    public String getDayName(int index){
        switch(index){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday"; 
            case 5:
                return "Friday";
                
        }
        return "";
    }
}
