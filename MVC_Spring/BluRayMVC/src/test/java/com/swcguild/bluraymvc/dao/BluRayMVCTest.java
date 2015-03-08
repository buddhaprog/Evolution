/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bluraymvc.dao;

import com.swcguild.bluraymvc.dto.Bluray;
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
public class BluRayMVCTest
  {
    private BlurayDao dao;
    
    public BluRayMVCTest() {
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
        dao = ctx.getBean("blurayDao", BlurayDao.class);
   
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    private int counterId;
private String title;
private String releaseDate;
private String mpaaRating;
private String director;
private String studio;
private String userRating;
private String userNotes;
    @Test
    public void addGetDeleteBluray(){
    Bluray b= new Bluray();
    b.setTitle("KFC");
    b.setReleaseDate("1975");
    b.setMpaaRating("R");
    b.setDirector("Klink");
    b.setStudio("Paramount");
    b.setUserRating("5");
    
    dao.addBluray(b);
    
    Bluray fromDb= dao.getBlurayById(b.getCounterId());
    
    assertEquals(fromDb, b);
    
    dao.removeBluray(b.getCounterId());
    
    assertNull(dao.getBlurayById(b.getCounterId()));
        
    }
    @Test
    public void addUpdateBluray(){
    Bluray b= new Bluray();
    b.setTitle("KFC");
    b.setReleaseDate("1975");
    b.setMpaaRating("R");
    b.setDirector("Klink");
    b.setStudio("Paramount");
    b.setUserRating("5");
    
    dao.addBluray(b);
    
    b.setDirector("clack");
    
    dao.updateBluray(b);
    
    Bluray fromDb=dao.getBlurayById(b.getCounterId());
    
    assertEquals(fromDb,b);
    
    }
    @Test
    public void getAllBlurays(){
    Bluray b= new Bluray();
    b.setTitle("KFC");
    b.setReleaseDate("1975");
    b.setMpaaRating("R");
    b.setDirector("Klink");
    b.setStudio("Paramount");
    b.setUserRating("5");
    
    dao.addBluray(b);
    
    Bluray b1= new Bluray();
    b1.setTitle("BFD");
    b1.setReleaseDate("1999");
    b1.setMpaaRating("G");
    b1.setDirector("Gooey");
    b1.setStudio("Pintsize");
    b1.setUserRating("2");
    
    dao.addBluray(b1);
    List<Bluray> bList = dao.getAllBlurays();
        assertEquals(bList.size(), 2);
    
    
    }
    @Test
    public void searchBluray(){
    Bluray b= new Bluray();
    b.setTitle("KFC");
    b.setReleaseDate("1975");
    b.setMpaaRating("R");
    b.setDirector("Klink");
    b.setStudio("Paramount");
    b.setUserRating("5");
    
    dao.addBluray(b);
    
    Bluray b1= new Bluray();
    b1.setTitle("BFD");
    b1.setReleaseDate("1999");
    b1.setMpaaRating("G");
    b1.setDirector("Gooey");
    b1.setStudio("Pintsize");
    b1.setUserRating("2");
    
    dao.addBluray(b1);
    
    Bluray b2= new Bluray();
    b2.setTitle("Hail");
    b2.setReleaseDate("1969");
    b2.setMpaaRating("X");
    b2.setDirector("Mary");
    b2.setStudio("Mini");
    b2.setUserRating("7");
    
    dao.addBluray(b2);
    
     // Create search criteria
        Map<SearchTerm, String> criteria = new HashMap<>();
        criteria.put(SearchTerm.TITLE, "KFC");
        List<Bluray> bList = dao.searchBlurays(criteria);
        assertEquals(1, bList.size());
        assertEquals(b, bList.get(0));
        criteria.clear();
        // New search criteria - look for Smith
        criteria.put(SearchTerm.TITLE, "Hail");
        bList = dao.searchBlurays(criteria);
        assertEquals(1, bList.size());
        criteria.clear();
        // Add company to search criteria
        criteria.put(SearchTerm.STUDIO, "Paramount");
        bList = dao.searchBlurays(criteria);        
        assertEquals(1, bList.size());
        assertEquals(b, bList.get(0));
        criteria.clear();
        // Change company to Microsoft, should get back nc3
        criteria.put(SearchTerm.RELEASE_DATE, "1969");        
        bList = dao.searchBlurays(criteria);
        assertEquals(1, bList.size());
        assertEquals(b2, bList.get(0));       
criteria.clear();
        // Change company to Apple, should get back nothing
        criteria.put(SearchTerm.STUDIO, "Micro");        
        bList = dao.searchBlurays(criteria);        
        assertEquals(0, bList.size());
    
    
    }
    
  }
