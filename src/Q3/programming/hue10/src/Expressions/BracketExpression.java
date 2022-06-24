package Q3.programming.hue10.src.Expressions;

import java.util.Objects;

public class BracketExpression implements Factor {
    IExpression _expression;

    public BracketExpression(IExpression expression) {
        _expression = expression;
    }

    @Override
    public Integer evaluate() {
        return _expression.evaluate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BracketExpression bracket1 = (BracketExpression) o;
        return Objects.equals(_expression, bracket1._expression);
    }
}
