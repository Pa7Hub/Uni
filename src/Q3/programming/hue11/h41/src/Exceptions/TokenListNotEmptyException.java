package Q3.programming.hue11.h41.src.Exceptions;


public class TokenListNotEmptyException extends ParserException {
    public TokenListNotEmptyException(String message) {
        super(message);
    }

    public TokenListNotEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
