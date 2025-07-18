package io.github.andruid929.cocapi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation marks a field as an API token.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ApiToken {
}
