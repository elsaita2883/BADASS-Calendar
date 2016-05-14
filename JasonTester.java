import java.util.*;
import java.io.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JasonTester
{
    public static void main(String args[])throws Exception{
        Week week = new Week();
        Period[][] pr = week.getPeriods();
        for(int i = 0;i<pr.length;i++)
            for(int c = 0;c < pr[i].length; c++)
                System.out.println(pr[i][c]);
    }
}