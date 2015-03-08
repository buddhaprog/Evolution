/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Helvinator
 */
public class AddressBook
  {

    public static final String CONTACTS_FILE = "contacts.txt";

    public static final String DELIMITER = "::";

    private HashMap<String, Contacts> addressBookhm = new HashMap<>();

    public void readContacts() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CONTACTS_FILE)));

        String currentLine;
        String[] currentTokens;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Contacts currentContacts = new Contacts(currentTokens[0]);

            currentContacts.setFirstName(currentTokens[1]);
            currentContacts.setStreetAddress(currentTokens[2]);
            currentContacts.setCityName(currentTokens[3]);
            currentContacts.setState(currentTokens[4]);
            currentContacts.setZipCode(currentTokens[5]);
            addressBookhm.put(currentContacts.getLastName(), currentContacts);
        }
        sc.close();
    }

    public void writeContacts() throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contacts.txt")));

        String[] keys = this.getAllContacts();

        for (int i = 0;
                i < keys.length;
                i++) {
            Contacts currentContact = this.getContactByLastName(keys[i]);

            out.println(currentContact.getLastName() + DELIMITER
                    + currentContact.getFirstName() + DELIMITER
                    + currentContact.getStreetAddress() + DELIMITER
                    + currentContact.getCityName() + DELIMITER
                    + currentContact.getState() + DELIMITER
                    + currentContact.getZipCode());

            out.flush();
        }
        out.close();

    }

    public Contacts addContact(String lastName, Contacts contact) {
        return addressBookhm.put(lastName, contact);
    }

    public Contacts removeContact(String lastName) {
        return addressBookhm.remove(lastName);
    }

    public Contacts getContactByLastName(String lastName) {
        return addressBookhm.get(lastName);
    }

    public String[] getAllContacts() {
        Set<String> keySet = addressBookhm.keySet();
        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.addressBookhm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressBook other = (AddressBook) obj;
        if (!Objects.equals(this.addressBookhm, other.addressBookhm)) {
            return false;
        }
        return true;
    }
    
  }
