package assignment8.basicExceptionExample;

import java.util.Scanner;

public class Program6 {
    private static void div(int numerator, int denominator) {
        try {
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Division by zero is not allowed.");
        } finally {
            System.out.println("The division operation is complete.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the denominator: ");
        int denominator = sc.nextInt();
        int numerator = 100;
        div(numerator, denominator);
        sc.close();
    }
}
