/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Helvinator
 */
public class AddressBook
  {

     //This sets the name of our file and makes it permanent
    public static final String CONTACTS_FILE = "contacts.txt";

    //This is what we're going to use to seperate our items in the file
    public static final String DELIMITER = "::";

    private HashMap<String, Contacts> addressBooks = new HashMap<>();

    public void loadContacts() throws FileNotFoundException {
        //Need a scanner to read the file
        Scanner sc = new Scanner(new BufferedReader(new FileReader(CONTACTS_FILE)));

        //Is the current line of the file we're reading
        String currentLine;

        //Since current String is an array we put the array after the token
        //this seperates the aspects of the files
        String[] currentTokens;

        //Now that we can read it and serate the info we read it
        //While there is a next line it will keep going
        while (sc.hasNextLine()) {

            //the currentLine is read by the scanner
            currentLine = sc.nextLine();

            //The tokens split up the current line based off of the delimiter
            currentTokens = currentLine.split(DELIMITER);

            Contacts currentContacts = new Contacts(currentTokens[0]);

            currentContacts.setFirstName(currentTokens[1]);
            currentContacts.setStreetNameAndNumber(currentTokens[2]);
            currentContacts.setCityName(currentTokens[3]);
            currentContacts.setState(currentTokens[4]);
            currentContacts.setZipCode(currentTokens[5]);
            addressBooks.put(currentContacts.getLastName(), currentContacts);
        }
        sc.close();
    }

    public void writeContactList() throws IOException {

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(CONTACTS_FILE)));

        String[] keys = this.getAllContacts();

        for (int i = 0; i < keys.length; i++) {
            Contacts currentContact = this.getContact(keys[i]);

            out.println(currentContact.getLastName() + DELIMITER
                    + currentContact.getFirstName() + DELIMITER
                    + currentContact.getStreetNameAndNumber() + DELIMITER
                    + currentContact.getCityName() + DELIMITER
                    + currentContact.getState() + DELIMITER
                    + currentContact.getZipCode());

            out.flush();
        }
        out.close();

    }

    public Contacts getContact(String lastName) {
        return addressBooks.get(lastName);
    }

    public Contacts addContact(String lastName, Contacts contact) {
        return addressBooks.put(lastName, contact);
    }

    public Contacts removeContact(String lastName) {

        return addressBooks.remove(lastName);
    }

    public String[] getAllContacts() {
        Set<String> keySet = addressBooks.keySet();

        String[] keyArray = new String[keySet.size()];
        keyArray = keySet.toArray(keyArray);
        return keyArray;

    }
    public void getValues(){
    
    
    
    }
    
    
    
    
    /*
     public String[] getAllStudentIds() {
     // return a String array containing all of the keys from our student map
     // NOTE FOR APPRENTICES: We have to specify that this is Set of String.
     // This is necessary because we said above that all keys in our map must
     // be Strings.
     Set<String> keySet = students.keySet();
     // NOTE TO APPRENTICES: In order to return a String array of the keys
     // in the keySet, we must create an array big enough to hold all the
     // keys and then pass it into toArray.  toArray will then fill the
     // array up and return it to us.  We then just return it to the code that
     // called us.
     String[] keyArray = new String[keySet.size()];
     keyArray =  keySet.toArray(keyArray);
     return keyArray;
     }
     */

}