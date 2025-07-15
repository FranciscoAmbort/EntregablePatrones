package org.example.Logica.strategy;

public class AirShippingStrategy implements ShippingStrategy{
    @Override
    public double calculateCost(double weight, double length, double width, double height, String origin, String Destination) {
        double volume = length * width* height;
        return weight*0.5+ volume*0.2;
    }
}
