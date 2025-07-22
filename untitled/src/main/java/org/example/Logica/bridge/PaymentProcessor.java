package org.example.Logica.bridge;

public abstract class PaymentProcessor {
    public PaymentGateway paymentGateway;
    public PaymentProcessor (PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public abstract boolean processPayment(double amount);
    public abstract boolean refundPayment (double amount);
}
