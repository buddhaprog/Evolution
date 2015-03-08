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
public class NoticingEvenNumbers
  {

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 20;
        int c = 1;
        int i = 0;

        //System.out.println("Count from: ");
        //a = sc.nextInt();
        //System.out.println("Count to: ");
        //b= sc.nextInt();
        //System.out.println("Count by: ");
        //c= sc.nextInt();
        for (i = a;
                i <= b + 1;
                i += c) {

            if (i % 2 == 0) {
                System.out.println(i + "<");
            } else {
                System.out.println(i);
            }
        }
    }
  }
