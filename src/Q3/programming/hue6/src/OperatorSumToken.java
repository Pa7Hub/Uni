package Q3.programming.hue6.src;

public class OperatorSumToken extends OperatorToken {

    public OperatorSumToken() {
        this.setOperator("+");
    }

    @Override
    public String toStringRepresentation() {
        return this.getOperator();
    }
}
