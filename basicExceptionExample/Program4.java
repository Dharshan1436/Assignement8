package assignment8.basicExceptionExample;

import java.util.Scanner;


class NegativeNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Input cannot be a negative number!";
    }
}

public class Program4 {
    private static void checkNumber() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter an integer:");
            int number = sc.nextInt();
            
            if (number < 0) {
                throw new NegativeNumberException();
            } else {
                System.out.println("You entered a valid number: " + number);
            }
        } finally {
            sc.close();  
        }
    }

    public static void main(String[] args) {
        try {
            checkNumber();
        } catch (NegativeNumberException e) {
            
            System.err.println(e.getMessage());
        }
    }
}
