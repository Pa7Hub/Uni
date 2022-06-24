package Q3.programming.hue5.src;

public class BracketExpression implements IArithmeticExpression {

    private IArithmeticExpression _bracketExpression;

    public BracketExpression(IArithmeticExpression bracketExpression) {
        this._bracketExpression = bracketExpression;
    }

    public BracketExpression(int bracketNatNumber) {
        this._bracketExpression = new NatNumber(bracketNatNumber);
    }

    @Override
    public int evaluate() {
        return this._bracketExpression.evaluate();
    }

    @Override
    public String toString() {
        return "(" + this._bracketExpression.toString() + ")";
    }

}
