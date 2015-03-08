/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BasicArrays2
{

    public static void main(String[] args)
    {
        int slot=0;
        int[] randomArray = new int[10];
        Random rand = new Random();
        for (int i = 0;
                i < randomArray.length;
                i++) {
            randomArray[i] = rand.nextInt(100) + 1;
            System.out.println("Slot" + (slot++) + " has the following number in it: "+randomArray[i]);
        }
    }
}