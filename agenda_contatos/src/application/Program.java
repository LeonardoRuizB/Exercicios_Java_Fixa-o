package application;

import entities.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                String name = sc.next();
                System.out.print("Enter the contact's phone number: ");
                String phone = sc.next();
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

            }


        }
        System.out.println("The program has ended.");
        sc.close();
    }
}
