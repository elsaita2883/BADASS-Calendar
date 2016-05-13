
/**
 * Write a description of class Day here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Day
{
    // instance variables - replace the example below with your own
    private int day;
    private int month;
    private int year;

    /**
     * Constructor for objects of class Day
     */
    public Day(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getDay()
    {
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return month + "/" + day + "/" + year;
    }
}
