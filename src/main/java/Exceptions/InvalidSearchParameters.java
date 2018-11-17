package Exceptions;

public class InvalidSearchParameters extends Exception {
    public InvalidSearchParameters() {
    }

    public InvalidSearchParameters(String message) {
        super(message);
    }

    public InvalidSearchParameters(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSearchParameters(Throwable cause) {
        super(cause);
    }

    public InvalidSearchParameters(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
