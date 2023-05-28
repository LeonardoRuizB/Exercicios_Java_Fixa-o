package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Simple Calculator in Java!");
        System.out.print("Enter the first number: ");
        double firstNumber = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double secondNumber = sc.nextDouble();

        System.out.println("choose the operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Option: ");
        int option = sc.nextInt();

        double result = 0;
        if (option == 1) {
            result = firstNumber + secondNumber;
        }
        if (option == 2) {
            result = firstNumber - secondNumber;
        }
        if (option == 3) {
            result = firstNumber * secondNumber;
        }
        if (option == 4) {
            result = firstNumber / secondNumber;
        }

        System.out.println();
        System.out.println("Result: " + result);

        sc.close();
    }
}
