package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the percentage of the IPI: ");
        int ipi = sc.nextInt();

        System.out.print("Enter the code of part 1: ");
        int code1 = sc.nextInt();

        System.out.print("Enter the unit value of part 1: ");
        double value1 = sc.nextDouble();

        System.out.print("Enter the quantity of part 1: ");
        int quantity1 = sc.nextInt();

        System.out.print("Enter the code of part 2: ");
        int code2 = sc.nextInt();

        System.out.print("Enter the unit value of part 2: ");
        double value2 = sc.nextDouble();

        System.out.print("Enter the quantity of part 2: ");
        int quantity2 = sc.nextInt();

        double total = (value1 * quantity1 + value2 * quantity2) * (ipi / 100.0 + 1.0);

        System.out.println("\nTotal to be paid: R$" + String.format("%.2f", total));

        sc.close();
    }
}
