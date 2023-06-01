package application;

import java.util.Calendar;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Obtém a data atual
        Calendar currentDate = Calendar.getInstance();

        System.out.print("Enter the month you were born: ");
        int month = sc.nextInt();

        System.out.print("Enter the day you were born: ");
        int day = sc.nextInt();

        System.out.print("Enter the year you were born: ");
        int year = sc.nextInt();

        Calendar birthDate = Calendar.getInstance();
        birthDate.set(year, month, day); // Ano, mês e dia

        // Calcula a diferença entre as datas
        int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // Verifica se ainda não fez aniversário neste ano
        if (currentDate.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)
                || (currentDate.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH)
                && currentDate.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

        System.out.println("You have " + age + " years.");

        sc.close();
    }
}
