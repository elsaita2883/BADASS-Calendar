 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.util.ArrayList;

/**
 * @author Zeel Parikh
 * Creates the frame for the main display of the calender
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {        
        //Gets a period array for the current week
        pr = week.getPeriods();
        initComponents();
        
        //Creates Buttons in each of the columns
        for (int i = 1; i < 6; i++){
            jTable1.getColumn(week.getDayName(i)).setCellRenderer(new ButtonRenderer());
            ButtonEditor cur = new ButtonEditor(new JCheckBox(),pr);
            jTable1.getColumn(week.getDayName(i)).setCellEditor(cur);
        }
        jTable1.getColumn("Period").setWidth(5);
        jTable1.repaint();
        loadLabels();
        
        
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        final int x = (screenSize.width - this.getWidth()) / 2;
        final int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

    }
    /**
     * Sets the initial components of the Frame including the background panel, the titles, 
     * the table/calendar, the next, and previous week buttons 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        weekLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        previousWeekButton = new javax.swing.JButton();
        nextWeekButton = new javax.swing.JButton();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new CloseListener());
        setBackground(new java.awt.Color(0, 102, 0));
        setResizable(false);
       
       //Sets the background of the panel to green
        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

       
        jLabel1.setBackground(new java.awt.Color(0, 102, 0));
        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239,187,41));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WVHS Math Department Computer Lab Reservation");

        weekLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        weekLabel.setForeground(new java.awt.Color(239,187,41));
        weekLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
       
       //Makes sure that the week label is displaying the current week date
        weekLabel.setText("Schedule for the week of " + week.getStartDate() + " - " + week.getEndDate());

        //Sets the table to be 8 by 6, labels the appropriate rows and columns, and sets the color
        jTable1.setBackground(new java.awt.Color(0, 102, 0));
        jTable1.setForeground(new java.awt.Color(187,126,39));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"             1", null, null, null, null, null},
                {"             2", null, null, null, null, null},
                {"             3", null, null, null, null, null},
                {"             4", null, null, null, null, null},
                {"             5", null, null, null, null, null},
                {"             6", null, null, null, null, null},
                {"             7", null, null, null, null, null},
                {"             8", null, null, null, null, null}
            },
            new String [] {
                "Period", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setRowHeight(50);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 18));
        jScrollPane1.setViewportView(jTable1);
        

       //Creates the label for the previous week button and its action listener
        previousWeekButton.setText("Previous");
        previousWeekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousWeekButtonActionPerformed(evt);
            }
        });

       //Creates the label for the next week button and its action listener
        nextWeekButton.setText("Next");
        nextWeekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextWeekButtonActionPerformed(evt);
            }
        });

       //Sets the layout of the panel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(previousWeekButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(weekLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextWeekButton))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previousWeekButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(weekLabel)
                            .addComponent(nextWeekButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
 /**Sets the labels of each box on the grid.
  * Boxes are labeled "Open" if there is no reservation
  * Labeled with the name and class otherwise
 */
    private void loadLabels(){
        for(int i = 0;i<pr.length;i++){
            for(int c = 0;c < pr[i].length; c++){
                if(pr[i][c].hasReservation()){
                    String label = DatabaseManager.reservationmap.get(pr[i][c]).toString();
                    jTable1.getModel().setValueAt(label,c,i+1);
                }else{
                    jTable1.getModel().setValueAt("OPEN", c, i+1);
                }
            }
        }
    }
    /**Loads a period array for the next week and updates the periods boxes and week label
     * @param evt - The next button being clicked
     */
    private void nextWeekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextWeekButtonActionPerformed
        week.nextWeek();
        pr = week.getPeriods();
        //for(ButtonEditor elem : be)
          //  elem.updatePeriods(pr);
        weekLabel.setText("Schedule for the week of " + week.getStartDate() + " - " + week.getEndDate());
        loadLabels();
        
               
    }//GEN-LAST:event_nextWeekButtonActionPerformed

    /**Loads a period array for the previous week and updates the periods boxes and week label
     * @param evt - The previous button being clicked
     */
    private void previousWeekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousWeekButtonActionPerformed
        week.previousWeek();
        pr = week.getPeriods();
        //for(ButtonEditor elem : be)
          //  elem.updatePeriods(pr);
        weekLabel.setText("Schedule for the week of " + week.getStartDate() + " - " + week.getEndDate());
        loadLabels();
    }//GEN-LAST:event_previousWeekButtonActionPerformed

    /**Starts this GUI when called by a main class
     */
    public static void startGUI() {
        
        try {
         //Sets the look and feel to Windows
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println(info.getName());
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JButton nextWeekButton;
    private javax.swing.JButton previousWeekButton;
    private javax.swing.JLabel weekLabel;
    // End of variables declaration//GEN-END:variables
    //This attribute will manage the week displayed to user
    Week week = new Week();
    public static Period[][] pr = new Period[5][8];
    
}
