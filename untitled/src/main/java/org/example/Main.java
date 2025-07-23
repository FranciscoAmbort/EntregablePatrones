package org.example;
import org.example.Logica.bridge.*;
import org.example.Logica.strategy.*;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        //Ingreso de datos.
        System.out.println("Ingrese el peso del paquete:");
        double weight = scanner.nextDouble();

        System.out.print("Ingrese el largo del paquete: ");
        double length = scanner.nextDouble();

        System.out.print("Ingrese el ancho del paquete: ");
        double width = scanner.nextDouble();

        System.out.print("Ingrese el alto del paquete: ");
        double height = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese origen: ");
        String origin = scanner.nextLine();

        System.out.print("Ingrese destino: ");
        String destination = scanner.nextLine();

        System.out.print("Ingrese numero segun medio de envío (1.air / 2.truck / 3.boat): ");
        int medio = scanner.nextInt();

        System.out.print("Ingrese numero segun proveedor de pago (1.paypal / 2.mercadopago): ");
        int proveedor = scanner.nextInt();

        //Elegir estreategia segun medio.
        ShippingStrategy strategy;
        switch (medio){
            case 1:
                strategy = new AirShippingStrategy();
                break;
            case 2:
                strategy = new TruckShippingStrategy();
                break;
            case 3:
                strategy = new BoatShippingStrategy();
                break;
            default:
                System.out.println("Por default se elige estrategia Truck");  //Esto lo hago para no tener que inicializar strategy en null.
                strategy = new TruckShippingStrategy();
        }
        ShippingCalculator calculator = new ShippingCalculator(weight,length,width,height,origin,destination,strategy);
        //suplyAsync lanza tarea asincornica (otro hilo)
        CompletableFuture<Double> shippingCost = CompletableFuture.supplyAsync(() -> {
            System.out.println("\nCalculo de costo...");
            return calculator.calculateCost();
        });
        //thenApplyAsync hace que se ejecute una vez terminado shippingcost
        CompletableFuture<Boolean> payment = shippingCost.thenApplyAsync(cost -> {
            System.out.println("Costo calculado:" + cost);

            PaymentManager paymentManager = new PaymentManager();
            PaymentProcessor paymentProcessor = paymentManager.SelectProcessor(proveedor);
            return paymentProcessor.processPayment(cost);
        });

        try {
            boolean paymentStatus = payment.get(); // espera que se complete
            if (paymentStatus) {
                System.out.println("Pago realizado con exito.");
            } else {
                System.out.println("El pago fue rechazado.");
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ocurrió un error durante la operación" );
        }
    }


}