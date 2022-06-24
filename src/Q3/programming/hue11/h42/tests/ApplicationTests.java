package Q3.programming.hue11.h42.tests;

import Q3.programming.hue11.h42.src.Application;
import Q3.programming.hue7.src.Scanner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTests {

    @Test
    void appTest() {
        Scanner scanner = new Scanner();
        Application application = new Application(scanner);
        String expressionString = "(6+3)*2";
        String expressionString2 = "11+5";
        String expressionString3 = "(31*4)+2";

        try {
            List<Integer> result = application.evaluate(expressionString);
            List<Integer> result2 = application.evaluate(expressionString2);
            List<Integer> result3 = application.evaluate(expressionString3);
            assertEquals(18, result.get(0));
            assertEquals(16, result2.get(0));
            assertEquals(126, result3.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void multipleExpressionsTest() {
        Scanner scanner = new Scanner();
        Application application = new Application(scanner);
        String expressionString = "(6+3)*2;11+5;(31*4)+2";

        try {
            List<Integer> results = application.evaluate(expressionString);
            assertEquals(18, results.get(0));
            assertEquals(16, results.get(1));
            assertEquals(124, results.get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}