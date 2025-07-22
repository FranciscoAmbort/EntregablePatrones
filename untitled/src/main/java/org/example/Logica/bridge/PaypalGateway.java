package org.example.Logica.bridge;

public class PaypalGateway implements PaymentGateway{
    @Override
    public boolean authorize(double amount) {
        System.out.println("PayPal autoriza $" + amount);
        return true;
    }

    @Override
    public boolean capture(double amount) {
        System.out.println("PayPal captura $" + amount);
        return true;
    }
}
