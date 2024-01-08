//WAP to print the sum of digits example: 11122 should return 7.
import java.util.Scanner;
public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int num = sc.nextInt();

        int total = 0;
        while (num != 0) {
            total += num % 10;
            num /= 10;
        }

        System.out.println("The total sum of the digits is: " + total);
    }
}
