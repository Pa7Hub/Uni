package Q3.programming.hue5.src;

public class NatNumber implements IArithmeticExpression {
    private int value;

    public NatNumber(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return ""+value;
    }

}
