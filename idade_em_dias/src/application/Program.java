package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how years: ");
        int years = sc.nextInt();

        System.out.print("Enter how many months: ");
        int months = sc.nextInt();

        System.out.print("Enter how days: ");
        int days = sc.nextInt();

        int totaldays = (years * 365) + (months * 30) + days;

        System.out.println("Total of days: " + totaldays + " days");

        sc.close();
    }
}
