import java.awt.event.*;
/**
 * Write a description of class WindowListener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloseListener implements WindowListener
{
    
    /**
     * Constructor for objects of class WindowListener
     */
    public CloseListener()
    {
       
    }

    public void windowDeactivated(java.awt.event.WindowEvent e){
        DatabaseManager.saveReservation(new File("map.ser"));
        System.exit(0);
    }
}
