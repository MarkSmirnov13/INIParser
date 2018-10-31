package Exceptions;

public class FileFormatException extends Exception {

    public FileFormatException(String message) {
        super(message);
    }

    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileFormatException() {
    }

    public FileFormatException(Throwable cause) {
        super(cause);
    }

    public FileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
