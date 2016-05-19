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
    public static void loadReservations()throws IOException,ClassNotFoundException{
        FileInputStream fin = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fin);
        ReservationMap map = (ReservationMap) ois.readObject();
        ois.close();
        fin.close();
        reservationmap = map;
    }
    public static void addReservations(Period[][] periods){
        for(Period[] period : periods) {
           for (Period pr : period){
               if(pr.hasReservation()){
                   reservationmap.put(pr, pr.getReservation());
               }
           }
        }
    }
    public static void saveReservations()throws IOException{ 
        FileOutputStream fout = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(reservationmap);
        oos.close();
        fout.close();
    }
}
