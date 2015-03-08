/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.arraylists;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Helvinator
 */
public class BasicArrayLists3 {
public static void main(String[] args) {
    Random ran= new Random();
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        
        for (int i = 0; i < 1000; i++) {
            myArray.add(10+ ran.nextInt(90));
        
        
       //for an array [i]
            // for arrayList myArray.get(i);
        }
    }
}

//}
