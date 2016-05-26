package badass.calendar;


import java.io.*;
/**
 * Write a description of class DatabaseManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatabaseManager
{
    private static final File file = new File("map.ser");
    public static ReservationMap reservationmap = new ReservationMap();
    /**
     * Loads reservations from "map.ser"
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void loadReservations()throws IOException,ClassNotFoundException{
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        reservationmap = (ReservationMap) ois.readObject();
        ois.close();
        fin.close();
    }
    
    /**
     * Saves reservations to "map.ser"
     * @throws IOException 
     */
    public static void saveReservations()throws IOException{ 
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(reservationmap);
        oos.close();
        fout.close();
    }
}
