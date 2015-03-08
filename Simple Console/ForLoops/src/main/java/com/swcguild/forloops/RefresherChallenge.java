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
public class RefresherChallenge
  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        String name;

        System.out.println("What is your name?");
        name = sc.nextLine();

        if (name.equalsIgnoreCase("Mitchel")) {
            n = 5;
        }

        for (int i = 1;
                i <= n;
                i++) {
            System.out.println(i + "-" + name);
        }
    }
  }
