package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();

        int first = 0;
        int second = 1;
        int result = 0;
        list.add(first);
        list.add(second);

        while (result < number) {
            result = first + second;
            // result = 0 + 1 = 1;
            // result = 1 + 1 = 2;
            // result = 1 + 2 = 3;
            // result = 2 + 3 = 5;

            list.add(result);

            first = second;
            second = result;
        }

        System.out.println(list);
    }
}
