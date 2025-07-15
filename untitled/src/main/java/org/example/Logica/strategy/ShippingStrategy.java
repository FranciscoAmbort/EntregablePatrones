package org.example.Logica.strategy;

public interface ShippingStrategy {
    double calculateCost(double weight, double length, double width, double height, String origin, String Destination);
}
