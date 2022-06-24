package Q3.programming.hue6.src;

public class NatNumToken extends Token {
    private int _value;

    public NatNumToken(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }

    @Override
    public String toStringRepresentation() {
        return "" + _value;
    }

//    @Override
//    public String toString() {
//        return _value + " " + this.getClass().getSimpleName();
//    }

//    public boolean equals(NatNumToken token) {
//        return this._value == token._value;
//    }
}