/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.vendingmachine;

import java.util.Scanner;

/**
 *
 * @author Helvinator
 */
public class ConsoleIO {
    Scanner sc = new Scanner(System.in);

    public int intReader(String prompt) {
        boolean badInput;
        int userInput = 0;
        do {
            try {
                System.out.println(prompt);

                userInput = Integer.parseInt(sc.nextLine());
                badInput = false;
                return userInput;

            } catch (NumberFormatException nfe) {
                System.out.println("Please Enter a Numeric Value");
                badInput = true;
            }

        } while (badInput);
        return userInput;
    }

    public int mmIntReader(String prompt, int min, int max) {
        
        int userInput;
        do {
            userInput= intReader(prompt);
//            System.out.println(prompt);
  //          userInput = Integer.parseInt(sc.nextLine());
        } while (userInput < min || userInput > max);
        return userInput;

    }

    public String stringReader(String prompt) {
        String userInput;
        System.out.println(prompt);
        userInput = sc.nextLine();
        return userInput;

    }

    public float floatReader(String prompt) {
        System.out.println(prompt);
        float readFloat = Float.parseFloat(sc.nextLine());
        return readFloat;

    }

    public float mmFloatReader(String prompt, float min, float max) {
        float a;
        do {
            System.out.println(prompt);
            a = Float.parseFloat(sc.nextLine());
        } while (a < min || a > max);
        return a;

    }

    public double doubleReader(String prompt) {
        double a;
        System.out.println(prompt);
        a = Double.parseDouble(sc.nextLine());
        return a;

    }

    public double mmdoubleReader(String prompt, double min, double max) {
        double a;
        do {
            System.out.println(prompt);
            a = Double.parseDouble(sc.nextLine());
        } while (a < min || a > max);
        return a;
    }

    public void printme(String prompt) {
        System.out.println(prompt);

    }
  }


