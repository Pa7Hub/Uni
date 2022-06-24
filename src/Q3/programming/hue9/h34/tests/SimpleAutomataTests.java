package Q3.programming.hue9.h34.tests;

import Q3.programming.hue9.h34.src.ErrorStateException;
import Q3.programming.hue9.h34.src.IllegalStateAssignmentException;
import Q3.programming.hue9.h34.src.SimpleAutomata;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleAutomataTests {

    @Test
    void testAcceptWord() throws ErrorStateException, IllegalStateAssignmentException {
        SimpleAutomata automata = new SimpleAutomata();

        assertEquals(true, automata.acceptWord("aabc"));
        automata.setState(0); // reset the state
        assertEquals(true, automata.acceptWord("aaaaaaaaaaaabc"));
        automata.setState(0); // reset the state
        assertEquals(true, automata.acceptWord("bc"));
    }

}
