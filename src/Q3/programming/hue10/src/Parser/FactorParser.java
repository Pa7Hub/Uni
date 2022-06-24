package Q3.programming.hue10.src.Parser;

import Q3.programming.hue10.src.Expressions.BracketExpression;
import Q3.programming.hue10.src.Expressions.Factor;
import Q3.programming.hue10.src.Expressions.NatNumber;
import Q3.programming.hue11.h41.src.Exceptions.InvalidTokenSequenceException;
import Q3.programming.hue6.src.NatNumToken;
import Q3.programming.hue6.src.Token;
import Q3.programming.hue6.src.BracketOpeningToken;

import java.util.List;

public class FactorParser extends Parser {
    public FactorParser(List<Token> tokens) {
        super(tokens);
    }

    public Factor toExpression() throws InvalidTokenSequenceException {
        checkIfTokenListIsEmpty();
        Token token = _tokens.remove(0);
        if (token instanceof BracketOpeningToken) {
            ExpressionParser exprParser = new ExpressionParser(_tokens);
            BracketExpression bracketExpression = new BracketExpression(exprParser.toExpression());
            _tokens.remove(0);
            return bracketExpression;
        } else if (token instanceof NatNumToken) {
            return new NatNumber(token.toStringRepresentation());
        } else {
            throw new InvalidTokenSequenceException("Unexpected Token in FactorParser!");
        }
    }


}
