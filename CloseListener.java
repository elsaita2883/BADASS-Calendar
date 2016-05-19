import java.awt.event.*;
import java.io.*;
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
        try{
            DatabaseManager.saveReservations(new File("map.ser"));
        }catch(Exception ex){
            System.out.println("no file");
        }
        System.exit(0);
    }
    
    public void windowActivated(java.awt.event.WindowEvent e){
    }
    
    public void windowDeiconified(java.awt.event.WindowEvent e){
    }
    
    public void windowIconified(java.awt.event.WindowEvent e){
    }
    
    public void windowClosed(java.awt.event.WindowEvent e){
    }
    
    public void windowClosing(java.awt.event.WindowEvent e){
    }
    
    public void windowOpened(java.awt.event.WindowEvent e){
    }
    
    
}
