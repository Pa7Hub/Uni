package Q3.programming.hue6.src;

public class BracketClosingToken extends BracketToken {

    public BracketClosingToken() {
        this.setBracket(")");
    }

    @Override
    public String toStringRepresentation() {
        return this.getBracket();
    }
}