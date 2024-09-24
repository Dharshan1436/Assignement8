package assignment8.basicExceptionExample;

import java.util.Scanner;


class InvalidAgeException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid age! Please enter an age above 18.";
    }
}

public class Program3 {
    private static void checkAge() throws InvalidAgeException {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter your age:");
            int age = sc.nextInt();
            
            if (age < 18) {
                throw new InvalidAgeException();
            } else {
                System.out.println("Your age is okay.");
            }
        } finally {
            sc.close();  
        }
    }

    public static void main(String[] args) {
        try {
            checkAge();
        } catch (InvalidAgeException e) {
           
            System.err.println(e.getMessage());
        }
    }
}
