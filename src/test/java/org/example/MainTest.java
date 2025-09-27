package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testSquareRoot() {
        assertEquals(5.0, calculator.squareRoot(25));
        assertEquals(0.0, calculator.squareRoot(0));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(3628800, calculator.factorial(10));
    }

    @Test
    void testNaturalLog() {
        assertEquals(2.302585092994046, calculator.naturalLog(10));
        assertEquals(1.9459101490553132, calculator.naturalLog(7));
    }

    @Test
    void testPowerFunction() {
        assertEquals(8.0, calculator.powerFunction(2, 3));
        assertEquals(0.25, calculator.powerFunction(2, -2));
    }


}