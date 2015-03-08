/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

import java.util.Random;

/**
 *
 * @author Helvinator
 */
public class CopyingArrays
  {

    public static void main(String[] args) {
        Random r = new Random();
        int ran;
        int[] array1;
        array1 = new int[10];
        int[] array2;
        array2 = new int[10];

        for (int i = 0;
                i < array1.length;
                i++) {
            ran = 1 + r.nextInt(100);
            array1[i] = ran;
            array1[9]=-7;
            System.out.print("array1 :"+ array1[i] + "  ");
        }
        System.out.println("");
        for (int i = 0;
                i < array2.length;
                i++) {
            array2[i] = array1[i];
            System.out.print("array2 :");
            System.out.print(array2[i] + "  ");
            System.out.println(" ");
        }
       //array1[9]= -7;
       // System.out.print("array1 :"+ array1 + "  ");
      //System.out.print("array2 :");
          //  System.out.print(array2 + "  ");
        
    }
  }
