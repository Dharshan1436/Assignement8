package assignment8.realtimeExample;

import java.util.HashMap;
import java.util.Map;


class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}


class InvalidCustomerDataException extends RuntimeException {
    public InvalidCustomerDataException(String message) {
        super(message);
    }
}


class Customer {
    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

  
}


public class Program5 {
    private Map<String, Customer> customerDatabase = new HashMap<>();

   
    public void addCustomer(String id, String name, String email) {
        if (id == null || id.isEmpty() || name == null || name.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidCustomerDataException("Customer ID, name, and email must not be empty.");
        }
        customerDatabase.put(id, new Customer(id, name, email));
        System.out.println("Customer added successfully: " + customerDatabase.get(id));
    }

    
    public void updateCustomer(String id, String name, String email) throws CustomerNotFoundException {
        if (!customerDatabase.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        customerDatabase.put(id, new Customer(id, name, email));
        System.out.println("Customer updated successfully: " + customerDatabase.get(id));
    }

    
    public void deleteCustomer(String id) throws CustomerNotFoundException {
        if (!customerDatabase.containsKey(id)) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
        }
        customerDatabase.remove(id);
        System.out.println("Customer with ID " + id + " deleted successfully.");
    }

    public static void main(String[] args) {
        Program5 cms = new Program5();

        try {
            
            cms.addCustomer("001", "John Doe", "john.doe@example.com");
            cms.addCustomer("002", "Jane Smith", "jane.smith@example.com");

            cms.updateCustomer("001", "Johnathan Doe", "johnathan.doe@example.com");

            
            cms.deleteCustomer("002");

           
            cms.updateCustomer("003", "Alice", "alice@example.com");

        } catch (CustomerNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (InvalidCustomerDataException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
