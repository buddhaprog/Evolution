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
public class TenTimes
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String message;
        int n;

        System.out.println("Type in: Mr Mitchel is cool.");
        System.out.print("Message: ");
        message = sc.nextLine();

        for (n = 1;
                n <= 10;
                n = n + 1) {
            System.out.println(n + ". " + message);
        }
    }
}
