/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Inventory;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface VendingMachineDao
  {
    public void addInventory(Inventory inventory);
    public void vendInventory(int count, int inventoryId);
    public void removeInventory(int inventoryId);
    public void updateInventory(Inventory inventory);
    public List<Inventory> getAllInventory();
    public Inventory getInventoryById(int inventoryId);
    
  }
