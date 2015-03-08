/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.conditionals;

/**
 *
 * @author apprentice
 */
public class DayOfWeekSwitch {
    public static void main (String [] args)
    {
    int day =4;
    String dayName= "";
    
    switch (day) {
        case 1:
            dayName = "Monday";
                    break;
        case 2:
            dayName = "Tuesday";
                    break;
        case 3:
            dayName = "Wednesday";
                    break;
        case 4:
            dayName = "Thursday";
                    break;
        case 5:
                    dayName= "Friday";
                    break;
        case 6:
                    dayName= "Saturday";
                break;
        case 7:
                    dayName= "Sunday";
    }
                    
            
    
        System.out.println(dayName);
    
    
    
    
    }
}
