/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.consolecontactlist.controller;

import com.swcguild.consolecontactlist.dao.ContactDao;

/**
 *
 * @author Helvinator
 */
public class ContactController {
    private ContactDao dao;
    
    public ContactController(ContactDao dao){
    this.dao= dao;
    
    }
    public void run(){
        System.out.println("Running....");
    
    }
    
    
    

}
