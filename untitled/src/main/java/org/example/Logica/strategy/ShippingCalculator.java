package org.example.Logica.strategy;

public class ShippingCalculator {

    private  double weight;
    private  double length;
    private  double width;
    private  double height;
    private  String origin;
    private  String destination;
    private  ShippingStrategy strategy;

    public ShippingCalculator(double weight, double length, double width, double height,
                              String origin, String destination, ShippingStrategy strategy) {
        weight = weight;
        length = length;
        width = width;
        height = height;
        origin = origin;
        destination = destination;
        strategy = strategy;
    }

    public double calculateCost() {
        return strategy.calculateCost(weight, length, width, height, origin, destination);
    }
}

