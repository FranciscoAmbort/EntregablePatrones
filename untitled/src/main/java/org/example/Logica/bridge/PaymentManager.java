package org.example.Logica.bridge;

public class PaymentManager {


    public PaymentProcessor SelectProcessor (int proveedor){
        PaymentGateway gateway;
        PaymentProcessor processor;
        if (proveedor == 1){
            gateway = new PaypalGateway();
            processor = new PaypalPaymentProcessor(gateway);
        }else {
            gateway = new MercadoPagoGateway();
            processor = new MercadoPagoPaymentProcessor(gateway);
        }
        return processor;
    }
}
