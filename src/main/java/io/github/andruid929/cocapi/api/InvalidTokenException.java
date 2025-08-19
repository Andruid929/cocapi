package io.github.andruid929.cocapi.api;

/**
 * Exception to be thrown when there is an issue with the API token.
 *
 * @since 1.1.0;
 * @version 1.0
 * @author Andrew Jones
 * */

public class InvalidTokenException extends IllegalStateException {

    /**
     * Throw new exception with a custom breakpoint message.
     *
     * @param s breakpoint message.
     * */

    public InvalidTokenException(String s) {
        super(s);
    }
}
