package Q3.programming.hue5.tests;

import Q3.programming.hue5.src.IArithmeticExpression;
import Q3.programming.hue5.src.NatNumber;
import Q3.programming.hue5.src.Sum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumTest {

    @Test
    void testSum() {
        IArithmeticExpression num1 = new NatNumber(6);
        IArithmeticExpression num2 = new NatNumber(9);
        IArithmeticExpression sum = new Sum(num1, num2);
        IArithmeticExpression sum2 = new Sum(sum, num1);
        IArithmeticExpression sum3 = new Sum(sum, sum);

        assertEquals(15, sum.evaluate());
        assertEquals(21, sum2.evaluate());
        assertEquals(30, sum3.evaluate());

    }


}