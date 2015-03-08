/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.forloops;

import java.util.Scanner;

/**
 *
 * @author Helvinator
 */
public class DisplayingSomeMultiples
  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter a Number: ");
        int userInput = sc.nextInt();

        for (int i = 1;
                i <= 12;
                i++) {
            int userTotal = i * userInput;

            System.out.println(userInput + " x " + i + " = " + userTotal);
        }

    }

  }
