package Q3.programming.hue11.h42.tests;

import Q3.programming.hue11.h41.src.Exceptions.ParserException;
import Q3.programming.hue11.h42.src.Application;
import Q3.programming.hue7.src.Exceptions.EmptyTokenStringException;
import Q3.programming.hue7.src.Exceptions.InvalidCharacterException;
import Q3.programming.hue7.src.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationExceptionHandling {
    Scanner scanner;
    Application app;

    @BeforeEach
    void init() {
        scanner = new Scanner();
        app = new Application(scanner);
    }

//     TODO figure out a good way to test exceptions with this structure
    @Test
    void emptyString() {
        String expressionString = "";

        EmptyTokenStringException exception = assertThrows(
                EmptyTokenStringException.class,
                () -> app.evaluate(expressionString),
                "expected Scanner to throw EmptyTokenStringException, but it didn't"
        );
        exception.printStackTrace();
    }

    @Test
    void invalidExpression() {
        String expressionString = "1++";

        ParserException exception = assertThrows(
                ParserException.class,
                () -> app.evaluate(expressionString),
                "expected Parser to throw ParserException, but it didn't"
        );
        exception.printStackTrace();
    }

    @Test
    void invalidGrouping() {
        String expressionString = "1+1;;";

//        FIXME this isn't really beneficial, as the Application should catch the invalid ';', instead of the Scanner...
        InvalidCharacterException exception = assertThrows(
                InvalidCharacterException.class,
                () -> app.evaluate(expressionString),
                "expected Parser to throw ParserException, but it didn't"
        );
        exception.printStackTrace();
    }
}
