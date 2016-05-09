
/**
 * Write a description of class ReservationException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class PeriodException extends Exception
{
   public PeriodException(String message){
       super(message);
   }
   public PeriodException(){
       super();
   }
}
