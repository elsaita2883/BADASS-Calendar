package badass.calendar;

import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Monitors the closing of a window to save account and reservation data.
 * 
 * @author Elsa Itambo
 */
public class CloseListener implements WindowListener
{
    @Override
    public void windowDeactivated(java.awt.event.WindowEvent e){
    }

    @Override
    public void windowOpened(WindowEvent we) {
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
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }
}
