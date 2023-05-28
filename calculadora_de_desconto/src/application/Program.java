package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the original value of the product: ");
        double valueOrigin = sc.nextDouble();

        System.out.print("Enter the discount percentage: ");
        double percentage = sc.nextDouble();

        double finalValue = valueOrigin - (valueOrigin * (percentage / 100));

        System.out.print("The final value of product with percentage is: " + String.format("%.2f", finalValue));



        sc.close();
    }
}
