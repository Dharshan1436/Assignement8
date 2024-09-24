package assignment8.basicExceptionExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program2 {

    private static void div() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.println("Enter the numerator: ");
            int numerator = sc.nextInt();
            System.out.println("Enter the denominator: ");
            int denominator = sc.nextInt();
            
            int result = numerator / denominator;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.err.println("Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.err.println("Please enter a valid integer.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e);
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        div();
    }
}
