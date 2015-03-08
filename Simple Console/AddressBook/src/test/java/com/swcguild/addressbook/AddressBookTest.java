/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookTest
  {
    
    public AddressBookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testingAddressBook() throws IOException {
        //use for testing writing to the file, use to test your methods
        AddressBook ab = new AddressBook();
        
        //CREATE A CONTACT
        Contacts c = new Contacts();
        c.setLastName("Sullivan");
        c.setFirstName("Zach");
        c.setStreetNameAndNumber("111 Jean Avenue");
        c.setCityName("Munroe Falls");
        c.setState("Ohio");
        c.setZipCode("44262");
        
        //LOAD THE CONTACT INTO THE HASHMAP
        ab.addContact("Sullivan", c);
        
        //WRITE THE CONTACT INTO THE FILE
        ab.writeContactList();
        
        
        //create a 2nd address book to test reading from the file
        AddressBook ab1 = new AddressBook();
                
            //READ FROM A DIFFERENT ADDRESS BOOK    
        ab1.loadContacts();
        
        //COMPARE WHAT YOU ENTERED WITH WHAT YOU LOADED THROUGH YOUR OTHER FILE
        assertEquals(ab.getContact("Sullivan"), ab1.getContact("Sullivan"));
        
        
    }
    
    
  }
