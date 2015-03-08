/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionsandmaps;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author apprentice
 */
public class GoingThoughLists
  {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("First String");
        list.add("Second String");
        list.add("Third String");
        list.add("Fourth String");
        //enhanced for loop 
        // 'for' (element ":each: inside my current list" do not use i(counter) in enhanced for loops
        for (String currentString
                : list) {
            System.out.println(currentString);
        }
        //regular for loop
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        //iterator is an object that knows how to vist all the pieces in a collection
        // does not return things in a order that one would expect.
        // ask iterator if there is something to grab, if so grab it, 
        // if nothing matches what you are looking for you will get returned an empty list
        //hasNext is a boolean
        // next() hands you back stuff then moves in
        Iterator <String>iter= list.listIterator();
        
        while(iter.hasNext()){
            String currentString = iter.next();
            System.out.println(currentString);
        }
    
    
        
        

    }

  }
