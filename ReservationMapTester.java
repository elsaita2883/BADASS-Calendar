 

import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ReservationMapTester
{
    public static void main(String args[])throws Exception{
        Period pr = new Period(2016,5,9,3);
        Scanner in = new Scanner(System.in);
        System.out.println("Command: ");
        String command = in.next().trim();
        
        switch (command) {
            case "save":
                {
                    Reservation rs = new Reservation("Byron Webb", "AP Computer Science");
                    ReservationMap map = new ReservationMap();
                    map.put(pr,rs);
                    File fl = new File("mapstorage.ser");
                    fl.createNewFile();
                    boolean get = map.containsKey(pr); //get the data corresponding to the key
                    System.out.println(get);
                    System.out.println(map);
                    DatabaseManager.saveReservations(fl,map);
                    break;
                }
            case "load":
                {
                    File fl = new File("mapstorage.ser");
                    ReservationMap map2 = (ReservationMap) DatabaseManager.loadReservations(fl);
                    //HashMap<Period,Reservation> map2= DatabaseManager.loadReservations(fl);
                    boolean get = map2.containsKey(pr);
                    //get the data corresponding to the key
                    System.out.println(get);
                    System.out.println(map2);
                    break;
                }
        }
    }
}
