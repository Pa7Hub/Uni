package Q3.programming.hue6.src;

public abstract class BracketToken extends Token {
    private String _bracket;

    public String getBracket() {
        return _bracket;
    }

    public void setBracket(String bracket) {
        _bracket = bracket;
    }

    @Override
    public String toStringRepresentation() {
        return getBracket();
    }

//    @Override
//    public String toString() {
//        return getBracket() + " " + this.getClass().getSimpleName();
//    }

//    public boolean equals(Object token) {
//        return token instanceof BracketToken
//                && ((BracketToken) token).equals(this.getBracket());
//    }
}