package assignment8.basicExceptionExample;

class InsufficientFundsException extends Exception {
    @Override
    public String getMessage() {
        return "Insufficient funds for this withdrawal.";
    }
}

public class Program7 {
    private double balance;

    public Program7(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Program7 account = new Program7(1000.0); 

        try {
            account.withdraw(1200.0); 
        } catch (InsufficientFundsException e) {
            System.err.println(e.getMessage());
        }

        
        System.out.println("Current balance: " + account.getBalance());
    }
}
