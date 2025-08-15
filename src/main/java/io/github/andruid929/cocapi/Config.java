package io.github.andruid929.cocapi;

import io.github.andruid929.cocapi.errorhandling.ExceptionHandleMode;

public final class Config {

    private static ExceptionHandleMode mode;

    private Config() {
    }

    public static void setExceptionHandlingMode(ExceptionHandleMode newMode) {
        mode = newMode;
    }

    public static int getExceptionHandleMode() {
        if (mode == null) {
            return ExceptionHandleMode.LOG.getMode();
        }

        return mode.getMode();
    }
}
