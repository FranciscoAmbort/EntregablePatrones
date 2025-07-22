package org.example.Logica.bridge;

public class MercadoPagoPaymentProcessor extends PaymentProcessor {
    public MercadoPagoPaymentProcessor (PaymentGateway paymentGateway){
        super (paymentGateway);

    }

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Procesando pago con MercadoPago...");
        return paymentGateway.authorize(amount) && paymentGateway.capture(amount);
    }

    @Override
    public boolean refundPayment(double amount) {
        System.out.println("MercadoPago reembolsa $" + amount);
        return true;
    }
}
