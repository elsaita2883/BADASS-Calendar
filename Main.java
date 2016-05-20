package badass.calendar; 
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[])throws Exception{
        DatabaseManager.loadReservations();
        for(Object key : DatabaseManager.reservationmap.keySet()){
            System.out.println(DatabaseManager.reservationmap.get(key));
        }
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
        Week week = new Week();
    }
}
