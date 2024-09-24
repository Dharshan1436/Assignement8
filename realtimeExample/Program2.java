package assignment8.realtimeExample;



class FraudulentClaimException extends RuntimeException {
 public FraudulentClaimException(String message) {
     super(message);
 }
}


class InvalidClaimAmountException extends RuntimeException {
 public InvalidClaimAmountException(String message) {
     super(message);
 }
}


public class Program2 {


 public void processClaim(double claimAmount, String claimDate, double policyCoverage) {
     if (claimAmount > policyCoverage) {
         throw new InvalidClaimAmountException("Claim amount exceeds policy coverage.");
     }
     
     
     
     if (isFraudulentClaim(claimDate)) {
         throw new FraudulentClaimException("Claim is considered fraudulent based on the date.");
     }
     
     System.out.println("Claim processed successfully: Amount = " + claimAmount);
 }
 
 
 private boolean isFraudulentClaim(String claimDate) {
     
     return "2024-01-01".equals(claimDate);
 }

 public static void main(String[] args) {
     Program2 claimSystem = new Program2();
     
   
     double claimAmount = 10000; 
     String claimDate = "2024-01-01";
     double policyCoverage = 10000;
     
     try {
         claimSystem.processClaim(claimAmount, claimDate, policyCoverage);
     } catch (InvalidClaimAmountException | FraudulentClaimException e) {
         System.err.println("Claim processing error: " + e.getMessage());
         
         System.out.println("Notification sent to claims department for investigation.");
     }
 }
}

