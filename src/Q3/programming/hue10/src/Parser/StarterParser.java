package Q3.programming.hue10.src.Parser;

import Q3.programming.hue10.src.Expressions.IExpression;
import Q3.programming.hue11.h41.src.Exceptions.ParserException;
import Q3.programming.hue11.h41.src.Exceptions.TokenListNotEmptyException;
import Q3.programming.hue6.src.Token;

import java.util.List;

/**
 * Parser Starter for initiating the parsing process and catching empty Token lists
 */
public class StarterParser extends Parser {
    public StarterParser(List<Token> tokens) {
        super(tokens);
    }

    public IExpression toExpression() throws ParserException {
        ExpressionParser expressionParser = new ExpressionParser(_tokens);
        IExpression expression = expressionParser.toExpression();
        if (_tokens.isEmpty()) {
            return expression;
        } else {
            throw new TokenListNotEmptyException("Token List is not empty, even though the Expression has been parsed!");
        }

    }
}
