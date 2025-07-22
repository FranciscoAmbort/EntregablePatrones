import org.example.Logica.bridge.MercadoPagoGateway;
import org.example.Logica.bridge.MercadoPagoPaymentProcessor;
import org.example.Logica.bridge.PaymentGateway;
import org.example.Logica.bridge.PaymentProcessor;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MercadoPagoProcessorTest {
    @Test
    public void testProcessPayemnt_Succes(){
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        when(mockGateway.authorize(150)).thenReturn(true);
        when(mockGateway.capture(150)).thenReturn(true);

        PaymentProcessor processor = new MercadoPagoPaymentProcessor(mockGateway);

        boolean result = processor.processPayment(150);

        assertTrue(result);

        verify(mockGateway).authorize(150);
        verify(mockGateway).capture(150);
    }

    @Test
    public void testRefundPayment() {
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        PaymentProcessor processor = new MercadoPagoPaymentProcessor(mockGateway);

        boolean result = processor.refundPayment(75.0);

        assertTrue(result);
    }

    @Test
    public void testMercadoPagoGateway_SinMock() {
        PaymentGateway gateway = new MercadoPagoGateway();
        PaymentProcessor processor = new MercadoPagoPaymentProcessor(gateway);

        boolean result = processor.processPayment(100);
        assertTrue(result);
    }
}
