package Q3.programming.hue6.src;

public class OperatorProductToken extends OperatorToken {

    public OperatorProductToken() {
        this.setOperator("*");
    }

    @Override
    public String toStringRepresentation() {
        return this.getOperator();
    }
}
