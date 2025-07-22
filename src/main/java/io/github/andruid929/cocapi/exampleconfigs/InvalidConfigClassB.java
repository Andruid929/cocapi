package io.github.andruid929.cocapi.exampleconfigs;

import io.github.andruid929.cocapi.annotation.ApiToken;

/**
 * This class shows an invalid way to create a configuration class.
 * It contains a static String field annotated with {@link ApiToken}
 * but has a {@code private} access modifier.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see ValidConfigClass
 * @see InvalidConfigClassA
 * @since 1.0
 */

public final class InvalidConfigClassB {

    /**
     * Utility classes cannot be instantiated.
     */

    private InvalidConfigClassB() {
    }

    /**
     * API tokens should not be private
     */

    @ApiToken
    private static String woofWoof = "sample api key";

}