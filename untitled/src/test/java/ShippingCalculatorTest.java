import org.example.Logica.strategy.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShippingCalculatorTest {

    @Test
    public void testAirShippingStrategy(){
        ShippingStrategy strategy = new AirShippingStrategy();
        ShippingCalculator shippingCalculator = new ShippingCalculator(
                10,
                20,
                30,
                40,
                "Buenos Aires",
                "Cordoba",
                strategy);

        double expected = 0.5 * 10 + 0.2 * (20 * 30 * 40);
        //weight*0.5+ volume*0.2; (formula que se usa en air)

        assertEquals(expected, shippingCalculator.calculateCost());

    }

    @Test
    public void testTruckShippingStrategy(){
        ShippingStrategy strategy = new TruckShippingStrategy();
        ShippingCalculator shippingCalculator = new ShippingCalculator(
                5,
                10,
                10,
                10,
                "Rosario",
                "Mendoza",
                strategy
        );

        double expected = 5*0.3 + 0.1*(10*10*10); //weight*0.3 + volume*0.1;

        assertEquals(expected, shippingCalculator.calculateCost());
    }

    @Test
    public void testBoatShippingStrategy(){
        ShippingStrategy strategy = new BoatShippingStrategy();
        ShippingCalculator shippingCalculator = new ShippingCalculator(
                15,
                5,
                5,
                5,
                "Salta",
                "Ushuaia",
                strategy
        );

        double expected = 15*0.2 + 0.1*(5*5*5); //weight*0.2 + volume*0.1;
        assertEquals(expected, shippingCalculator.calculateCost());
    }
}
