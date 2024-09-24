package assignment8.realtimeExample;


class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}


class PoorDrivingRecordException extends Exception {
    public PoorDrivingRecordException(String message) {
        super(message);
    }
}


class HealthIssueException extends Exception {
    public HealthIssueException(String message) {
        super(message);
    }
}


public class Program1 {
    
    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
    }
    
    public void validateDrivingRecord(boolean hasAccidents) throws PoorDrivingRecordException {
        if (hasAccidents) {
            throw new PoorDrivingRecordException("Driving record is poor (accidents reported).");
        }
    }
    
    public void validateHealthRecord(boolean hasHealthIssues) throws HealthIssueException {
        if (hasHealthIssues) {
            throw new HealthIssueException("Health issues reported.");
        }
    }

    public static void main(String[] args) {
        Program1 application = new Program1();
        
       
        int userAge = 18; 
        boolean hasAccidents = true; 
        boolean hasHealthIssues = false; 
        
        try {
            application.validateAge(userAge);
            application.validateDrivingRecord(hasAccidents);
            application.validateHealthRecord(hasHealthIssues);
            System.out.println("Application processed successfully.");
        } catch (InvalidAgeException | PoorDrivingRecordException | HealthIssueException e) {
            System.err.println("Error processing application: " + e.getMessage());
        }
    }
}
