package assignment8.realtimeExample;


class CancellationNotAllowedException extends Exception {
    public CancellationNotAllowedException(String message) {
        super(message);
    }
}


class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}


class InsurancePolicy {
    private String policyId;
    private String holderName;
    private boolean isActive;
    private boolean isCancelable;

    public InsurancePolicy(String policyId, String holderName, boolean isCancelable) {
        this.policyId = policyId;
        this.holderName = holderName;
        this.isActive = true; 
        this.isCancelable = isCancelable; 
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getHolderName() {
        return holderName;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isCancelable() {
        return isCancelable;
    }

    public void cancel() {
        this.isActive = false; // Mark the policy as inactive
    }
}


public class Program6 {
    private InsurancePolicy[] policies; 

    public Program6() {
        policies = new InsurancePolicy[] {
            new InsurancePolicy("P001", "John Doe", true),
            new InsurancePolicy("P002", "Jane Smith", true),
            new InsurancePolicy("P003", "Alice Johnson",false)
        };
    }

 
    public void cancelPolicy(String policyId) throws CancellationNotAllowedException, PolicyNotFoundException {
        InsurancePolicy policy = findPolicy(policyId);
        if (!policy.isCancelable()) {
            throw new CancellationNotAllowedException("Cancellation not allowed for policy ID: " + policyId);
        }
        policy.cancel();
        System.out.println("Policy " + policyId + " has been successfully canceled.");
    }

  
    private InsurancePolicy findPolicy(String policyId) throws PolicyNotFoundException {
        for (InsurancePolicy policy : policies) {
            if (policy.getPolicyId().equals(policyId)) {
                return policy;
            }
        }
        throw new PolicyNotFoundException("Policy ID " + policyId + " not found.");
    }

    public static void main(String[] args) {
        Program6 policyCancellation = new Program6();

        try {
            
            policyCancellation.cancelPolicy("P001"); 
//            policyCancellation.cancelPolicy("P004"); 
            policyCancellation.cancelPolicy("P003");
        } catch (CancellationNotAllowedException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (PolicyNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
