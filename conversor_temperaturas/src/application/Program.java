package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the temperature to be converted: ");
        double value = sc.nextDouble();

        System.out.print("Enter the original temperature scale (C, F ou K): ");
        char temperature = sc.next().toUpperCase().charAt(0);

        System.out.println("Converted temperature: ");

        if (temperature == 'C') {
            double fahrenheit = (value * 9/5) + 32;
            System.out.printf("Fahrenheit: " + String.format("%.2f", fahrenheit) + "\n");
            double kelvin = value + 273.15;
            System.out.printf("Kelvin: " + String.format("%.2f", kelvin) + "\n");
        } else if (temperature == 'F') {
            double celsius = (value - 32) * 5/9;
            System.out.printf("Celsius: " + String.format("%.2f", celsius) + "\n");
            double kelvin =  (value + 459.67) * 5/9;
            System.out.printf("Kelvin: " + String.format("%.2f", kelvin) + "\n");
        } else {
            double celsius = value - 273.15;
            System.out.printf("Celsius: " + String.format("%.2f", celsius) + "\n");
            double fahrenheit = (value * 9/5) - 459.67;
            System.out.printf("Fahrenheit: " + String.format("%.2f", fahrenheit) + "\n");
        }

        sc.close();
    }
}
