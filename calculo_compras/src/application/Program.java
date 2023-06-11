package application;

import entities.Items;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Items item = new Items();

        System.out.println("Welcome to the purchase calculation program!\n");

        double amount = 0;
        String response;
        int value = 1;
        do {
            System.out.print("\nEnter item name " + value + ": ");
            String name = sc.next();
            System.out.print("Enter the price of item " + value + ": ");
            Double price = sc.nextDouble();
            System.out.print("Enter the quantity of item " + value + ": ");
            int quantity = sc.nextInt();
            sc.nextLine();

            amount += item.total(price, quantity);

            System.out.print("\nWant to add more items? (Y/N): ");
            response = sc.next().toUpperCase();

            value += 1;
        } while (response.equals("Y"));

        System.out.printf("\nTotal purchase amount: R$ %.2f", amount);

        sc.close();
    }
}
