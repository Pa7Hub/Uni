package Q3.programming.hue6.src;

public abstract class Token {

    public abstract String toStringRepresentation();

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + toStringRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        return (toString().equals(o.toString()));
    }
}
