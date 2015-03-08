/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

/**
 *
 * @author apprentice
 */
public class BasicArrays1
{
    public static void main(String[] args)
    {
        int[] slot10 = {-113,-113,-113,-113,-113,-113,-113, -113, -113, -113};
        int n=0;
        for (int i = 0; i < slot10.length; i++) {
            System.out.println("Slot " + i + " contains " + slot10[i]);
        }
        
        for (int num: slot10) {
            System.out.println("Slot " + (n++)+ " " +num);
        }
        
        
    }
}
