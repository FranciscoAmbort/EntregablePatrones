package org.example.Logica.bridge;

public interface PaymentGateway {
    boolean authorize(double amount);
    boolean capture(double amount);
}
