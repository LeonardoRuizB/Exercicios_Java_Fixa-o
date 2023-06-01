package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the current minimum wage: ");
        double minimumCurrentWage = sc.nextDouble();

        System.out.print("Enter your current salary: ");
        double currentSalary = sc.nextDouble();

        int totalMinimumSalary = (int) (currentSalary / minimumCurrentWage);

        double remaining = (currentSalary - (minimumCurrentWage * totalMinimumSalary));

        System.out.println("\nTotal minimum wage received: " + totalMinimumSalary);
        System.out.println("Rest of salary R$" + String.format("%.2f", remaining));

        sc.close();
    }
}
