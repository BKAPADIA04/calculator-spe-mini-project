package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testAddNumbers() {
        assertEquals(14021, Main.add(13910, 111));
        assertEquals(15, Main.add(10, 5));
        assertEquals(-10, Main.add(-3, -7));
        assertEquals(15, Main.add(20, -5));
        assertEquals(5, Main.add(0, 5));
    }
}