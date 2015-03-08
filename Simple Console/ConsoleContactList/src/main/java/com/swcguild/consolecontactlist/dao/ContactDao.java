/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.consolecontactlist.dao;

import com.swcguild.consolecontactlist.dto.Contact;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ContactDao 
  {
    public void add(Contact contact);
    public void remove(int contactId);
    public void update(Contact contact);
    public Contact getContactById(int contactId);
    public List<Contact> getAllContacts();
    
    
    
  }
