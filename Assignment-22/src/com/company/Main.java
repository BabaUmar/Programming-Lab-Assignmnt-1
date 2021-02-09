package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    // Creating an instant with a default Number
    private static MobilePhone mobilePhone = new MobilePhone("000 443 876");

    public static void main(String[] args) {
        boolean quit=false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\n Enter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n Shutting down .. ");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;


        }

    }

        }
    private static void addNewContact() {
        System.out.println("Enter new Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone Number: ");
        String phone = scanner.nextLine();
        Contact newContact = Contact.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New Contact Added: name = "+ name + " , phone" + phone );
        }else {
            System.out.println("Can't add, " + name +" already on file");
        }
    }
    private static void updateContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Enter new Contact Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Phone Number: ");
        String newNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newNumber);
        if(mobilePhone.updateContact(extContact, newContact))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Contact");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        if(mobilePhone.removeContact(extContact)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error Deleting Contact");
        }
    }

    private static void queryContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contact extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Name : " + extContact.getName() +
                " Phone Number is: " + extContact.getPhoneNumber());
    }


    private static void startPhone(){
        System.out.println("Starting phone....");
    }
    public static void printActions(){
        System.out.println("\nAvailable actions:\npress:");
        System.out.println("0 - shutdown\n" +
                            "1 - to print contacts\n" +
                            "2 - Add new contact\n" +
                            "3 - to update an existing contact\n"+
                            "4 - to remove an existing contact\n"+
                            "5 - Query if an existing contact exist\n"+
                            "6 - To print a list of available actions.\n");
        System.out.println("Choose your action:");
    }
}
