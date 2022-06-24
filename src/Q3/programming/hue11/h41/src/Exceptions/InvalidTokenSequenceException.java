package Q3.programming.hue11.h41.src.Exceptions;

public class InvalidTokenSequenceException extends ParserException {
    public InvalidTokenSequenceException(String message) {
        super(message);
    }

    public InvalidTokenSequenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
