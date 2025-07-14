package net.druidlabs.cocapi.exampleconfigs;

import net.druidlabs.cocapi.annotation.ApiToken;

/**
 * This class shows an invalid way to create a configuration class.
 * It contains a static String field annotated with {@link ApiToken}
 * but has a {@code private} access modifier.
 *
 * @author Andrew Jones
 * @since 1.0
 * @version 1.0
 * @see ValidConfigClass
 * @see InvalidConfigClassA
 * */

public final class InvalidConfigClassB {

    private InvalidConfigClassB() {
    }

    @ApiToken
    private static String apiToken = "sample api key";

}