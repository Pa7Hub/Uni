package Q3.programming.hue6.tests;

import Q3.programming.hue6.src.NatNumToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NatNumTokenTest {
    NatNumToken num1 = new NatNumToken(1);
    NatNumToken num3 = new NatNumToken(3);

    @Test
    void toStringRepresentation() {
        assertEquals("3", num3.toStringRepresentation());
    }

    @Test
    void testToString() {
        assertEquals("1 NatNumToken" , num1.toString());
    }

    @Test
    void testEquals() {assertEquals(false, num1.equals(num3));}

}