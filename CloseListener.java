package badass.calendar;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        return;
    }

    @Override
    public void windowOpened(WindowEvent we) {
        return;
    }

    @Override
    public void windowClosing(WindowEvent we) {
        try {
            DatabaseManager.saveReservations();
            System.out.println("Reservations Saved");
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(CloseListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
        return;
    }

    @Override
    public void windowIconified(WindowEvent we) {
        return;
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        return;
    }

    @Override
    public void windowActivated(WindowEvent we) {
        return;
    }
}
