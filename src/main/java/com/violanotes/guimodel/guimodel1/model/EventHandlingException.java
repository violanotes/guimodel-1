package com.violanotes.guimodel.guimodel1.model;

/**
 * Created by pc on 8/11/2017.
 */
public class EventHandlingException extends Exception {

    public EventHandlingException() {
        super();
    }

    public EventHandlingException(String message) {
        super(message);
    }

    public EventHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventHandlingException(Throwable cause) {
        super(cause);
    }

    protected EventHandlingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
