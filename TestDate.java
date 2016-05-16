
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Swetal
 */
public class TestDate {
    
    public static void main(String []args){
       GregorianCalendar[] days;
    
        days  = new GregorianCalendar[5];
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
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        System.out.println(sdf.format(days[0].getTime()));
    }
}
