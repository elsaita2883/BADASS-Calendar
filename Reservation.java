package badass.calendar;

import java.io.Serializable;
/**
 * Write a description of class Reservation here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reservation implements Serializable
{
    private String teacherName;
    private String className;
    
    /**
     * Constructor for objects of class Reservation
     */
    public Reservation(String myTeacher, String myClass)
    {
        teacherName=myTeacher;
        className=myClass;
    }
    
    public String getTeacher(){
        return teacherName;
    }
    
    public String myClass(){
        return className;
    }
    public String toString(){
        return teacherName + " - " + className;
    }
}
