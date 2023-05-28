package application;

import entities.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Contact> list = new ArrayList<>();

        System.out.println("Welcome to Address Book in Java!    \n");

        int option = 0;
        while (option != 6) {
            System.out.println("Menu:");
            System.out.println("1. Add a contact");
            System.out.println("2. Show all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Update a contact's information");
            System.out.println("5. Remove a contact");
            System.out.println("6. Exit");

            System.out.print("\nOption: ");
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.print("\nEnter contact name: ");
                String name = sc.nextLine();
                System.out.print("Enter the contact's phone number: ");
                String phone = sc.nextLine();
                System.out.print("Enter contact email: ");
                String email = sc.next();
                sc.nextLine();

                Contact contact = new Contact(name, phone, email);

                list.add(contact);

                System.out.println("\nContact successfully added! \n");
            } else if (option == 2) {
                System.out.println("\nExisting contacts:");
                int number = 0;
                for (Contact contact : list) {
                    System.out.println((number + 1) + ". Name: " + list.get(number).getName()
                            + "\n   Phone: " + list.get(number).getPhone()
                            + "\n   Email: " + list.get(number).getEmail() + "\n");
                    number += 1;
                }
            } else if (option == 3) {
                System.out.print("\nEnter the name of the contact you want to search for: ");
                String nameSearch = sc.nextLine();
                System.out.println();

                List<Contact> contactsFound = new ArrayList<>();
                for (Contact contact : list) {
                    String firstName = contact.getName().split(" ")[0];
                    if (firstName.equalsIgnoreCase(nameSearch)) {
                        contactsFound.add(contact);
                    }
                }

                if (contactsFound.isEmpty()) {
                    System.out.println("Contact not found.\n");
                } else {
                    System.out.println("Search result:\n");
                    for (Contact contactFound : contactsFound) {
                        System.out.println("Name: " + contactFound.getName());
                        System.out.println("Phone: " + contactFound.getPhone());
                        System.out.println("Email: " + contactFound.getEmail());
                        System.out.println();
                    }
                }
            } else if (option == 4) {
                System.out.print("\nEnter the number of the contact you want to update: ");
                int numberContact = sc.nextInt();
                numberContact -= 1;
                sc.nextLine();
                if (numberContact < 0 || numberContact > list.size()) {
                    System.out.println("Number contact invalid.");
                } else {
                    Contact contact = list.get(numberContact);

                    System.out.print("\nEnter the contact's new phone number: ");
                    String newNumberPhone = sc.nextLine();

                    contact.setPhone(newNumberPhone);

                    System.out.println("\nContact information successfully updated!\n");
                }
            } else if (option == 5) {
                System.out.print("\nEnter the number of the contact you want to remove: ");
                int numberContact = sc.nextInt();
                numberContact -= numberContact;

                if (numberContact < 0 || numberContact > list.size()) {
                    System.out.println("Number contact invalid.");
                } else {
                    list.remove(numberContact);

                    System.out.println("\nContact removed successfully!\n");
                }
            }
        }
        System.out.println("The program has ended.");
        sc.close();
    }
}
