/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.logic;

import com.swcguild.vendingmachinemvc.dto.Change;
import com.swcguild.vendingmachinemvc.dto.Inventory;
import java.util.ArrayList;

/**
 *
 * @author Helvinator
 */
public class VendingMachineCalculatorInMemImpl implements VendingMachineCalculator
  {

    private int penny;
    private int nickel;
    private int dime;
    private int quarter;

    // ArrayList<Inventory> inventory = new ArrayList<>();
    Change change = new Change();
    String moneyBack;
    int currentMoney;
    int money;
    //int price;
//    @Override
//    public boolean canVend(int money, int inventoryId) {
//        return money >= inventory.get(inventoryId).getPrice() && inventory.get(inventoryId).getCount() > 0;
//    }

    @Override
    public int numQuarter(int change) {
        return (int) (change / 25);
    }

    @Override
    public int numDime(int change) {
        return (int) (change / 10);
    }

    @Override
    public int numNickel(int change) {
        return (int) (change / 5);
    }

    @Override
    public int numPennies(int change) {
        return (int) (change / 1);
    }

    @Override
    public String changeReturn(int money) {
        String moneyBack = "";

        //String vendingMessage;
        //money = money * 100;
        if (money != 0) {
            if (numQuarter(money) >= 1) {
                moneyBack += numQuarter(money) + " Quarters ";
                money -= numQuarter(money) * 25;

                if (numDime(money) >= 1 && numQuarter(money) < 1) {
                    moneyBack += numDime(money) + " Dimes ";
                    money -= numDime(money) * 10;

                    if (numNickel(money) >= 1 && numDime(money) < 1) {
                        moneyBack += numNickel(money) + " Nickels ";
                        money -= numDime(money) * 5;

                        if (numPennies(money) >= 1 && numNickel(money) < 1) {
                            moneyBack += numPennies(money) + " Pennies";
                            money -= numPennies(money);
                        }
                    }
                }
            }
        } else {
            moneyBack = "No Change";
        }

        //vendingMessage=("you have recieved" +
        return moneyBack;

    }

    @Override
    public int change(double money, double price) {
        int currentMoney = 0;
        currentMoney = (int) ((money * 100) - (price * 100));
//        money = currentMoney;
        return currentMoney;
    }

  }
