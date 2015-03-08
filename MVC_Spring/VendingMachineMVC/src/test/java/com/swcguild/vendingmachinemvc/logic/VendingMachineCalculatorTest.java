/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.logic;

import java.text.DecimalFormat;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class VendingMachineCalculatorTest
  {

    private VendingMachineCalculator calc;

    public VendingMachineCalculatorTest() {
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
        calc = ctx.getBean("VendingMachineCalculator", VendingMachineCalculator.class);
        
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
//    ArrayList<Inventory> inventory = new ArrayList<>();
    private String moneyBack;
    private int price;
    private DecimalFormat df = new DecimalFormat("#.00");
    private int money;
    private int penny;
    private int nickel;
    private int dime;
    private int quarter;

    @Test
    public void changeTest() {
        int a;
        price = 2;
        money = 3;
        a = calc.change(money, price);

        assertEquals(100, a);

    }

    @Test
    public void changeReturnTest() {
        int moneyIn = 110;
        money = 2;
        price = 1;

        int cmTest = calc.change(money, price);

        assertEquals(100, cmTest);
        
        String tester = calc.changeReturn(moneyIn);
        assertEquals("4 Quarters 1 Dimes ", tester);
        
        int moneyIn2=100;
        String tester2= calc.changeReturn(moneyIn2);
        assertEquals("4 Quarters ", tester2);
        
//        int moneyIn3=116;
//        String tester3= calc.changeReturn(moneyIn3);
//        assertEquals("4 Quarters 1 Dimes 1 Nickels 1 Pennies", tester3);
        

    }

  }
