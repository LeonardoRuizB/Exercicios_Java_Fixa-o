package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of A: ");
        int a = sc.nextInt();

        System.out.print("Enter the number of B: ");
        int b = sc.nextInt();

        System.out.print("Enter the number of C: ");
        int c = sc.nextInt();

        double delta = (b*b) - 4 * a * c;

        if (delta < 0) {
            System.out.println("\nIt has no real roots");
        } else {
            double x1 = (-b + delta) / (2 * a);
            double x2 = (-b - delta) / (2 * a);

            System.out.println("\nX1 = " + String.format("%.2f", x1));
            System.out.println("X2 = " + String.format("%.2f", x2));
        }
        sc.close();
    }
}
