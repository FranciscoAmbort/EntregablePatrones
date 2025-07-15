package org.example.Logica.strategy;

public class TruckShippingStrategy implements ShippingStrategy{

    @Override
    public double calculateCost(double weight, double length, double width, double height, String origin, String Destination) {
        double volume = length*weight*height;
        return  weight*3 + volume*1;
    }
}
