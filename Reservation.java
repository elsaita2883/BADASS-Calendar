 

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
     * Creates a new Reservation object
     * @param myTeacher Teacher's last name
     * @param myClass name of the class
     */
    public Reservation(String myTeacher, String myClass)
    {
        teacherName=myTeacher;
        className=myClass;
    }
    
    /**
     * Returns the name of the teacher to whom the Reservation belongs
     * @return teacherName
     */
    public String getTeacher(){
        return teacherName;
    }
    
    /**
     * Returns the name of the class
     * @return className
     */
    public String myClass(){
        return className;
    }
    
    @Override
    public String toString(){
        return teacherName + " - " + className;
    }
}
