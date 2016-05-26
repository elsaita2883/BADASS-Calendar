 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class ReservationMap extends HashMap{
    /**
     * Returns associated Reservation
     * @param key Period used to find attached Reservation
     * @return the attached Reservation, or null if there is none
     */
    public Reservation get(Period key) {
        if (key == null){
            return null;
        }
        int hash = key.hashCode();
        for (Object set : super.keySet()){
            if (set.hashCode() == hash){
                return (Reservation) super.get(set);
            }
        }
        return null;
    }
    
    /**
     * Removes Period and Reservation from the map
     * @param pr Period to remove
     */
    public void remove(Period pr){
        for(Object k: super.keySet()){
            Period key = (Period) k;
            if(pr.equals(key)){
                super.remove(k);
            }
        }
    }
    
    /**
     * Checks if ReservationMap has a Period
     * @param key Period to check
     * @return true if map has Period key, false if not
     */
    public boolean containsKey(Period key){
        for (Object k : super.keySet()){
            if (k.hashCode() == key.hashCode()) {
                return true;
            }
        }
        return false;
    }
}
