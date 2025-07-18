package net.druidlabs.cocapi.resourcetype;

import net.druidlabs.cocapi.annotation.ApiToken;
import net.druidlabs.cocapi.exampleconfigs.InvalidConfigClassA;
import net.druidlabs.cocapi.exampleconfigs.InvalidConfigClassB;
import net.druidlabs.cocapi.exampleconfigs.ValidConfigClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testing {@link Info} class.
 *
 * @author Andrew
 * @since 1.0
 * */

public class InfoTest {

    /**
     * This test uses the {@link ValidConfigClass} which has a public static String field annotated
     * with {@link ApiToken}.
     *
     * <p>True is returned because the program is able to detect the field in the class.
     * */

    @Test
    void validClassConfig() {
        assertTrue(Info.setConfigurationClass(ValidConfigClass.class));
    }

    /**
     * This test uses the first {@link InvalidConfigClassA invalid class} which also has a public String field annotated with
     * {@link ApiToken} but this one is not static and as a result, cannot be detected.
     * <p>A {@link NullPointerException} is thrown when {@link Field#get(Object)} tries to get
     * the token field, which is set to be an instance field, on a null param: {@code field.get(null);}.
     *
     * <p>The exception is caught, and the method returns false;
     * */

    @Test
    void invalidClassConfigA() {
        assertFalse(Info.setConfigurationClass(InvalidConfigClassA.class));
    }

    /**
     * This test uses another {@link InvalidConfigClassB invalid class} that has the static String field annotated with the same
     * {@link ApiToken} but this one is private.
     * <p>The program detects the static API token but an {@link IllegalAccessException} is thrown because the program is trying to access a private field
     * from outside the class. While it is possible to access this field by overriding its accessibility,
     * best practices discourage the use of this.
     *
     * <p>The exception is caught and false is returned.</p>
     * */

    @Test
    void invalidClassConfigB() {
        assertFalse(Info.setConfigurationClass(InvalidConfigClassB.class));
    }
}