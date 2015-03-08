/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dto;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author Helvinator
 */
public class Inventory
  {

    private int inventoryId;
    private String inventoryName;
    private double price;
    private int count;
    private DecimalFormat df = new DecimalFormat("#.00");
 @Override
    public String toString(){
 return getInventoryId() + getInventoryName()+ "\t$" +df.format(getPrice()/100.00) + "\t Inv: "+ getCount();    }
//    Inventory(int inventoryId, String inventoryName, int price, int count) {
//        this.count = count;
//        this.inventoryName = inventoryName;
//        this.price = price;
//        this.inventoryId = inventoryId;
//
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.inventoryId;
        hash = 23 * hash + Objects.hashCode(this.inventoryName);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 23 * hash + this.count;
        hash = 23 * hash + Objects.hashCode(this.df);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if (this.inventoryId != other.inventoryId) {
            return false;
        }
        if (!Objects.equals(this.inventoryName, other.inventoryName)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.count != other.count) {
            return false;
        }
        if (!Objects.equals(this.df, other.df)) {
            return false;
        }
        return true;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

   
  }
