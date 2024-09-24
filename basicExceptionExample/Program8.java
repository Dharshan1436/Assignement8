package assignment8.basicExceptionExample;

import java.io.FileReader;
import java.io.IOException;

public class Program8 {
    
    private static void readFile() throws Exception {
        try {
            FileReader file = new FileReader("non_existent_file.txt"); 
            file.close();
        } catch (IOException e) {
            throw new Exception("Failed to read the file", e); 
        }
    }

    public static void main(String[] args) {
        try {
            readFile(); 
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
            System.err.println("Cause: " + e.getCause());
        }
    }
}
