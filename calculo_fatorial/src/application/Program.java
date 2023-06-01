package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int number = sc.nextInt();

        while (number < 0) {
            System.out.println("This number is negative, enter positive number");
        }

        if ( number == 0) {
            System.out.println("The result is: 1");
        }

        int factorial = 1;

        for (int i=1; i<=number; i++) {
            factorial *= i;
        }

        System.out.println("\nThe factorial of " + number + " is " + factorial);

        sc.close();
    }
}
