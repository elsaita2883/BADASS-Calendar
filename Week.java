/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.text.SimpleDateFormat;
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

    public void nextWeek(){
        GregorianCalendar init;
        for(int i = 0;i < days.length;i++){
            init = (GregorianCalendar) days[i];
            init.add(Calendar.DAY_OF_MONTH, 7);
            days[i] = init;
        }
    }
    
    public void previousWeek(){
        GregorianCalendar init;
        for(int i = 0;i < days.length;i++){
            init = (GregorianCalendar) days[i];
            init.add(Calendar.DAY_OF_MONTH, -7);
            days[i] = init;
        }
    }
    
    public String getStartDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        String str = sdf.format(days[0].getTime());
        return str;
    }
    
    public String getEndDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        String str = sdf.format(days[4].getTime());
        return str;
    }
    
    //returns an array of Period[day][period]
    public Period[][] getPeriods() {
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
}
