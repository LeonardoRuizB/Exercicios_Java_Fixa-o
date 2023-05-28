package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter an integer: ");
        int number = sc.nextInt();

        boolean isPrime = checkNumberPrimo(number);

        if (isPrime) {
            System.out.println("The number " + number + " is prime.");
        } else {
            System.out.println("The number " + number + " is not prime.");
        }

        sc.close();
    }

    public static boolean checkNumberPrimo(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i=2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
