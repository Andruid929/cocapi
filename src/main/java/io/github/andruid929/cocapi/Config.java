package io.github.andruid929.cocapi;

import io.github.andruid929.cocapi.annotation.ApiToken;
import io.github.andruid929.cocapi.errorhandling.ExceptionHandleMode;
import io.github.andruid929.cocapi.resourcetype.Info;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

/**
 * Class to set and get global configurations for the API.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-beta.3
 */

public final class Config {

    /**
     * The mode of handling caught exceptions.
     */

    private static ExceptionHandleMode mode;

    private static String apiToken;

    private Config() {
    }

    /**
     * Set the configuration class for this program.
     * This is where your API key resides and is very
     * crucial to the function of this program.
     * Read the documentation of {@link Info this class}
     * for details on how to properly set one up.
     * <p>This method uses the Java reflection API to automatically scan the specified class for
     * a public static String field annotated with {@link ApiToken}.
     *
     * @param configurationClass the class file of your configuration class.
     * @return {@code true} if any public static String field annotated with {@code @ApiToken} is found.
     * So make sure this method is your API token or errors follow.
     * <p>{@code false} if the API token field is private, not static or doesn't exist entirely.
     */

    public static boolean setConfigurationClass(@NotNull Class<?> configurationClass) {
        String configClassName = configurationClass.getName().concat(".java");

        try {

            for (Field field : configurationClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(ApiToken.class)) {

                    apiToken = (String) field.get(null);
                    return true;
                }

            }

            throw new NoSuchFieldException("No API token field found in " + configClassName);

        } catch (IllegalAccessException e) {
            if (Config.getExceptionHandleMode() != 2) {

                System.err.println("API token in " + configClassName + " is not accessible, it's most likely private");
            }

            return false;

        } catch (NoSuchFieldException e) {
            if (Config.getExceptionHandleMode() != 2) {

                System.err.println(e.getMessage());
            }

            return false;

        } catch (NullPointerException e) {
            if (Config.getExceptionHandleMode() != 2) {

                System.err.println("Cannot find API token field in " + configClassName + ", make sure the field is static");
            }

            return false;
        }
    }

    /**
     * Set the global exception handling mode.
     *
     * @param newMode the updated {@link ExceptionHandleMode exception handling mode}.
     */

    public static void setExceptionHandlingMode(ExceptionHandleMode newMode) {
        mode = newMode;
    }

    /**
     * Get the exception handling mode, will default to {@link ExceptionHandleMode#LOG}.
     *
     * @return the exception handling mode.
     */

    public static int getExceptionHandleMode() {
        if (mode == null) {
            return ExceptionHandleMode.LOG.getMode();
        }

        return mode.getMode();
    }

    public static @NotNull String getApiToken() {
        if (apiToken == null) {
            return "";
        }

        return apiToken;
    }
}
