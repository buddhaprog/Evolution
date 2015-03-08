/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Helvinator
 */
public class AddressController
  {

    private AddressBook addressBooks = new AddressBook();
    private AddressBook addresses = new AddressBook();
    private Contacts contacts = new Contacts();
    private ConsoleIO io = new ConsoleIO();

    public void Run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        int choice= 0;

        try {
            addressBooks.loadContacts();
            addresses.loadContacts();
            //load contacts
            while (keepGoing) {
                printMenu();
                menuSelection = io.intReader("Please select from the above choices^");
                switch (menuSelection) {
                    case 1:
                        io.printme("add");
                        addAddress();
                        break;
                    case 2:
                        io.printme("delete");
                        deleteAddress();
                        break;
                    case 3:
                        io.printme("Find");
                        findAddress();
                        break;
                    case 4:
                        io.printme("Contact count");
                        numberOfAddresses();
                        break;
                    case 5:
                        io.printme("List All");
                        listAllAddresses();
                        break;
                    case 6:
                        io.printme("Edit");
                        editAddress();
                        break;
                    case 7:
                        io.printme("Save and Exit");
                        break;
                    default:
                        io.printme("Unknown command");

                }

            }

            io.printme("Thanks for updating you contact list");
           // contacts.writeContactList();
        } catch (FileNotFoundException ex) {
            io.printme("File not found");
        //} catch (IOException ex) ;
        }
                //io.printme("IO execption ooops");
            }
        
    
     
    private void printMenu() {
        io.printme("Main Menu");
        io.printme("1. Add address");
        io.printme("2. Delete address");
        io.printme("3. Find");
        io.printme("4. Number of addresses");
        io.printme("5. List all");
        io.printme("6. Edit address");
        io.printme("7. Save and exit");

    }

    public void addAddress() {
        int choice = 0;
        while (choice != 1) {
            String firstName = io.stringReader("Enter first name: ");
            String lastName = io.stringReader("Enter last Name: ");
            String streetNameAndNumber = io.stringReader("Enter street name and number ");
            String cityName = io.stringReader("Enter city Name: ");
            String zipCode= io.stringReader("Enter Zip code: ");
            String state= io.stringReader("Enter State: ");
            Contacts currentContact = new Contacts();
            currentContact.setStreetNameAndNumber(streetNameAndNumber);
            currentContact.setFirstName(firstName);
            currentContact.setLastName(lastName);
            currentContact.setZipCode(zipCode);
            currentContact.setState(state);
            currentContact.setCityName(cityName);
            addresses.addContact(lastName, currentContact);
            choice = io.intReader("Press 1 and enter to return to main menu, if you "
                    + "would like to continue to add another address just hit enter");
        }
    }

    public void deleteAddress() {
        int choice = 0;
        while (choice != 1) {
            String lastName = io.stringReader("Whose address would you like to remove");
            String response = io.stringReader("Are you sure? (Y/N)");
            if (response.equalsIgnoreCase("Y")) {
                addresses.removeContact(lastName);
               io.printme(lastName + " has been removed.");
            }
            choice = io.intReader("if you would like to return to the menu"
                    + " just hit '1' and 'Enter', if you would like to continue "
                    + "removing people just hit '2' and 'Enter");

        }
    }

     public void findAddress() {
        int choice = 0;
        while (choice != 1) {
            String lastName = io.stringReader("Please enter the persons last name of the"
                    + " address would you like to find?");
            Contacts currentName = addresses.getContact(lastName);
            if (currentName != null) {
                io.printme(currentName.getFirstName() + " " + currentName.getLastName());
                io.printme(currentName.getStreetNameAndNumber());
                io.printme(currentName.getCityName());
                io.printme(currentName.getState());
                io.printme(currentName.getZipCode());
                io.printme("");
            } else {
                io.printme("No address for: " + currentName);
            }
            choice = io.intReader("if you would like to return to the menu"
                    + " just hit '1' and 'Enter', if you would like to see "
                    + "another address hit '2' and 'Enter");
        }
    }

    public void numberOfAddresses() {
        int counter = 0;
        for (String s : addresses.getAllContacts()) {
            counter++;
        }
        io.printme("The number of contacts are: " + counter);

    }

    public void listAllAddresses() {
        String[] lastName = addresses.getAllContacts();
        for (int i = 0; i < lastName.length; i++) {
            Contacts currentContact = addresses.getContact(lastName[i]);
            io.printme(lastName[i] + ", " + currentContact.getFirstName()
                    + " lives at: \n" + currentContact.getStreetNameAndNumber() + "\n "
                    + currentContact.getCityName() + ","
                    + currentContact.getState() + " " + currentContact.getZipCode());
        }
        io.stringReader("Please hit 'Enter' to continue");
    }

    public void editAddress() {
        int choice = 0;
        String editedInfo;
        while (choice != 4) {
            String lastName = io.stringReader("What is the last name of who you'd like to edit");
            Contacts currentContact = addresses.getContact(lastName);
            choice = io.intReader("What would you like to edit about that person? \n"
                    + "1: First Name \n"
                    + "2: Last Name \n"
                    + "3: Addresss \n"
                    + "4: Nothing I'm done.\n");
            if (choice == 1) {
                editedInfo = io.stringReader("What is the new first name?");
                currentContact.setFirstName(editedInfo);
            } else if (choice == 2) {
                editedInfo = io.stringReader("What is the new last name?");
                currentContact.setLastName(editedInfo);
            } else if (choice == 3) {
                editedInfo = io.stringReader("What is the new Street Name and Number?");
                currentContact.setStreetNameAndNumber(editedInfo);
                editedInfo = io.stringReader("What is the new City name?");
                currentContact.setCityName(editedInfo);
                editedInfo = io.stringReader("What is the new State?");
                currentContact.setState(editedInfo);
                editedInfo = io.stringReader("What is the new zip code?");
                currentContact.setZipCode(editedInfo);
            } else if (choice == 4) {
                io.printme("Back to the menu");
            } else {
                io.printme("Unknown choice");
            }
            choice = io.intReader("if you would like to return to the menu"
                    + " just hit '1' and 'Enter', if you would like to see "
                    + "another address hit '2' and 'Enter");
            if (choice == 1) {
                choice = 4;
            }
        }
    }

    public void saveAddresses() {
        try {
            addresses.writeContactList();
        } catch (IOException ex) {
            io.printme("Error Writing to File");
        }
    }
}