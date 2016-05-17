import java.util.HashMap;

import java.io.*;
/**
 * Write a description of class DatabaseManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DatabaseManager
{
    public static HashMap<Period,Reservation> reservationmap;
    public static void loadReservations(File target)throws IOException,ClassNotFoundException{
        FileInputStream fin = new FileInputStream(target);
        ObjectInputStream ois = new ObjectInputStream(fin);
        HashMap<Period,Reservation> map = (HashMap<Period,Reservation>) ois.readObject();
        ois.close();
        fin.close();
        reservationmap = map;
    }
    public static void saveReservations(File target)throws IOException{ 
        FileOutputStream fout = new FileOutputStream(target);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(reservationmap);
        oos.close();
        fout.close();
    }
}
