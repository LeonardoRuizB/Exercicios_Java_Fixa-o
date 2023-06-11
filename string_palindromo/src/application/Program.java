package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String input = sc.nextLine();
        sc.close();

        if (isPalindrome(input) == true) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String input) {
        // Remove espaços em branco e converte para letra maiúscula
        // "s" representa o espaço em branco
        // "+" indica que um ou mais espaços em branco consecutivos devem ser substituídos.
        String formattedInput = input.replaceAll("\\s+", " ").toUpperCase();

        int left = 0;
        // -1 para saber o final
        int right = formattedInput.length() - 1;

        while (left < right) {
            if (formattedInput.charAt(left) != formattedInput.charAt(right)) {
                return false;
            }
            // Enquanto acrescenta um caracter da esquerda para direta, diminui da direita para esquerda
            // assim comparando se ambos são iguais EX. NATAN, ele compara o N com N, depois A com A e assim sucessivamente.
            left++;
            right--;
        }
        return true;
    }
}
