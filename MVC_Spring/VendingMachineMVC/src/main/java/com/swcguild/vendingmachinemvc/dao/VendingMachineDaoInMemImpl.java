/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Inventory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Helvinator
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao
  {

    private Map<Integer, Inventory> inventoryMap = new HashMap<>();

    @Override
    public void addInventory(Inventory inventory) {
        inventoryMap.put(inventory.getInventoryId(), inventory);
    }

    @Override
    public void removeInventory(int inventoryId) {
        inventoryMap.remove(inventoryId);
    }

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryMap.put(inventory.getInventoryId(), inventory);
    }

    @Override
    public List<Inventory> getAllInventory() {
        Collection<Inventory> a = inventoryMap.values();
        return new ArrayList(a);
    }

    @Override
    public Inventory getInventoryById(int inventoryId) {
        return inventoryMap.get(inventoryId);
    }

    @Override
    public void vendInventory(int count, int inventoryId) {
        Inventory currentInventory = inventoryMap.get(inventoryId);
        int currentCount = currentInventory.getCount();
        currentCount--;
        currentInventory.setCount(currentCount);

    }

  }
