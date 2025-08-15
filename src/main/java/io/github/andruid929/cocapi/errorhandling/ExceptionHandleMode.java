package io.github.andruid929.cocapi.errorhandling;

public enum ExceptionHandleMode {

    /**
     * Print error message to terminal, return default value.
     * */

    LOG(0),

    /**
     * Don't return a value, throw the exception.
     * */

    THROW(1),

    /**
     * Return default value, no log, no exception.
     * */

    SILENT(2);

    /**
     * The exception handling mode.
     * */

    private final int mode;

    ExceptionHandleMode(int mode) {
        this.mode = mode;
    }

    /**
     * Get the exception handle mode specified by the constant.
     *
     * @return the handling mode.
     * */

    public int getMode() {
        return mode;
    }
}
