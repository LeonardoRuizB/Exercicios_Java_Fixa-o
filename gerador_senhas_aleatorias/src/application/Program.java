package application;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int sizePassword = sc.nextInt();
        sc.nextLine();

        System.out.println("What types of characters should be included in the password? ");
        System.out.print("Enter 1 for uppercase letters, 2 for lowercase letters, 3 for numbers, and 4 for symbols (space separated): ");
        String options = sc.nextLine();

        String charactersAllowed = "";
        if (options.contains("1")) {
            charactersAllowed += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (options.contains("2")) {
            charactersAllowed += "abcdefghijklmnopqrstuvwxyz";
        }
        if (options.contains("3")) {
            charactersAllowed += "0123456789";
        }
        if (options.contains("4")) {
            charactersAllowed += "!@#$%^&*()-_=+[{]}\\\\|;:'\\\",<.>/?";
        }

        String generatedPassword = generateRandomPassword(sizePassword, charactersAllowed);
        System.out.println("Password Generate: " + generatedPassword);

        sc.close();
    }

    public static String generateRandomPassword(int size, String characters) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i=0; i < size; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
