package io.github.andruid929.cocapi;

import io.github.andruid929.cocapi.information.JsonInfoReader;

/**
 * Utility class for holding constants used in tests
 *
 * @author Andrew Jones
 * @since 1.1.0-beta.2
 * @version 1.0
 * */

public final class TestConstants {

    /**
     * The name of the sample response.
     * */

    public static final String SAMPLE_PLAYER_INFO_RESPONSE_FILENAME = "Sample player_info response.json";

    private TestConstants() {
    }

    public static boolean isToStringCorrect(JsonInfoReader attributeReader) {
        String toString = attributeReader.toString();

        return toString.startsWith("{") && toString.endsWith("}");
    }
}
