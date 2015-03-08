/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.collectionsandmaps;

/**
 *Annotated Class showing the different components that can be included in a class.
 * @author apprentice
 */
public class AnnotatedClass
{// properties should generally be private (part of encapsulation also known as data hiding
//   aka encapsulating your fields).
//properties- they describe the class, they are the characteristics of the class.
    // some of the other terms that can be used here:
    //fields
    //attributes
    // class level variables : (these are also called properties
    private String name;
    private String color;
    private int age;
    
    //Constructors- special method that is run in conjunction with the new operator.
    // the purpose is to initialze the object. you don't have to explicitly describe a constructor, 
    // if you don't the compiler with provide you with a default constructor (null).
    // the default constructor: 
    public AnnotatedClass()  //a constructor starts with a capital letter, and has no return type.
   {}
   // another constructor:
       public AnnotatedClass(String nameIn, String colorIn, int ageIn) {
       //initialize properties
           name=nameIn;
           color = colorIn;
           age= ageIn;
       
       
       
       }
   // methods [ this is what the object (class) does]- they define the behavior of the class, sometime said
       // to be the business logic. methods of a class can be public or private.   
       //public ones are part of your public interface/ they for the public interface.\
       // private ones are considered your "helper" methods, part of your private implementation.
       // 
       public int add(int a, int b){
       return a+b;
       }
       private void helper(){
       // do something here
           // 
       }
   // getters and setters aka accesors and mutators
       // right click insert code, gettter and setter, check everything, unless you just want a couple, 
       // anyway check encapsulate fields, then hit generate

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
   //end of getters and setters
    //nested classes below, java lets us define another class inside a class
    //public or private, if only place it is going to be used in this class then private, if going to use in
    // another class public
    // nested classes can be static or non-static 
    // non static nested class is an inner
    // can't have a static nested inner class.
    // 
    private class foo {
    
    
    
    }
    
}
