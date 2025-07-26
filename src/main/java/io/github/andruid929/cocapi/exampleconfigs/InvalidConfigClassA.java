package io.github.andruid929.cocapi.exampleconfigs;

import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.annotation.ApiToken;
import io.github.andruid929.cocapi.attributes.Troop;
import io.github.andruid929.cocapi.information.Player;

/**
 * This class shows an invalid way to create a configuration class.
 * It contains a public String field which is
 * annotated with {@link ApiToken}.
 * <p>However, the field has to be static to be detected.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see ValidConfigClass
 * @see InvalidConfigClassB
 * @since 1.0
 */

public final class InvalidConfigClassA {

    /**
     * Utility classes cannot be instantiated...
     */

    private InvalidConfigClassA() {
    }

    /**
     * API tokens should be static
     */

    @ApiToken
    public String apiToken = "sample api key";

}