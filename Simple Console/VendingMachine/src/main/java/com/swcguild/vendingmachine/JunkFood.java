/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine;

import java.text.DecimalFormat;

/**
 *
 * @author Helvinator
 */
public class JunkFood
  {

    private String name;
    private int price;
    private int count;
    DecimalFormat df= new DecimalFormat("#.00");
    
    JunkFood(int count, String name, int price) {
        this.count = count;
        this.name = name;
        this.price = price;
      

    }

    JunkFood() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() { //fix how this looks with some escape sequences also think i might need /100.00
        return getName() + "\t$" +df.format(getPrice()/100.00) + "\t Inv: "+ getCount();
    
    
}
   
    public String toFile(){
    return getName() +  "::" +getPrice()+ "::" +getCount();
    }
}
