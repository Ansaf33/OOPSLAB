public class Q5 {

    public static void main(String[] args) {

        // CARD PAYMENT
        CardPayment c = new CardPayment();
        System.out.println("Payment Method : "+ c.getPaymentMethod());
        c.processPayment();
        double fee = c.calculateTransactinFee(150.0);
        System.out.println("Transaction fee for Card Payment : " + fee);
        System.out.println();
        // SECURE CARD PAYMENT

        SecureCardPayment sc = new SecureCardPayment();
        System.out.println("Secure Payment Method : " + sc.getPaymentMethod());
        sc.processPayment();
        double secureFee = sc.calculateTransactinFee(150);
        System.out.println("Transaction fee for Secure Payment : " + secureFee);



       
    }
    
}


class Payment{

    String getPaymentMethod(){
        return "Debit Card";
    }

    void processPayment(){
        System.out.println("Processing Card Payment..");
    }

    double calculateTransactinFee(double amount){
        return 0;
    }

    
}

class CardPayment extends Payment{

    @Override
    String getPaymentMethod(){
        return "Credit Card";
    }

    @Override
    void processPayment(){
        System.out.println("Processing Card Payment..");
    }

    @Override
    double calculateTransactinFee(double amount){
        return 0.02*amount;
    }
}
class SecureCardPayment extends CardPayment{


    @Override
    void processPayment(){
        System.out.println("Processing Card Payment..");
        System.out.println("Adding extra security layers to card payment..");
    }

    @Override
    double calculateTransactinFee(double amount){
        return 0.02*amount + 1;
    }

}