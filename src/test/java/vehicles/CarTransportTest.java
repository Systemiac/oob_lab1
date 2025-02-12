package vehicles;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTransportTest {
    private CarTransport cTransport;
    private Car testCar1;
    private Car testCar2;

    @BeforeEach
    void setup() {
        cTransport = new CarTransport(2, Color.WHITE, 540, "TestTruck", 5) {
            @Override
            public double speedFactor() {
                return 1.5;
            }
        };
        testCar1 = new Volvo240();
        testCar2 = new Saab95();
    }

    @Test
    public void testMove() {
        cTransport.raiseCargoBed();
        cTransport.loadCar(testCar1);
        cTransport.loadCar(testCar2);
        cTransport.lowerCargoBed();
        cTransport.startEngine();
        cTransport.move();

        assertEquals(cTransport.getPosY(), testCar1.getPosY());
        assertEquals(cTransport.getPosX(), testCar1.getPosX());
        assertEquals(cTransport.getPosX(), testCar2.getPosX());
        assertEquals(cTransport.getPosY(), testCar2.getPosY());
    }

    @Test
    public void testRaiseCargoBed() {
        cTransport.lowerCargoBed();
        cTransport.raiseCargoBed();
        assertEquals(70, cTransport.getCargoBedAngle());
    }

    @Test
    public void testLowerCargoBed() {
        cTransport.raiseCargoBed();
        cTransport.lowerCargoBed();
        assertEquals(0, cTransport.getCargoBedAngle());
    }

    @Test
    public void testLoadCarTransport() {
        cTransport.raiseCargoBed();
        assertEquals(0, cTransport.getCarAmount());
        cTransport.loadCar(testCar1);
        assertEquals(1, cTransport.getCarAmount());

    }

    @Test
    void testUnloadCar() {
        cTransport.raiseCargoBed();
        cTransport.loadCar(testCar1);
        assertEquals(1, cTransport.getCarAmount());
        cTransport.unloadCar();
        assertEquals(0, cTransport.getCarAmount());
    }

    @Test
    public void testGetCarAmount() {
        assertEquals(0, cTransport.getCarAmount());
    }
}
