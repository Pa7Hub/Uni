package Q3.programming.hue10.src.Parser;

import Q3.programming.hue10.src.Expressions.IExpression;
import Q3.programming.hue10.src.Expressions.Sum;
import Q3.programming.hue10.src.Expressions.Summand;
import Q3.programming.hue11.h41.src.Exceptions.InvalidTokenSequenceException;
import Q3.programming.hue6.src.Token;
import Q3.programming.hue6.src.OperatorSumToken;

import java.util.List;

public class ExpressionParser extends Parser {
    public ExpressionParser(List<Token> tokens) {
        super(tokens);
    }

    public IExpression toExpression() throws InvalidTokenSequenceException {
        checkIfTokenListIsEmpty();
        SummandParser sumParser = new SummandParser(_tokens);
        Summand sum = sumParser.toExpression();
        if (!_tokens.isEmpty() && _tokens.get(0) instanceof OperatorSumToken) {
            _tokens.remove(0);
            IExpression expr = this.toExpression();
            return new Sum(sum, expr);
        } else {
            return sum;
        }
    }
}