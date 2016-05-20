package badass.calendar;

import java.io.Serializable;
import java.util.Arrays;
/**
 * Write a description of class Period here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Period implements Serializable
{
    // instance variables - replace the example below with your own
    private int period;
    private int year;
    private int month;
    private int day;
    /**
     * Constructor for objects of class Period
     */
    public Period(int myYear, int myMonth, int myDay, int myPeriod)
    {
        /*
        Date today = new Date();
        if(myDate.compareTo(today) >= 0)
            day=myDate;
        else
            throw new PastDateException("You cannot create reservations before today.");
        */
        year = myYear;
        month = myMonth;
        day = myDay;
        period = myPeriod;
        
    }
    public Period(String date, int myPeriod){
        String[] nums = date.split("/");
        month = Integer.parseInt(nums[0]);
        day = Integer.parseInt(nums[1]);
        year = Integer.parseInt(nums[2]);
    }
    public boolean hasReservation(){
        return DatabaseManager.reservationmap.containsKey(this);
    }
    public void addReservation(Reservation r){
        if(!DatabaseManager.reservationmap.containsKey(this)){
            DatabaseManager.reservationmap.put(this, r);
        }
    }
    public void removeReservation(){
        System.out.println(this);
        DatabaseManager.reservationmap.remove(this);
        System.out.println(hasReservation());
    }
    public int getPeriod(){
        return this.period;
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public String toString(){
        return month + "/" + day + "/" + year + "-" + "Period " + period;
    }
    public int hashCode(){
        String prehash = ""+ period + day + month + year;
        return Integer.parseInt(prehash);
    }
    public boolean equals(Period period2){
        boolean periodcheck = (this.period == period2.getPeriod());
        
        boolean daycheck = (this.day == period2.getDay());
        
        boolean monthcheck = (this.month == period2.getMonth());

        boolean yearcheck = (this.year == period2.getYear());
        
        return periodcheck && daycheck && monthcheck && yearcheck;
    }
}