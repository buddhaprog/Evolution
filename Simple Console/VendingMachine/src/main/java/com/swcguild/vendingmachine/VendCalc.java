/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.vendingmachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Helvinator
 */
public class VendCalc {
        
    ArrayList<JunkFood> junk = new ArrayList<>();
    Change change = new Change();
    
    public boolean canVend(int money, int item) {
        return money >= junk.get(item).getPrice() && junk.get(item).getCount() > 0;
    }
    
    public int numQuarter(int change) {
        return (int)(change / 25);
    }
    
    public int numDime(int change) {
        return (int)(change / 10);
    }
    
    public int numNickel(int change) {
        return (int)(change / 5);
    }
    
    public ArrayList<JunkFood> getAllItems() {
        return junk;
    }
    
    public void fileIn() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("vendingmachine.txt")));
        String currentLine;
        String[] currentTokens;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split("::");
            JunkFood currentItem = new JunkFood(Integer.parseInt(currentTokens[2]), currentTokens[0], Integer.parseInt(currentTokens[1]));
            //currentItem.setName(currentTokens[0]);
            //currentItem.setPrice(Integer.parseInt(currentTokens[1]));
            //currentItem.setCount(Integer.parseInt(currentTokens[2]));
            junk.add(currentItem);
        }
        sc.close();
    }
    
    public void fileOut() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("vendingmachine.txt"));
        
        for (JunkFood item : junk) {
            out.println(item.toFile());
            out.flush();
        }
        out.close();
    }
}