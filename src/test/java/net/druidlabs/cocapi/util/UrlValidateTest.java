package net.druidlabs.cocapi.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlValidateTest {

    @Test
    void testTrimming() {
        assertEquals("take/one", UrlValidate.trimSlashes("/take/one/"));
    }

}