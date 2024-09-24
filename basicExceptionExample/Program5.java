package assignment8.basicExceptionExample;

public class Program5 {
    public static void main(String[] args) {
        try {
           

            // Simulating an ArithmeticException
            // int result = 10 / 0; 

            // Simulating a NullPointerException
            // String str = null; 
            // int length = str.length(); 

            // Simulating an ArrayIndexOutOfBoundsException
            int[] arr = new int[5];
            int outOfBounds = arr[10]; // This will throw ArrayIndexOutOfBoundsException

        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException: Cannot divide by zero!");
        } catch (NullPointerException e) {
            System.err.println("NullPointerException: Attempted to access an object that is null!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("ArrayIndexOutOfBoundsException: Array index is out of bounds!");
        } catch (Exception e) {
            System.err.println("Generic Exception: An unexpected error occurred: " + e.getMessage());
        }
    }
}
