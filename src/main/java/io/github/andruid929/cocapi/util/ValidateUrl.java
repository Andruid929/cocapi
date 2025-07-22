package io.github.andruid929.cocapi.util;

import org.jetbrains.annotations.NotNull;

/**
 * Utility class for validating or correcting URLs.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.0
 */

public final class ValidateUrl {

    /**
     * Utility classes cannot be instantiated.
     */

    private ValidateUrl() {
    }

    /**
     * Trims out any leading or trailing slashes.
     *
     * @param url the URL to be trimmed.
     * @return {@code url} without any leading or trailing slashes.
     */

    public static @NotNull String trimSlashes(@NotNull String url) {
        String leading = trimLeadingSlash(url);

        return trimTrailingSlash(leading);
    }

    /**
     * Trims out any trailing slashes.
     *
     * @param url the URL to be trimmed.
     * @return {@code url} without trailing slashes.
     */

    public static @NotNull String trimTrailingSlash(@NotNull String url) {
        if (url.endsWith("/")) {

            return url.substring(0, url.length() - 1);
        }

        return url;
    }

    /**
     * Trims out any leading slashes.
     *
     * @param url the URL to be trimmed.
     * @return {@code url} without any leading slashes.
     */

    public static @NotNull String trimLeadingSlash(@NotNull String url) {
        if (url.startsWith("/")) {

            return url.substring(1);
        }

        return url;
    }
}
