/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionsandmaps;

import java.util.ArrayList;

/**
 *
 * @author apprentice
 */
public class ArrayListExample
{
    public static void main(String[] args)
    {
        //create and arraylist, must import ArrayList
        // we are instatiating a concrete class
        ArrayList<Student>list= new ArrayList<>();
        System.out.println("List Size: " + list.size());
        // array as for .length, lists ask for .size
        
        Student st1= new Student();
        st1.setFirstName("Phil");
        st1.setLastName("Ansolmo");
        st1.setStudentId("b4455");
        st1.setGpa(3.5);
        
        list.add(st1);
   
        Student st2= new Student();
        st2.setFirstName("Scott");
        st2.setLastName("Summers");
        st2.setStudentId("bb546");
        st2.setGpa(3.7);
        
        list.add(st2);
        
        Student st3= new Student();
        st3.setFirstName("Clive");
        st3.setLastName("Davis");
        st3.setStudentId("bb234");
        st3.setGpa(3.2);
        
        list.add(st3);
     
            System.out.println("List Size: " + list.size());    
       // enhanced for loop to print out first name of each person in the list:
            
            for (Student s: list) {
                System.out.println(s.getFirstName());
            }
        //this next line changes the st1 first name to johnny
            st1.setFirstName("Johnny");
        for (Student s: list) {
                System.out.println(s.getFirstName());
            }
        //if we ran st1= new Student(); the array still says it is johnny, but the st1 does not...?!
    }
    
}
