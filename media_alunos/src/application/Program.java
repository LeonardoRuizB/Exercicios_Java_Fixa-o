package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the student's first grade: ");
        double a1 = sc.nextDouble();
        System.out.print("Enter the student's second grade: ");
        double a2 = sc.nextDouble();
        System.out.print("Enter the student's third grade: ");
        double a3 = sc.nextDouble();

        double average = (a1 + a2 + a3) / 3;

        System.out.print("Student average: " + String.format("%.2f", average));

        sc.close();
    }
}
