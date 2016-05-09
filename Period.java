import java.io.Serializable;
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
    public Period(int myYear, int myMonth, int myDay, int myPeriod)throws PeriodException
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
        if(myPeriod<9 && myPeriod >0)
            period=myPeriod;
        else
            throw new IllegalPeriodException("That period number does no exist");
    }
    public int getPeriod(){
        return period;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return month + "/" + day + "/" + year + "-" + "Period " + period;
    }
    public int hashCode(){
        String prehash = ""+ period + day + month + year;
        return Integer.parseInt(prehash);
    }
    public boolean equals(Period period2){
        boolean check = (this.period == period2.period) &&
                        (this.day == period2.day) &&
                        (this.month == period2.month) &&
                        (this.year == period2.year);
        return check;
    }
}