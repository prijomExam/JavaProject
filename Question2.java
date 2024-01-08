//WAP to check if the user entered string is palindrome or not
import java.util.Scanner;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a string: ");
        String string = sc.nextLine();

        if (checkpalin(string)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }

    static boolean checkpalin(String str) {
        StringBuilder reversedString = new StringBuilder(str).reverse();
        return str.equalsIgnoreCase(reversedString.toString());
    }
}
