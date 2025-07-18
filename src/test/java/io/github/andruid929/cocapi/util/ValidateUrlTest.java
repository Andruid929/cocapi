package io.github.andruid929.cocapi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateUrlTest {

    @Test
    void testTrimming() {
        assertEquals("take/one", ValidateUrl.trimSlashes("/take/one/"));
    }

}