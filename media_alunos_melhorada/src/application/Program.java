package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many exams were administered? ");
        int n = sc.nextInt();

        double[] vector = new double[n];

        double total = 0;
        for (int i = 0; i < vector.length; i++) {
            System.out.print("Enter the grade for exam number " + (i + 1) + "#: ");
            vector[i] = sc.nextDouble();
            total += vector[i];
        }

        double average = total / n;

        if (average < 6.0) {
            System.out.println("Student average: " + String.format("%.2f", average) + " REPROVED");
        } else {
            System.out.print("Student average: " + String.format("%.2f", average) + " APPROVED");
        }

        sc.close();
    }
}
