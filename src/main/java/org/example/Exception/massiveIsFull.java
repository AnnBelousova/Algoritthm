package org.example.Exception;

public class massiveIsFull extends RuntimeException {
    public massiveIsFull() {
    }

    public massiveIsFull(String message) {
        super(message);
    }

    public massiveIsFull(String message, Throwable cause) {
        super(message, cause);
    }

    public massiveIsFull(Throwable cause) {
        super(cause);
    }

    public massiveIsFull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
