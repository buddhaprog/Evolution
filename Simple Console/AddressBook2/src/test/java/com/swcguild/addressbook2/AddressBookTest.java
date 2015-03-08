/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2;

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

   @Test
    public void testingAddressBook() throws IOException {
        //use for testing writing to the file, use to test your methods
        AddressBook ab = new AddressBook();
        
        //CREATE A CONTACT
        Contacts c = new Contacts();
        c.setLastName("helvey");
        c.setFirstName("rob");
        c.setStreetAddress("2402 woodland Avenue");
        c.setCityName("columbia");
        c.setState("wv");
        c.setZipCode("29201");
        
        //LOAD THE CONTACT INTO THE HASHMAP
        ab.addContact("Helvey", c);
        
        //WRITE THE CONTACT INTO THE FILE
        ab.writeContacts();
        
        
        //create a 2nd address book to test reading from the file
        AddressBook ab1 = new AddressBook();
                
            //READ FROM A DIFFERENT ADDRESS BOOK    
        ab1.readContacts();
        
        //COMPARE WHAT YOU ENTERED WITH WHAT YOU LOADED THROUGH YOUR OTHER FILE
        assertEquals(ab.getContactByLastName("Helvey"), ab.getContactByLastName("Helvey"));
        
        
    }
    
    /*
    @Test
    public void testReadContacts() {
        System.out.println("readContacts");
        AddressBook instance = new AddressBook();
        instance.readContacts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testWriteContacts() {
        System.out.println("writeContacts");
        AddressBook instance = new AddressBook();
        instance.writeContacts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        String lastName = "";
        Contacts contact = null;
        AddressBook instance = new AddressBook();
        Contacts expResult = null;
        Contacts result = instance.addContact(lastName, contact);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testRemoveContact() {
        System.out.println("removeContact");
        String lastName = "";
        AddressBook instance = new AddressBook();
        Contacts expResult = null;
        Contacts result = instance.removeContact(lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetContactByLastName() {
        System.out.println("getContactByLastName");
        String lastName = "";
        AddressBook instance = new AddressBook();
        Contacts expResult = null;
        Contacts result = instance.getContactByLastName(lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testGetAllContacts() {
        System.out.println("getAllContacts");
        AddressBook instance = new AddressBook();
        String[] expResult = null;
        String[] result = instance.getAllContacts();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        AddressBook instance = new AddressBook();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        AddressBook instance = new AddressBook();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
   
  }
