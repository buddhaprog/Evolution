/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Inventory;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class VendingMachineDaoTest
  {
    private VendingMachineDao dao;
    public VendingMachineDaoTest() {
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
      dao = ctx.getBean("VendingMachineDao", VendingMachineDao.class);
 }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private int inventoryId;
    private String inventoryName;
    private int price;
    private int count;
    private DecimalFormat df = new DecimalFormat("#.00");
    
    
    @Test
    public void addRemoveInventoryTest(){
    Inventory a= new Inventory();
    a.setInventoryId(1);
    a.setInventoryName("Snickers");
    a.setPrice(1);
    a.setCount(3);
    
    dao.addInventory(a);
    
    Inventory fromNoWhere=dao.getInventoryById(a.getInventoryId());
    
    assertEquals(fromNoWhere, a);
    
    dao.removeInventory(a.getInventoryId());
    assertNull(dao.getInventoryById(a.getInventoryId()));
       
    }
    
    @Test
    public void addUpdateInventoryTest(){
    Inventory a= new Inventory();
    a.setInventoryId(1);
    a.setInventoryName("Snickers");
    a.setPrice(1);
    a.setCount(5);
    
    dao.addInventory(a);
    a.setCount(2);
    dao.updateInventory(a);
    Inventory fromNoWhere=dao.getInventoryById(a.getInventoryId());
    assertEquals(fromNoWhere, a);
    
  
    }
    @Test 
    public void getAllInventoryTest(){
    Inventory a= new Inventory();
    a.setInventoryId(1);
    a.setInventoryName("Snickers");
    a.setPrice(1);
    a.setCount(5);
    
    dao.addInventory(a);
    Inventory a1= new Inventory();
    a1.setInventoryId(2);
    a1.setInventoryName("tootsie roll");
    a1.setPrice(1);
    a1.setCount(3);
    dao.addInventory(a1);
    
    List<Inventory> iList= dao.getAllInventory();
    assertEquals(iList.size(),2);
    
    
    }
    
       
  }
