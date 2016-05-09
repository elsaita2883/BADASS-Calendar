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
    public static HashMap<Period,Reservation> loadReservations(File target)throws IOException,ClassNotFoundException{
        FileInputStream fin = new FileInputStream(target);
        ObjectInputStream ois = new ObjectInputStream(fin);
        HashMap<Period,Reservation> map = (HashMap<Period,Reservation>) ois.readObject();
        ois.close();
        fin.close();
        return map;
    }
    public static void saveReservations(File target, HashMap<Period,Reservation> map)throws IOException{ 
        FileOutputStream fout = new FileOutputStream(target);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(map);
        oos.close();
        fout.close();
    }
    private static boolean validate(HashMap<Period,Reservation> map){
        
        return true;
    }
}
