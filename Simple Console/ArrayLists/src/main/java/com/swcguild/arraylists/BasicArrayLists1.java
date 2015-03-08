/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.arraylists;

import java.util.ArrayList;

/**
 *
 * @author Helvinator
 */
public class BasicArrayLists1 {
public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        
        for (int i = 0; i < 10; i++) {
            myArray.add(-113);
        }
        
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println("Slot " + i + " contains a " + myArray.get(i));
        }
    }
    
}
