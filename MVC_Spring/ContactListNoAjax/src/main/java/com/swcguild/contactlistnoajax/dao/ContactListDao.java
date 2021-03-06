/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistnoajax.dao;

import com.swcguild.contactlistnoajax.dto.Contact;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ContactListDao
  {
    public Contact addContact(Contact contact);
    public void removeContact(int contactId);
    public void updateContact(Contact contact);
    public List<Contact> getAllContacts();
    public Contact getContactById(int contactId);
    public List<Contact> searchContactsByLastName(String lastName);
    public List<Contact> searchContactsByCompany(String company);
  }
