package org.example.Logica.bridge;

public class MercadoPagoGateway implements PaymentGateway{
    @Override
    public boolean authorize(double amount) {
        System.out.println("MercadoPago autoriza $" + amount);
        return true;
    }

    @Override
    public boolean capture(double amount) {
        System.out.println("MercadoPago captura $" + amount);
        return true;
    }
}
