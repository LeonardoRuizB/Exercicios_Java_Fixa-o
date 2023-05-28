package application;

import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.println("Welcome to the Inventory Management System in Java!");

        int option = 0;
        while (option != 6) {
            System.out.println("\nMenu: ");
            System.out.println("1 - Add product");
            System.out.println("2 - View products in stock");
            System.out.println("3 - Search product by ID");
            System.out.println("4 - Change quantity of a product");
            System.out.println("5 - Remove product");
            System.out.println("6 - Exit");

            System.out.print("\nOption: ");
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.print("\nEnter the product id: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter product name: ");
                String name  = sc.nextLine();
                System.out.print("Observation: ");
                String observation = sc.nextLine();
                System.out.print("Enter the quantity of the product: ");
                int quantity = sc.nextInt();
                System.out.print("Enter the price of the product: ");
                double price = sc.nextDouble();

                Product product = new Product(id, name, quantity, price, observation);

                list.add(product);

                System.out.println("\nProduct added successfully!");

            } else if (option == 2) {
                System.out.println("\nProducts in stock:");
                int number = 0;
                for (Product product : list) {
                    System.out.println("\nProduct " + (number + 1) + "#:");
                    System.out.println("Id: " + list.get(number).getId());
                    System.out.println("Name: " + list.get(number).getName());
                    System.out.println("Quantity: " + list.get(number).getQuantity());
                    System.out.println("Price: " + list.get(number).getPrice());
                    System.out.println(list.get(number).getObservation());
                    number += 1;
                }
            } else if (option == 3) {
                System.out.print("\nEnter the Product ID: ");
                int productId = sc.nextInt();
                productId -= 1;
                System.out.println("\nRequested product: ");
                System.out.println("Id: " + list.get(productId).getId());
                System.out.println("Name: " + list.get(productId).getName());
                System.out.println("Quantity: " + list.get(productId).getQuantity());
                System.out.println("Price: " + list.get(productId).getPrice());
                System.out.println(list.get(productId).getObservation());
            } else if (option == 4) {
                System.out.print("\nEnter Product Id to change stock: ");
                int updateStockId = sc.nextInt();
                updateStockId -= 1;

                System.out.println("\nCurrent product stock " + "\"" + list.get(updateStockId).getName()
                        + "\"" + " is: " + "\"" + list.get(updateStockId).getQuantity() + "\"");

                if (updateStockId < 0 || updateStockId > list.size()) {
                    System.out.println("Id product invalid.");
                } else {
                    Product product = list.get(updateStockId);

                    System.out.print("\nEnter the new product quantity: ");
                    int newQuantity = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter a new observation: ");
                    String newObservation = sc.nextLine();

                    product.setQuantity(newQuantity);
                    product.setObservation(newObservation);
                    System.out.println("\nStock quantity updated successfully!");
                }
            } else if (option == 5) {
                System.out.print("\nEnter the Id of the product to be removed: ");
                int productToRemove = sc.nextInt();
                productToRemove -= 1;

                list.remove(productToRemove);

                System.out.println("Product removed successfully!\n");
            }
        }
        System.out.println("\nThe program has ended.");
        sc.close();
    }
}
