package net.druidlabs.cocapi.exampleconfigs;

import net.druidlabs.cocapi.annotation.ApiToken;

/**
 * This class shows an invalid way to create a configuration class.
 * It contains a public String field which is
 * annotated with {@link ApiToken}.
 * <p>However, the field has to be static to be detected.
 *
 * @author Andrew Jones
 * @since 1.0
 * @version 1.0
 * @see ValidConfigClass
 * @see InvalidConfigClassB
 * */

public final class InvalidConfigClassA {

    private InvalidConfigClassA() {
    }

    @ApiToken
    public String apiToken = "sample api key";

}