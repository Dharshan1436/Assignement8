package assignment8.realtimeExample;

class UpgradeNotAllowedException extends Exception {
    public UpgradeNotAllowedException(String message) {
        super(message);
    }
}

class PolicyNotFoundException extends Exception {
    public PolicyNotFoundException(String message) {
        super(message);
    }
}

class Customer1 {
    private String name;
    private String policyId;
    private int age;

    public Customer1(String name, String policyId, int age) {
        this.name = name;
        this.policyId = policyId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPolicyId() {
        return policyId;
    }

    public int getAge() {
        return age;
    }
}

public class Program8 {
    public void upgradePolicy(Customer1 customer) throws UpgradeNotAllowedException, PolicyNotFoundException {
        if (customer == null) {
            throw new PolicyNotFoundException("Customer does not exist.");
        }

        String policyId = customer.getPolicyId();

        if (policyId == null || policyId.isEmpty()) {
            throw new PolicyNotFoundException("Policy ID is invalid.");
        }

        if (customer.getAge() < 21) {
            throw new UpgradeNotAllowedException("Upgrade not allowed for customers under 21 years of age.");
        }

        System.out.println("Policy upgrade successful for " + customer.getName());
    }

    public static void main(String[] args) {
        Program8 policyUpgradeSystem = new Program8();

        try {
            Customer1 customer1 = new Customer1("John Doe", "POL123", 30);
            policyUpgradeSystem.upgradePolicy(customer1);

            Customer1 customer2 = new Customer1("Alice Smith", "", 25);
            policyUpgradeSystem.upgradePolicy(customer2);
        } catch (UpgradeNotAllowedException e) {
            System.err.println("Upgrade error: " + e.getMessage());
        } catch (PolicyNotFoundException e) {
            System.err.println("Policy error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
