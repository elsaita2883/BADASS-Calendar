import java.util.HashMap;
import java.io.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester
{
    public static void main(String args[])throws Exception{
        Period pr = new Period(2016,5,9,3);
        if(args[0]=="save"){
            Reservation rs = new Reservation("Byron Webb", "AP Computer Science");
            
            HashMap<Period,Reservation> map= new HashMap<Period,Reservation>();
            map.put(pr,rs);
        
            File fl = new File("mapstorage.ser");
            fl.createNewFile();
            
            boolean get = map.containsKey(pr); //get the data corresponding to the key
            System.out.println(get);
            
            System.out.println(map);
            
            DatabaseManager.saveReservations(fl,map);
        
        }else if(args[0]=="load"){
            File fl = new File("mapstorage.ser");
            HashMap<Period,Reservation> map2= DatabaseManager.loadReservations(fl);
            boolean get = map2.containsKey(pr);
            System.out.println(map2//get the data corresponding to the key
            System.out.println(get);
            System.out.println(map2);
        }
    }
}
