package Q3.programming.hue7.tests;

import Q3.programming.hue6.src.OperatorProductToken;
import Q3.programming.hue6.src.OperatorSumToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorTokenTest {
    OperatorSumToken op1 = new OperatorSumToken();
    OperatorSumToken op2 = new OperatorSumToken();
    OperatorProductToken op3 = new OperatorProductToken();
    OperatorProductToken op4 = new OperatorProductToken();


    @Test
    void testEquals() {
        assertEquals(true, op1.equals(op2));
        assertEquals(false, op1.equals(op3));
        assertEquals(false, op3.equals(op1));
        assertEquals(true, op3.equals(op4));
        // FIXME: Somehow not working?

    }

}
