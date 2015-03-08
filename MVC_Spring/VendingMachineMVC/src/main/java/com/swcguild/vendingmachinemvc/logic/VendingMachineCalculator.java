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
public interface VendingMachineCalculator
  {

    //public boolean canVend(int money, int inventoryId);

    public int numQuarter(int change);

    public int numDime(int change);

    public int numNickel(int change);
    
    public int numPennies(int change);
    
    public  String changeReturn(int money);
    
   public int change(double money, double price);

//    public ArrayList<Inventory> getAllItems() {
//        return inventory;
//    }
  }
