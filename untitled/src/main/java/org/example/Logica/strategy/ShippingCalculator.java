package org.example.Logica.strategy;

public class ShippingCalculator {

    private final double weight;
    private final double length;
    private final double width;
    private final double height;
    private final String origin;
    private final String destination;
    private final ShippingStrategy strategy;

    public ShippingCalculator(double weight, double length, double width, double height,
                              String origin, String destination, ShippingStrategy strategy) {
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.origin = origin;
        this.destination = destination;
        this.strategy = strategy;
    }

    public double calculateCost() {
        return strategy.calculateCost(weight, length, width, height, origin, destination);
    }
}

