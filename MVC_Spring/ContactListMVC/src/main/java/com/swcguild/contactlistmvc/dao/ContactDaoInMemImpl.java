
package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.dto.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Helvinator
 */
public class ContactDaoInMemImpl implements ContactDao {
    
    private Map<Integer, Contact> contactMap = new HashMap<>();
    
    private static int contactIdCounter = 0;
    
    @Override
    public void addContact(Contact contact) {
        contact.setContactId(contactIdCounter++);
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public void removeContact(int contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        Collection<Contact> c = contactMap.values();
        return new ArrayList(c);
    }

    @Override
    public Contact getContactById(int contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
