/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badass.calendar;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Owner
 */
public class Week {
    private final Day[] days = new Day[5];
    Period[] periods;
    public Week(Day firstDay){
        days[0] = firstDay;
        for (int i = 1; i < 5; i++){
            Day day = new Day(firstDay.getDay()+i,firstDay.getMonth(),firstDay.getYear());
            days[i] = day;
        }
    }
    public Day getDay(int index){
        return days[index];
    }
    public String getDayName(int index){
        switch(index){
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
                
        }
        return "";
    }
    public void draw(Graphics2D g2){
        for (int i = 0; i < 5; i++){
            Rectangle dayName = new Rectangle(200 + 100*i,200,100,50);
            g2.draw(dayName);
            g2.drawString(getDayName(i),dayName.x + 20, dayName.y + 20);
            g2.drawString(days[i].toString(),dayName.x + 20, dayName.y + 40);
        }
        for(int i = 0; i < 5; i++){
            Day day = days[i];
            for (int j = 0; j < 8; j++){
                Rectangle period = new Rectangle(200 + 100*i, 250 + 50*j,100,50);
                g2.draw(period);
                g2.drawString((j+1) + "", period.x + 20, period.y + 20);
                if (day.getPeriod(j) != null){
                    g2.drawString(day.getPeriod(j).toString(), period.x + 20, period.y + 40);
                }
            }
        }
    }
}