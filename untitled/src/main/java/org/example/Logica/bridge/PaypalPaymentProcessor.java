package org.example.Logica.bridge;

public class PaypalPaymentProcessor extends PaymentProcessor{
    public PaypalPaymentProcessor(PaymentGateway paymentGateway) {
        super(paymentGateway);
    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Procesando pago con PayPal...");
        return paymentGateway.authorize(amount) && paymentGateway.capture(amount);
    }

    @Override
    public boolean refundPayment(double amount) {
        System.out.println("PayPal reembolsa $" + amount);
        return true;
    }
}
