package com.violanotes.guimodel.guimodel1.model.exception;

/**
 * Created by pc on 8/11/2017.
 */
public class ConcernEventHandlingException extends Exception {

    public ConcernEventHandlingException() {
        super();
    }

    public ConcernEventHandlingException(String message) {
        super(message);
    }

    public ConcernEventHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConcernEventHandlingException(Throwable cause) {
        super(cause);
    }

    protected ConcernEventHandlingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
