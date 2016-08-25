/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Zeel Parikh
 * 
 * Edits the Button based on the action performed
 */
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private int day;
    private int month;
    private int year;
    //private Period[][] periods;
    private int row;
    private int column;

/**Creates a button editor
 * @param checkBox - Constructs a DefaultCellEditor object that uses a check box.
 * @param periods - the period array that the button is part of 
 */ 
  public ButtonEditor(JCheckBox checkBox,Period[][] pr) {
    super(checkBox);
    //this.periods = pr;
    button = new JButton();
    button.setOpaque(false);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  
    @Override
    /**
     * @param table -The JTable the button is set in
     * @param value - The value for the label
     * @param isSelected - Whether or not the button is selected
     * @param row- The row of the button
     * @param column-The column of the button
     * @return Component - The Button to be displayed
     */ 
  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
      this.row = row;
      this.column = column-1;
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

/**Brings up a dialog box when the button is pushed
 * If the button is labeled as open then it allows the user to reserve it
 * Else it allows the user to cancel a reservation
 * @return Object - the new label as a String
 */
  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
        if(label.equals("OPEN")){      
            String name = Account.getCurrentUser();
            if(!(name.equals("no user"))){
                String className = JOptionPane.showInputDialog("What's your class name?");
                if(label != null){
                    label = name + " - " + className;
                    Reservation reserved = new Reservation(name, className);
                    NewJFrame.pr[column][row].addReservation(reserved);
                    button.setOpaque(false);
                    button.setBackground(Color.red);
                }        
            }    
       } else if(Account.getCurrentUser().equals(label.split(" - ")[0])){
            //String name = JOptionPane.showInputDialog("Do you want to cancel this reservation?");
            int i = JOptionPane.showConfirmDialog(editorComponent, "Do you want to cancel this reservation?");
            //(0 - Yes, 1-No, 2-Cancel)
            if(i == 0){
                label = "OPEN";
                NewJFrame.pr[column][row].removeReservation();
            }
            
        } else {
            JOptionPane.showMessageDialog(editorComponent, "You cannot edit this!");
        }
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
