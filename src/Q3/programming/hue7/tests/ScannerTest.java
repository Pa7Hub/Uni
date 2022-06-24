package Q3.programming.hue7.tests;

import Q3.programming.hue6.src.Token;
import Q3.programming.hue6.src.NatNumToken;
import Q3.programming.hue6.src.OperatorSumToken;
import Q3.programming.hue7.src.Exceptions.EmptyTokenStringException;
import Q3.programming.hue7.src.Exceptions.InvalidCharacterException;
import Q3.programming.hue7.src.Scanner;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    Scanner scanner = new Scanner();
    List<Token> expected = new ArrayList<>();
    NatNumToken numToken = new NatNumToken(9);
    OperatorSumToken sumToken = new OperatorSumToken();

    @Test
    void toTokenSequence() throws EmptyTokenStringException, InvalidCharacterException {
        expected.add(numToken);
        expected.add(sumToken);
        expected.add(numToken);
        assertEquals(expected, scanner.toTokenSequence("9+9"));
        assertEquals(expected, scanner.toTokenSequence("9+9ASDQ")); // Should still work since it doesn't compile letters
    }

}
