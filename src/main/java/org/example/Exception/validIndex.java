package org.example.Exception;

public class validIndex extends RuntimeException {
    public validIndex() {
    }

    public validIndex(String message) {
        super(message);
    }

    public validIndex(String message, Throwable cause) {
        super(message, cause);
    }

    public validIndex(Throwable cause) {
        super(cause);
    }

    public validIndex(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
