/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.vendingmachine;

/**
 *
 * @author Helvinator
 */
public class VendingApp {
    public static void main(String[] args) throws InterruptedException {
        VendingController main= new VendingController();
        //VendCalc calc= new VendCalc();
        main.run();
    }
}
