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
public class CountingMachine
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        int i;

        System.out.print("Count to: ");
        n = sc.nextInt();

        for ( i= 0;
                i < n+1;
                i ++) {
            System.out.println(i);
        
        }
        
    }

}

