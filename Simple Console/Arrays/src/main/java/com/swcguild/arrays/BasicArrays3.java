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
public class BasicArrays3
{

    public static void main(String[] args)
    {
        int[] randomArray = new int[1000];
        Random r = new Random();
        int rand = 10 + r.nextInt(100);

        for (int i = 0;
                i < randomArray.length;
                i++) {
            randomArray[i] = rand;
            rand = 10 + r.nextInt(90);
            System.out.print(randomArray[i] + "  ");
            if ((1+i) % 20 == 0) {
                System.out.println("");
            }        
        }
    }
}
