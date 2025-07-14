package net.druidlabs.cocapi.exampleconfigs;

import net.druidlabs.cocapi.annotation.ApiToken;

/**
 * This class shows the proper way to create a configuration class.
 * It contains a public static String field which can be final or not as long as
 * it is annotated with {@link ApiToken}.
 *
 * @author Andrew Jones
 * @since 1.0
 * @version 1.0
 * */

public final class ValidConfigClass {

    private ValidConfigClass() {
    }

    @ApiToken
    public static String foo123 = "sample api key";

}