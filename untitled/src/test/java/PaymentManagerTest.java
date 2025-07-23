import org.example.Logica.bridge.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentManagerTest {
    @Test
    public void SelectProcessorPaypal_Ok(){
        PaymentManager paymentManager = new PaymentManager();
        int proveedor = 1; //paypal

        PaymentProcessor precessorEsperado = paymentManager.SelectProcessor(proveedor);

        assertInstanceOf(PaypalPaymentProcessor.class, precessorEsperado);
        assertInstanceOf(PaypalGateway.class, precessorEsperado.paymentGateway);
    }

    @Test
    public void SelectProcessorMercadoPafo_Ok(){
        PaymentManager paymentManager = new PaymentManager();
        int proveedor = 2; //MercadoPago

        PaymentProcessor processorEsperado = paymentManager.SelectProcessor(proveedor);

        assertInstanceOf(MercadoPagoPaymentProcessor.class, processorEsperado);
        assertInstanceOf(MercadoPagoGateway.class, processorEsperado.paymentGateway);
    }
}
