/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.forloops;

/**
 *
 * @author apprentice
 */
public class XsAndYs
{
    public static void main(String[] args) {
        
    
    double a= -10;
    double b=10;
    double c= .5;
    
    System.out.println("  X  \t  Y  ");
    System.out.println("-----\t-----");
    
    for (double i=a;
                i <= b;
                i += c) {
           
            double z=i*i;
           System.out.println(i + "\t" + z);
           
        }
}
  }
