package Q3.programming.hue6.src;

public abstract class OperatorToken extends Token {
    private String _operator;

    public void setOperator(String operator) {
        _operator = operator;
    }

    public String getOperator() {
        return _operator;
    }

    @Override
    public String toStringRepresentation() {
        return getOperator();
    }

//    @Override
//    public String toString() {
//        return getOperator() + " " + this.getClass().getSimpleName();
//    }

//    public boolean equals(Object token) {
//        return token instanceof OperatorToken
//                && ((OperatorToken) token).equals(this.getOperator());
//    }
}