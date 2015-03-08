/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.vendingmachine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Helvinator
 */
public class VendingController {
    
    VendCalc calc = new VendCalc();
    ConsoleIO io = new ConsoleIO();
    ArrayList<JunkFood> items = calc.getAllItems();
    
    
    public void run(){
        try {
            calc.fileIn();
            printMenu();
            vendItem((int)(io.doubleReader("Please Deposit Money!") * 100), 
                    io.mmIntReader("Which Item?", 1, items.size() + 1) - 1);
            calc.fileOut();
        }
        catch (FileNotFoundException e) {
            io.printme("File not found!!!");
        }
        //took this out feb 21 not sure what I broke
       // catch (IOException e) {
       //     io.printme("OUT OF ORDER!!!");
       // }
    }
    
    public void printMenu() {
        for (int i = 0; i < items.size(); i++) {
            io.printme((i+1) + ":" + items.get(i).toString());
        }
        
        io.printme((items.size() + 1) + ":Return Change/Walk Away!\n");
    }
 
    
    public void vendItem(int money, int item) {
        if (item == items.size())
            change(money);
        else if (calc.canVend(money, item)) {
            JunkFood itemToVend = items.get(item);
            io.printme("Vending a " + itemToVend.getName());
            money -= itemToVend.getPrice();
            change(money);
            itemToVend.setCount(itemToVend.getCount() - 1); 
        }
        else {
            vendItem(money, io.mmIntReader("Make Another Selection\nPress " + 
                    (items.size()+1) + " to return change\n"
                    + "Amount Entered $" + money/100.0, 1, items.size() + 1) - 1);
        }
    }
    
    public void change(int money) {

        if (calc.numQuarter(money) != 0) {
            io.printme(calc.numQuarter(money) + " Quarters");
            money -= calc.numQuarter(money) * 25;
        
        if (calc.numDime(money) != 0) {
            io.printme(calc.numDime(money) + " Dime");
            money -= calc.numDime(money) * 10;
        
        if (calc.numNickel(money) != 0)
            io.printme(calc.numNickel(money) + " Nickel");
    }}}
    
    
    }
    
    
    
    
    
    
   
   

