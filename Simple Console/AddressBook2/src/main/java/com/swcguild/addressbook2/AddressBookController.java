/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Helvinator
 */
public class AddressBookController
  {

    ConsoleIO io = new ConsoleIO();
    AddressBook addressBook = new AddressBook();
    boolean keepGoing = true;

    public void run() {

        int menuChoice = 0;
        String userChoice;

        try {

            addressBook.readContacts();
            do {
                printMenu();
                doMenu();
            } while (keepGoing == true);
        } catch (FileNotFoundException ex) {
            io.print("Whoops! There's a bug in dis here file you got!");
        }

    }

    public void printMenu() {
        io.println("Welcome to your Address Book!");
        io.println("Please Select one of the following options:");
        io.println("1. Add Contact");
        io.println("2. Remove Contact");
        io.println("3. List All Contacts");
        io.println("4. Display Number of Contacts");
        io.println("5. Search for a contact by Last Name");
        io.println("6. Edit Address");
        io.println("7. Save and Exit");
        io.println("8. Exit without Saving");

    }

    public void doMenu() {
        switch (io.askForInt("Please Enter a selection 1-8:", 1, 8)) {
            case 1:
                this.addContact();
                break;
            case 2:
                this.removeContact();
                break;
            case 3:
                this.listAllContacts();
                break;
            case 4:
                this.addressBookCount();
                break;
            case 5:
                this.searchByLastName();
                break;
            case 6:
                this.editAddress();
                break;
            case 7:
                io.println("Goodbye, and don't worry your work has been saved!");
                this.save();
                keepGoing = false;
                break;
            case 8:
                io.println("Goodbye, all that stuff you just did.... didn't get saved!");
                keepGoing = false;
                break;

        }

    }

    public void addContact() {
        int choice = 0;
        while (choice != 1) {
            String streetAddress = io.askForString("What is the street name and number?");
            String cityName = io.askForString("What is the city?");
            String zipCode = io.askForString("What is the zip-code?");
            String state = io.askForString("What is the state");
            String firstName = io.askForString("What is the first name?");
            String lastName = io.askForString("What is the last name?");
            Contacts currentContact = new Contacts(lastName);
            currentContact.setStreetAddress(streetAddress);
            currentContact.setFirstName(firstName);
            currentContact.setCityName(cityName);
            currentContact.setState(state);
            currentContact.setZipCode(zipCode);
            addressBook.addContact(lastName, currentContact);
            choice = io.askForInt("Press '1' and 'Enter' to return to menu"
                    + " if you would like to continue adding addresses just hit"
                    + "  'Enter");
        }
    }

    public void removeContact() {
        int choice = 0;
        while (choice != 1) {
            String userChoice;
            String currentContact;
            currentContact = io.askForString("Please enter the Name of the Contact that you would like to remove: ");
            userChoice = io.askForString("are you sure? please enter y or n:");
            if (userChoice.equalsIgnoreCase("y")) {
                addressBook.removeContact(currentContact);
            } else {
                choice = io.askForInt("Press '1' and 'Enter' to return to menu"
                        + " if you would like to continue removing addresses just hit"
                        + "  'Enter");
            }

        }
    }

    public void listAllContacts() {
        String[] lastName = addressBook.getAllContacts();
        for (int i = 0;
                i < lastName.length;
                i++) {
            Contacts currentContact = addressBook.getContactByLastName(lastName[i]);
            io.println(lastName[i] + ", " + currentContact.getFirstName()
                    + " lives at: \n" + currentContact.getStreetAddress() + "\n "
                    + currentContact.getCityName() + ","
                    + currentContact.getState() + " " + currentContact.getZipCode());
        }
    }

    public void addressBookCount() {
        int counter = 0;
        for (String s
                : addressBook.getAllContacts()) {
            counter++;
        }
        io.println("The number of contacts are: " + counter);

    }

    public void searchByLastName() {
        String lastName = io.askForString("Please enter the persons last name of the"
                + " address would you like to find?");
        Contacts currentName = addressBook.getContactByLastName(lastName);
        if (currentName != null) {
            io.println(currentName.getFirstName() + " " + currentName.getLastName());
            io.println(currentName.getStreetAddress());
            io.println(currentName.getCityName());
            io.println(currentName.getState());
            io.println(currentName.getZipCode());
            io.println("");
        } else {
            io.println("Sorry have not idea who " + currentName + " is at all.");
        }
    }

    public void editAddress() {
        int choice = 0;
        String editedInfo;
        while (choice != 4) {
            String lastName = io.askForString("What is the last name of who you'd like to edit");
            Contacts currentContact = addressBook.getContactByLastName(lastName);
            choice = io.askForInt("What would you like to edit about that person? \n"
                    + "1: First Name \n"
                    + "2: Last Name \n"
                    + "3: Addresss \n"
                    + "4: Nothing I'm done.\n");
            if (choice == 1) {
                editedInfo = io.askForString("What is the new first name?");
                currentContact.setFirstName(editedInfo);
            } else if (choice == 2) {
                editedInfo = io.askForString("What is the new last name?");
                currentContact.setLastName(editedInfo);
            } else if (choice == 3) {
                editedInfo = io.askForString("What is the new Street Name and Number?");
                currentContact.setStreetAddress(editedInfo);
                editedInfo = io.askForString("What is the new City name?");
                currentContact.setCityName(editedInfo);
                editedInfo = io.askForString("What is the new State?");
                currentContact.setState(editedInfo);
                editedInfo = io.askForString("What is the new zip code?");
                currentContact.setZipCode(editedInfo);
            } else if (choice == 4) {
                io.askForString("Back to the menu");
            } else {
                io.askForString("Unknown choice");
            }
            choice = io.askForInt("if you would like to return to the menu"
                    + " just hit '1' and 'Enter', if you would like to see "
                    + "another address hit '2' and 'Enter");
            if (choice == 1) {
                choice = 4;
            }
        }

    }

    public void save() {
        try {
            addressBook.writeContacts();
        } catch (IOException ex) {
            io.println("Oh dear, there seems to be an issue");

        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.io);
        hash = 41 * hash + Objects.hashCode(this.addressBook);
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
        final AddressBookController other = (AddressBookController) obj;
        if (!Objects.equals(this.io, other.io)) {
            return false;
        }
        if (!Objects.equals(this.addressBook, other.addressBook)) {
            return false;
        }
        return true;
    }

  }
