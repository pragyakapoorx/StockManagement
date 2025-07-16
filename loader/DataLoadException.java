package org.manipal.oops.proj.trade.loader;

public class DataLoadException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -9025123098360311266L;

    public DataLoadException() {
    }

    public DataLoadException(String message) {
        super(message);
    }

    public DataLoadException(Throwable cause) {
        super(cause);
    }

    public DataLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
