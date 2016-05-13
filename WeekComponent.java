/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Owner
 */
public class WeekComponent extends JComponent{
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //Create a house object
        int i = 0;
        Day newYear = new Day(15,2,2001);
        Week week = new Week(newYear);
        //Draw that object
        week.draw(g2);
    }
}
