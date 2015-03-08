/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.dao;

import com.swcguild.addressbookmvc.dto.Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoTest
  {

    private AddressBookDao dao;

    public AddressBookDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("addressBookDao", AddressBookDao.class);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}\
    @Test
    public void addGetDeleteAddress() {
        // create new contact
        Address ad = new Address();
        ad.setFirstName("John");
        ad.setLastName("Doe");
        ad.setStreetAddress("2402 woodland ave");
        ad.setCity("Chas");
        ad.setState("WV");
        ad.setZipcode("25303");

        dao.addAddress(ad);

        Address fromDb = dao.getAddressById(ad.getAddressId());

        assertEquals(fromDb, ad);

        dao.removeAddress(ad.getAddressId());

        assertNull(dao.getAddressById(ad.getAddressId()));
    }

    @Test
    public void addUpdateContact() {
        // create new contact
        Address ad = new Address();
        ad.setFirstName("Rob");
        ad.setLastName("Jones");
        ad.setStreetAddress("2402 tester ave");
        ad.setCity("Chas");
        ad.setState("WV");
        ad.setZipcode("99551");

        dao.addAddress(ad);

        dao.addAddress(ad);

        ad.setZipcode("11111");

        dao.updateAddress(ad);

        Address fromDb = dao.getAddressById(ad.getAddressId());

        assertEquals(fromDb, ad);
    }

    @Test
    public void getAllContacts() {
        // create new contact
        Address ad = new Address();
        ad.setFirstName("bobby");
        ad.setLastName("billairds");
        ad.setStreetAddress("100 tester ave");
        ad.setCity("Chas");
        ad.setState("sc");
        ad.setZipcode("99551");

        dao.addAddress(ad);

        // create new contact
        Address ad2 = new Address();
        ad2.setFirstName("John");
        ad2.setLastName("Jones");
        ad2.setStreetAddress("101 time");
        ad2.setCity("Fargo");
        ad2.setState("ND");
        ad2.setZipcode("12345");

        dao.addAddress(ad2);

        List<Address> aList = dao.getAllAddresses();
        assertEquals(aList.size(), 2);
    }

    @Test
    public void searchAddresses() {
        // create new contact
        Address ad = new Address();
        ad.setFirstName("bobby");
        ad.setLastName("billairds");
        ad.setStreetAddress("100 tester ave");
        ad.setCity("Chas");
        ad.setState("sc");
        ad.setZipcode("99551");

        dao.addAddress(ad);

        // create new contact
        Address ad2 = new Address();
        ad2.setFirstName("John");
        ad2.setLastName("Jones");
        ad2.setStreetAddress("101 time");
        ad2.setCity("Fargo");
        ad2.setState("ND");
        ad2.setZipcode("12345");

        dao.addAddress(ad2);

        // create new contact - same last name as first contact but different
        // company
        Address ad3 = new Address();
        ad3.setFirstName("sara");
        ad3.setLastName("billairds");
        ad3.setStreetAddress("100 tester ave");
        ad3.setCity("Chas");
        ad3.setState("wv");
        ad3.setZipcode("99551");

        dao.addAddress(ad3);

        // Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.LAST_NAME, "Jones");
        List<Address> aList = dao.searchAddresses(criteria);
        assertEquals(1, aList.size());
        assertEquals(ad2, aList.get(0));

        // New search criteria - look for Smith
        criteria.put(SearchTerm.LAST_NAME, "billairds");
        aList = dao.searchAddresses(criteria);
        assertEquals(2, aList.size());

        // Add state to search criteria
        criteria.put(SearchTerm.STATE, "wv");
        aList = dao.searchAddresses(criteria);
        assertEquals(1, aList.size());
        assertEquals(ad3, aList.get(0));
criteria.clear();
        // Change company to Microsoft, should get back nc3
        criteria.put(SearchTerm.FIRST_NAME, "sara");
        aList = dao.searchAddresses(criteria);
        assertEquals(1, aList.size());
        assertEquals(ad3, aList.get(0));

        // Change company to Apple, should get back nothing
        criteria.put(SearchTerm.ZIPCODE, "69696");
        aList = dao.searchAddresses(criteria);
        assertEquals(0, aList.size());
    }

  }
