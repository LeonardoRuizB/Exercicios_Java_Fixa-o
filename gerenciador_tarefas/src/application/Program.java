package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        System.out.println("Welcome to Task Manager in Java!");

        int option = 0;
        while (option != 5) {
            System.out.println("Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. List all tasks");
            System.out.println("3. Mark a task as completed");
            System.out.println("4. Remove a task");
            System.out.println("5. To go out");

            System.out.println();
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine();

            if (option == 1) {
                System.out.println();
                System.out.print("Enter the task description: ");
                String description = sc.nextLine();
                list.add(description);
                System.out.println();
                System.out.println("Task added successfully!");
                System.out.println();
            } else if (option == 2) {
                System.out.println();
                System.out.println("Existing tasks:");
                int result = 0;
                for (String element : list) {
                        result += 1;
                        System.out.println(result + ". " + element);
                    }
                System.out.println();
            } else if (option == 3) {
                System.out.println();
                System.out.print("Enter the number of the task you want to mark complete: ");
                int concluded = sc.nextInt();
                System.out.println();
                System.out.println("The task " + "\"" + list.get(concluded - 1) + "\"" + " has been marked as completed.");
                System.out.println();
            } else if (option == 4){
                System.out.println();
                System.out.print("Enter the number of the task you want to remove: ");
                int remove = sc.nextInt();
                System.out.println();
                System.out.println("The task " + "\"" + list.get(remove - 1) + "\"" + " was removed.");
                list.remove(remove - 1);
                System.out.println();
            }
        }

        System.out.println("The program has ended.");

        sc.close();
    }
}
