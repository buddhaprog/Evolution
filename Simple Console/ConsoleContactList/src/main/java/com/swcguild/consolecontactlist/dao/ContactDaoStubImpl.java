/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.consolecontactlist.dao;

import com.swcguild.consolecontactlist.dto.Contact;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helvinator
 */
public class ContactDaoStubImpl implements ContactDao{

    @Override
    public void add(Contact contact) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int contactId) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Contact contact) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contact getContactById(int contactId) {
Contact dummyContact= new Contact();
dummyContact.setContactId(42);
dummyContact.setFirstName("John");
dummyContact.setLastName("Doe");
dummyContact.setEmail("jdoe@doe.com");

return dummyContact;

    }

    @Override
    public List<Contact> getAllContacts() {
        Contact dummyContact= new Contact();
dummyContact.setContactId(42);
dummyContact.setFirstName("John");
dummyContact.setLastName("Doe");
dummyContact.setEmail("jdoe@doe.com");



Contact dummyContact1= new Contact();
dummyContact1.setContactId(24);
dummyContact1.setFirstName("Sally");
dummyContact1.setLastName("Doe");
dummyContact1.setEmail("sdoe@doe.com");

List<Contact> dummyList= new ArrayList<>();
dummyList.add(dummyContact);
dummyList.add(dummyContact1);

return dummyList;




    
    
    }
    
    
    

}
