package com.swcguild.bankmanagerspring.ui;

import com.swcguild.bankmanagerspring.ui.ConsoleIOInterface;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ConsoleIO implements ConsoleIOInterface
  {

    Scanner sc = new Scanner(System.in);

    @Override
    public int askForInt(String prompt) {
        return (int) askForDouble(prompt);
    }

    @Override
    public int askForIntRange(String prompt, int min, int max) {
        int result;
        do {
            result = (int) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public String askForString(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }

    @Override
    public float askForFloat(String prompt) {
        return (float) askForDouble(prompt);
    }

    @Override
    public float askForFloatRange(String prompt, float min, float max) {
        float result;
        do {
            result = (float) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
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

    @Override
    public double askForDoubleRange(String prompt, double min, double max) {
        double result;
        do {
            result = (double) askForDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public void print(String prompt) {
        System.out.print(prompt);
    }

    @Override
    public void println(String prompt) {
        System.out.println(prompt);
    }
    @Override
public LocalDate readIsoDate(String prompt) {
        boolean badInput;
        LocalDate result = null;
        do {
            try {
                System.out.println(prompt);
                String dateString = sc.nextLine();
                result = LocalDate.parse(dateString);
                badInput = false;

            } catch (DateTimeParseException e) {
                badInput = true;
            }

        } while (badInput);

        return result;
}
  }
