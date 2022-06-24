package Q3.programming.hue10.src.Parser;

import Q3.programming.hue10.src.Expressions.Factor;
import Q3.programming.hue10.src.Expressions.Product;
import Q3.programming.hue10.src.Expressions.Summand;
import Q3.programming.hue11.h41.src.Exceptions.InvalidTokenSequenceException;
import Q3.programming.hue6.src.Token;
import Q3.programming.hue6.src.OperatorProductToken;

import java.util.List;

public class SummandParser extends Parser {
    public SummandParser(List<Token> tokens) {
        super(tokens);
    }

    public Summand toExpression() throws InvalidTokenSequenceException {
        Factor factor = new FactorParser(this._tokens).toExpression();
        if (!_tokens.isEmpty() && _tokens.get(0) instanceof OperatorProductToken) {
            _tokens.remove(0);
            Summand sum = this.toExpression();
            return new Product(factor, sum);
        } else {
            return factor;
        }
    }
}