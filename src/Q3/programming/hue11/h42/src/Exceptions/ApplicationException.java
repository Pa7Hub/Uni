package Q3.programming.hue11.h42.src.Exceptions;

public class ApplicationException extends Exception {

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message) {
        super(message);
    }

}
