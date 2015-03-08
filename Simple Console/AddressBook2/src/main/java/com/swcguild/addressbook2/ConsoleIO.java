package com.swcguild.addressbook2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO
  {

    Scanner sc = new Scanner(System.in);

    public int askForInt(String prompt) {
        return (int) askForDouble(prompt);
    }

    public int askForInt(String prompt, int min, int max) {
        int result;
        do {
            result = (int) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    public String askForString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    public float askForFloat(String prompt) {
        return (float) askForDouble(prompt);
    }

    public float askForFloat(String prompt, float min, float max) {
        float result;
        do {
            result = (float) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    public double askForDouble(String prompt) {
        boolean badInput;
        double result = 0;

        do {
            try {
                System.out.println(prompt);
                return Double.parseDouble(sc.nextLine());
                //badInput = false;
            } catch (NumberFormatException e) {
                System.out.println("Please Enter Numeric Value");
                badInput = true;
            }
        } while (badInput);

        return result;
    }

    public double askForDouble(String prompt, double min, double max) {
        double result;
        do {
            result = (double) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    public void print(String prompt) {
        System.out.print(prompt);
    }

    public void println(String prompt) {
        System.out.println(prompt);
    }
    

  }
