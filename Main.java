  
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    static StartingJDialog dialog;
    public static void main(String args[])throws Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartingJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog = new StartingJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    /**
     * Creates and opens Calendar
     * @param firstName a first name
     * @param lastName a last name
     * @param password a password
     */
    public static void loadCalendar(String firstName, String lastName, String password){
        try{
            DatabaseManager.loadReservations();
            Account.loadAccounts();
        }catch(IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Problem writing to directory");
            System.exit(0);
        }
        for(Object key : DatabaseManager.reservationmap.keySet()){
            System.out.println(DatabaseManager.reservationmap.get(key));
        }
        try{
            Account.newAccount(firstName, lastName, password);
        
            if(Account.validate(lastName, password)){
            }else{
                dialog.setVisible(false);
                main(new String[0]);
                return;
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Problem processing data");
            System.exit(0);
        }
        
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Windows".equals(info.getName())) {                                        
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
        frame.setFocusable(true);
        Week week = new Week();
    }
}
