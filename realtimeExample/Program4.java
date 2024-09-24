package assignment8.realtimeExample;


class PolicyExpiredException extends Exception {
    public PolicyExpiredException(String message) {
        super(message);
    }
}

class PaymentPendingException extends Exception {
    public PaymentPendingException(String message) {
        super(message);
    }
}

class NonComplianceException extends Exception {
    public NonComplianceException(String message) {
        super(message);
    }
}


public class Program4 {
    
    
    public void renewPolicy(String policyStatus, boolean paymentPending, boolean compliant) 
            throws PolicyExpiredException, PaymentPendingException, NonComplianceException {
        
        if (policyStatus.equalsIgnoreCase("expired")) {
            throw new PolicyExpiredException("Policy has expired and cannot be renewed.");
        }
        
        if (paymentPending) {
            throw new PaymentPendingException("Payment is pending. Please settle outstanding payments.");
        }
        
        if (!compliant) {
            throw new NonComplianceException("Policyholder is non-compliant with renewal terms.");
        }
        
        System.out.println("Policy renewed successfully!");
    }

    public static void main(String[] args) {
        Program4 renewalSystem = new Program4();
        
        try {
            
            String policyStatus = "active";
            boolean paymentPending =false; 
            boolean compliant = true;
            
            renewalSystem.renewPolicy(policyStatus, paymentPending, compliant);
            
        } catch (PolicyExpiredException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (PaymentPendingException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (NonComplianceException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
