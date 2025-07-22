import org.example.Logica.bridge.PaymentGateway;
import org.example.Logica.bridge.PaymentProcessor;
import org.example.Logica.bridge.PaypalGateway;
import org.example.Logica.bridge.PaypalPaymentProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
public class PaypalProcessorTest {
    @Test
    public void testProcessPayment_Succes(){
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        when(mockGateway.authorize(100)).thenReturn(true);
        when(mockGateway.capture(100.0)).thenReturn(true);

        PaymentProcessor processor = new PaypalPaymentProcessor(mockGateway);

        boolean result = processor.processPayment(100);

        verify(mockGateway).authorize(100);
        verify(mockGateway).capture(100);
        //En ambos casos veifico que a partir del objeto simulado se llame a uthorize y capture con el paramtro 100

    }
    @Test
    public void testRefundPayment (){
        PaymentGateway mockGateway = mock(PaymentGateway.class); //si bien no se usa el mock, paymentprocessor no se puede contruir sin paymentgateway uso un mock vacio, total refun no utliza

        PaymentProcessor processor = new PaypalPaymentProcessor(mockGateway);

        boolean result = processor.refundPayment(50);

        assertTrue(result);
    }

    @Test
    public void testPayPalGateway_SinMock (){
        PaypalGateway gateway = new PaypalGateway();
        PaymentProcessor processor = new PaypalPaymentProcessor(gateway);

        boolean result = processor.processPayment(150);

        assertTrue(result);
    }

}
