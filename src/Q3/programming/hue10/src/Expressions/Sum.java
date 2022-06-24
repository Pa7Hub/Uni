package Q3.programming.hue10.src.Expressions;

import java.util.Objects;

public class Sum implements IExpression {
    private Summand _summand;
    private IExpression _expression;

    public Sum(Summand summand, IExpression expression) {
        this._summand = summand;
        this._expression = expression;
    }

    @Override
    public Integer evaluate() {
        return this._summand.evaluate() + this._expression.evaluate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum sum = (Sum) o;
        return Objects.equals(_summand, sum._summand) && Objects.equals(_expression, sum._expression);
    }
}
