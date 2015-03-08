/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.forloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingMachineRevisited
{
    public static void main(String[] args)
    {
        
    
    Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int c;
        int i;
        
        System.out.println("Count from: ");
        a = sc.nextInt();
        System.out.println("Count to: ");
        b= sc.nextInt();
        System.out.println("Count by: ");
        c= sc.nextInt();
            
        for ( i=a;
                i <= b+1;
                i += c) {
            System.out.println(i);
        }
                
        

    }    
}
