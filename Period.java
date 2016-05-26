package badass.calendar;

import java.io.Serializable;
import java.util.Arrays;
/**
 * Represents a school period.
 * 
 * @author Elsa Itambo, Jason Paximadas 
 * @version (a version number or a date)
 */
public class Period implements Serializable
{
    // instance variables - replace the example below with your own
    private int period;
    private final int year;
    private final int month;
    private final int day;
    
    /**
     * Creates a new Period object
     * @param date String date in the form of month/day/year
     * @param myPeriod an integer ranging from 1-9 (inclusive)
     */
    public Period(String date, int myPeriod){
        String[] nums = date.split("/");
        month = Integer.parseInt(nums[0]);
        day = Integer.parseInt(nums[1]);
        year = Integer.parseInt(nums[2]);
    }
    
    /**
     * Checks if the Period is reserved
     * @return true if reserved, false if not
     */
    public boolean hasReservation(){
        return DatabaseManager.reservationmap.containsKey(this);
    }
    
    /**
     * Puts Period into reservationmap with Period as key and Reservation r as the attached object
     * @param r Reservation to be attached with Period
     */
    public void addReservation(Reservation r){
        if(!hasReservation()){
            DatabaseManager.reservationmap.put(this, r);
        }
    }
    
    /**
     * Deletes Period and Reservation from reservationmap
     */
    public void removeReservation(){
        System.out.println(this);
        DatabaseManager.reservationmap.remove(this);
        System.out.println(hasReservation());
    }
    /**
     * Returns the period
     * @return int period
     */
    public int getPeriod(){
        return this.period;
    }
    
    /**
     * Returns the day of the month
     * @return int day
     */
    public int getDay(){
        return this.day;
    }
    
    /**
     * Returns the month
     * @return int month
     */
    public int getMonth(){
        return this.month;
    }
    
    /**
     * Returns the year
     * @return int year
     */
    public int getYear(){
        return this.year;
    }
    
    @Override
    public String toString(){
        return month + "/" + day + "/" + year + "-" + "Period " + period;
    }
    
    @Override
    public int hashCode(){
        String prehash = ""+ period + day + month + year;
        return Integer.parseInt(prehash);
    }
    
    /**
     * Checks if the two Periods are equal
     * @param period2 the Period to compare
     * @return true if equal, false if not
     */
    public boolean equals(Period period2){
        boolean periodcheck = (this.period == period2.getPeriod());
        
        boolean daycheck = (this.day == period2.getDay());
        
        boolean monthcheck = (this.month == period2.getMonth());

        boolean yearcheck = (this.year == period2.getYear());
        
        return periodcheck && daycheck && monthcheck && yearcheck;
    }
}
