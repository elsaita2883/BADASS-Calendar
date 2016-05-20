public class Main
{
    public static void main(String args[])throws Exception{
        DatabaseManager.saveReservations();
        Period pr = new Period(2016,5,18,3);
        Reservation resrv = new Reservation("Haga", "AP English IV");
        pr.addReservation(resrv);
        DatabaseManager.loadReservations();
        DatabaseManager.reservationmap.put(pr, resrv);
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
    }
}
