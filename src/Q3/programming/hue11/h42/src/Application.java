package Q3.programming.hue11.h42.src;

import Q3.programming.hue10.src.Expressions.IExpression;
import Q3.programming.hue10.src.Parser.StarterParser;
import Q3.programming.hue11.h41.src.Exceptions.ParserException;
import Q3.programming.hue11.h42.src.Exceptions.ApplicationException;
import Q3.programming.hue6.src.Token;
import Q3.programming.hue7.src.Exceptions.EmptyTokenStringException;
import Q3.programming.hue7.src.Exceptions.InvalidCharacterException;
import Q3.programming.hue7.src.Scanner;

import java.util.ArrayList;
import java.util.List;

public class Application {
    Scanner _scanner;

    public Application(Scanner scanner) {
        _scanner = scanner;
    }

//    TODO this doesn't really solve the task as we aren't doing it over the launch parameters, but eh
    public List<Integer> evaluate(String expressionString) throws ParserException, ApplicationException, InvalidCharacterException, EmptyTokenStringException {
        List<Integer> results = new ArrayList<Integer>();
        List<String> expressions = groupExpressions(expressionString);
        for (String subString : expressions) {
            List<Token> tokens = _scanner.toTokenSequence(subString);
            StarterParser parser = new StarterParser(tokens);
            IExpression expression = parser.toExpression();
//                 TODO maybe change this to an array, would require to write a push method tho
            results.add(expression.evaluate());
        }
        for (int index = 0; index < results.size(); index++) {
            System.out.println("Result " + (index+1) + " is: " + results.get(index));
        }
        return results;
    }

    private List<String> groupExpressions(String expressionString) {
        List<String> expressions = new ArrayList<String>();
        return splitExpression(expressions, expressionString);
    }

    private List<String> splitExpression(List<String> expressions, String expressionString) {
        int nextIndex = expressionString.indexOf(';');
        if (nextIndex != -1) {
            expressions.add(expressionString.substring(0, nextIndex+1));
            splitExpression(expressions, expressionString.substring(nextIndex+1));
        } else {
            expressions.add(expressionString);
        }
        return expressions;
    }

}
