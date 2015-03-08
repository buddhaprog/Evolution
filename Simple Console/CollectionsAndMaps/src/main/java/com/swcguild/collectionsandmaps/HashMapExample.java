/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionsandmaps;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class HashMapExample
{
    public static void main(String[] args)
    {
        HashMap<String, Student> map= new HashMap<>();
         
        
        Student st1= new Student();
        st1.setFirstName("Phil");
        st1.setLastName("Ansolmo");
        st1.setStudentId("b4455");
        st1.setGpa(3.5);
        
        map.put(st1.getStudentId(), st1);
          
        Student st2= new Student();
        st2.setFirstName("Scott");
        st2.setLastName("Summers");
        st2.setStudentId("bb546");
        st2.setGpa(3.7);
        
        map.put(st2.getStudentId(), st2);
        
        Student st3= new Student();
        st3.setFirstName("Clive");
        st3.setLastName("Davis");
        st3.setStudentId("bb234");
        st3.setGpa(3.2);
        
        map.put(st3.getStudentId(), st3);
        
        System.out.println("Map Size equals: " + map.size());
        
        //keys must be unique
        // they are itterated in a "set" (not ordered)
        // if i ask for the values, it is given in a collection
        
        Set <String> keys=map.keySet();
        for (String keyName : keys) {
            System.out.println("key = " + keyName);
            Student st= map.get(keyName);
            System.out.println("First Name: " + st.getFirstName());
            
        }
        
        
    }
}
