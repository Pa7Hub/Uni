package Q3.programming.hue5.src;

public class Product implements IArithmeticExpression {

    private IArithmeticExpression _factorA;
    private IArithmeticExpression _factorB;

    public Product(IArithmeticExpression factorA, IArithmeticExpression factorB) {
        this._factorA = factorA;
        this._factorB = factorB;
    }

    public Product(int natFactorA, int natFactorB) {
        this._factorA = new NatNumber(natFactorA);
        this._factorB = new NatNumber(natFactorB);
    }

    @Override
    public int evaluate() {
        return this._factorA.evaluate() * this._factorB.evaluate();
    }

    @Override
    public String toString() {
        return this._factorA.toString() + " * " + this._factorB.toString();
    }
}
