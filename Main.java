 

import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[])throws Exception{
        File fl = new File("map.ser"); 
        try{
            DatabaseManager.loadReservations(fl);
        }catch(IOException ex){
            ReservationMap map = new ReservationMap();
            DatabaseManager.reservationmap = map;
            DatabaseManager.saveReservations(fl);
        }
    }
}
