package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testSquareRoot() {
        assertEquals(5.0, calculator.squareRoot(25));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void testNaturalLog() {
        assertEquals(2.302585092994046, calculator.naturalLog(10));
    }

}