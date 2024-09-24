package assignment8.realtimeExample;

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}

class InvalidPaymentDetailsException extends RuntimeException {
    public InvalidPaymentDetailsException(String message) {
        super(message);
    }
}

public class Program9 {
    private boolean paymentStatus;

    public void processPayment(String paymentMethod, double amount) throws PaymentFailedException {
        if (paymentMethod == null || paymentMethod.isEmpty()) {
            throw new InvalidPaymentDetailsException("Payment method cannot be null or empty.");
        }

        if (amount <= 0) {
            throw new InvalidPaymentDetailsException("Payment amount must be greater than zero.");
        }

        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            if (amount > 1000) {
                throw new PaymentFailedException("Payment failed due to insufficient funds.");
            }
        } else if (paymentMethod.equalsIgnoreCase("PayPal")) {
            paymentStatus = true; 
        } else {
            throw new InvalidPaymentDetailsException("Unsupported payment method.");
        }

        paymentStatus = true; 
        System.out.println("Payment of $" + amount + " processed successfully via " + paymentMethod + ".");
    }

    public static void main(String[] args) {
        Program9 paymentSystem = new Program9();

        try {
            // Successful payment
            paymentSystem.processPayment("Credit Card", 500);
            
            // Attempting payment that will fail
            paymentSystem.processPayment("Credit Card", 1500);
        } catch (PaymentFailedException e) {
            System.err.println("Payment error: " + e.getMessage());
        } catch (InvalidPaymentDetailsException e) {
            System.err.println("Invalid payment details: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
