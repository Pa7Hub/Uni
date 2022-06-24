package Q3.programming.hue6.src;

public class BracketOpeningToken extends BracketToken {

    public BracketOpeningToken() {
        this.setBracket("(");
    }

    @Override
    public String toStringRepresentation() {
        return this.getBracket();
    }
}
