/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badass.calendar;

import javax.swing.JFrame;

/**
 *
 * @author Owner
 */
public class WeekViewer {
    public WeekViewer(){
        setupPage();
    }
    public void setupPage(){
        //Set up frame
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setTitle("A House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Make and add WeekComponent to JFrame
        WeekComponent component = new WeekComponent();
        frame.add(component);
        
        //Make sure week can be seen
        frame.setVisible(true);
    }
}
