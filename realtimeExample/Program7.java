package assignment8.realtimeExample;

class QuoteGenerationException extends Exception {
    public QuoteGenerationException(String message) {
        super(message);
    }
}

class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

class Customers {  
    private String name;
    private int age;
    private String healthStatus; 
    private String vehicleType;

    public Customers(String name, int age, String healthStatus, String vehicleType) {
        this.name = name;
        this.age = age;
        this.healthStatus = healthStatus;
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

public class Program7 {
    public double generateQuote(Customers customer) throws QuoteGenerationException {  // Updated parameter type
        if (customer == null) {
            throw new QuoteGenerationException("Customer details cannot be null.");
        }

        int age = customer.getAge();
        String healthStatus = customer.getHealthStatus();
        String vehicleType = customer.getVehicleType();
        
        double baseQuote = 500.0; 

        if (age < 18) {
            throw new InvalidInputException("Age cannot be less than 18.");
        } else if (age <= 25) {
            baseQuote += 200; 
        } else if (age > 60) {
            baseQuote += 150; 
        }

        if ("Pre-existing conditions".equalsIgnoreCase(healthStatus)) {
            baseQuote += 300; 
        }

        if ("Motorcycle".equalsIgnoreCase(vehicleType)) {
            baseQuote += 100;
        }

        return baseQuote; 
    }

    public static void main(String[] args) {
        Program7 quoteSystem = new Program7();

        try {
            // Create a customer with valid details
            Customers customer = new Customers("John Doe", 30, "Healthy", "Car");  // Updated instance creation
            double quote = quoteSystem.generateQuote(customer);
            System.out.printf("Insurance quote for %s: $%.2f%n", customer.getName(), quote);

            
            Customers invalidCustomer = new Customers("Alice Smith", 17, "Healthy", "Car");  // Updated instance creation
            double invalidQuote = quoteSystem.generateQuote(invalidCustomer);
            System.out.printf("Insurance quote for %s: $%.2f%n", invalidCustomer.getName(), invalidQuote);
        } catch (QuoteGenerationException e) {
            System.err.println("Quote generation error: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.err.println("Invalid input error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
