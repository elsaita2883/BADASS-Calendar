/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badass.calendar;

import java.util.HashMap;

/**
 *
 * @author Owner
 */
public class ReservationMap extends HashMap{
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
    public void put(Period key, Reservation value){
        super.put(key, value);
    }
    public boolean containsKey(Period key){
        for (Object k : super.keySet()){
            if (k.hashCode() == key.hashCode()) {
                return true;
            }
        }
        return false;
    }
}