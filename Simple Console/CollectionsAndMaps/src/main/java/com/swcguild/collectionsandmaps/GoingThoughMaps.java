/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionsandmaps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class GoingThoughMaps
  {
    public static void main(String[] args) {
        //
        HashMap<String, Integer> populations= new HashMap<>();
        
        populations.put("USA", 313000000);
        populations.put("Canada", 34000000);
        populations.put("UK", 63000000);
        populations.put("Japan", 127000000);
        
        // to get my "set" of "keys" for the shit
        Set<String> countryNames= populations.keySet();
        
        //enhanced for loop
        for (String currentCountryName : countryNames){
            System.out.println(currentCountryName);
        }
        Iterator<String> iter = countryNames.iterator();
        
        while(iter.hasNext()){
        String currentCountryName = iter.next();
            System.out.println(currentCountryName);
        }
        
        // to print/access key and corresponding values
        for (String currentCountryName : countryNames){
        //get the associated value for the currentCountryName
            int currentPopulation= populations.get(currentCountryName);
            System.out.println("Country: "+ currentCountryName + "populations:  " +currentPopulation);
        
        }
        //first get values out they come out as a collection
        //keys have to be unique, values do not
        Collection <Integer>populationValues= populations.values();
        for(Integer currentPopulationValue: populationValues){
            System.out.println(currentPopulationValue);
        }
        //print key values and entry set thing
        // most efficient method to access key value etc...
        Set <Entry<String, Integer>>populationEntries= populations.entrySet();
        for(Entry <String, Integer> currentEntry : populationEntries){
        String currentyCountry= currentEntry.getKey();
        Integer currentPopulation= currentEntry.getValue();
            System.out.println("Country " + currentyCountry + " population " + currentPopulation);
        }
        
        
        
        
        
    }
    
  }
