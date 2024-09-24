package assignment8.realtimeExample;


class DataNotFoundException extends Exception {
    public DataNotFoundException(String message) {
        super(message);
    }
}


class CalculationException extends RuntimeException {
    public CalculationException(String message) {
        super(message);
    }
}

public class Program3 {
    
    
    public double calculateLifePremium(int age, boolean hasHealthIssues) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age must be greater than zero.");
        }
        
        double premium = 1000; 
        
        if (age > 50) {
            premium += 500; 
        }
        
        if (hasHealthIssues) {
            premium += 300; 
        }
        
        return premium;
    }
    

    public double calculateHealthPremium(int age, boolean hasPreExistingConditions) throws DataNotFoundException {
        if (age <= 0) {
            throw new DataNotFoundException("Age must be greater than zero.");
        }
        
        double premium = 800; 
        
        if (hasPreExistingConditions) {
            premium += 400;         }
        
        return premium;
    }
    
    
    public double calculateVehiclePremium(String vehicleType) throws DataNotFoundException {
        if (vehicleType == null || vehicleType.isEmpty()) {
            throw new DataNotFoundException("Vehicle type cannot be null or empty.");
        }
        
        double premium;
        
        switch (vehicleType.toLowerCase()) {
            case "car":
                premium = 1200; 
                break;
            case "motorcycle":
                premium = 800; 
                break;
            case "truck":
                premium = 1500;
                break;
            default:
                throw new CalculationException("Unsupported vehicle type: " + vehicleType);
        }
        
        return premium;
    }

    public static void main(String[] args) {
        Program3 calculator = new Program3();
        
        try {
            
            double lifePremium = calculator.calculateLifePremium(55, true);
            System.out.println("Life Insurance Premium: " + lifePremium);
            
         
            double healthPremium = calculator.calculateHealthPremium(30, false);
            System.out.println("Health Insurance Premium: " + healthPremium);
            
            double vehiclePremium = calculator.calculateVehiclePremium("car");
            System.out.println("Vehicle Insurance Premium: " + vehiclePremium);
            
            
            double unsupportedVehiclePremium = calculator.calculateVehiclePremium("bicycle");
            System.out.println("Vehicle Insurance Premium: " + unsupportedVehiclePremium);
            
        } catch (DataNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (CalculationException e) {
            System.err.println("Calculation Error: " + e.getMessage());
        }
    }
}
