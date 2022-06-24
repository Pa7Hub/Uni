package Q3.programming.hue10.tests.ParserTests;

import Q3.programming.hue10.src.Expressions.IExpression;
import Q3.programming.hue10.src.Expressions.NatNumber;
import Q3.programming.hue10.src.Expressions.Sum;
import Q3.programming.hue10.src.Parser.ExpressionParser;
import Q3.programming.hue10.src.Parser.StarterParser;
import Q3.programming.hue11.h41.src.Exceptions.ParserException;
import Q3.programming.hue6.src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


//      TODO: write other tests
public class ExpressionParserTest {
    @Test
    void tokensToExpression() throws ParserException {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new NatNumToken(1));
        tokens.add(new OperatorSumToken());
        tokens.add(new NatNumToken(1));

        ExpressionParser expressionParser = new ExpressionParser(tokens);
        IExpression expression1 = expressionParser.toExpression();
        IExpression expected = new Sum(new NatNumber("1"), new NatNumber("1"));

        assertEquals(expected, expression1);
    }

    @Test
    void starterParserTest() throws ParserException {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new NatNumToken(1));
//        tokens.add(new NatNumToken(1));

        StarterParser starterParser = new StarterParser(tokens);

        try {
            IExpression expression = starterParser.toExpression();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void invalidTokenSequencesTest() throws ParserException {
        List<Token> invalidTokens1 = new ArrayList<>();
        invalidTokens1.add(new OperatorSumToken());
        invalidTokens1.add(new OperatorSumToken());

        List<Token> invalidTokens2 = new ArrayList<>();
        invalidTokens2.add(new BracketOpeningToken());
        invalidTokens2.add(new OperatorSumToken());
        invalidTokens2.add(new BracketClosingToken());

        StarterParser starterParser = new StarterParser(invalidTokens2);

        try {
            IExpression expression = starterParser.toExpression();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
