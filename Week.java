/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Owner
 */
public class Week {
    private GregorianCalendar[] days;
    
    //creates the current week
    public Week(){
        this.days  = new GregorianCalendar[5];
        GregorianCalendar init = new GregorianCalendar();
        //roll back to monday
        while(init.get(Calendar.DAY_OF_WEEK)!=Calendar.MONDAY){
            init.add(Calendar.DAY_OF_MONTH,-1);
        }
        //fill the array with consecutive days
        for(int i = 0;i < days.length;i++){
            days[i]=(GregorianCalendar)init.clone();
            init.add(Calendar.DAY_OF_MONTH,1);
        }
    }
    //returns an array of Period[day][period]
    public Period[][] getPeriods() throws PeriodException{
        Period[][] week = new Period[5][8];
        for(int d = 0; d < days.length; d++){
            for(int p = 0;p < 8;p++){
                Calendar cur = days[d];
                int year = cur.get(Calendar.YEAR);
                int month = cur.get(Calendar.MONTH) + 1;
                int day = cur.get(Calendar.DAY_OF_MONTH);
                int period = p+1;
                week[d][p] = new Period( year,month,day,period);
            }
        }
        return week;
    }
    /*
    private final Day[] days = new Day[5];
    
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
    */
    public String getDayName(int index){
        switch(index){
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
                
        }
        return "";
    }
    public void draw(Graphics2D g2){
        for (int i = 0; i < 5; i++){
            Rectangle dayName = new Rectangle(200 + 100*i,200,100,50);
            g2.draw(dayName);
            g2.drawString(getDayName(i+2),dayName.x + 20, dayName.y + 20);
            g2.drawString(days[i].toString(),dayName.x + 20, dayName.y + 40);
        }
        for(int i = 0; i < 5; i++){
            Calendar day = days[i];
            for (int j = 0; j < 8; j++){
                Rectangle period = new Rectangle(200 + 100*i, 250 + 50*j,100,50);
                g2.draw(period);
                g2.drawString((j+1) + "", period.x + 20, period.y + 20);
            }
        }
    }
}
