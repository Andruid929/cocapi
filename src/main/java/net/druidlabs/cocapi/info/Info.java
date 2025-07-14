package net.druidlabs.cocapi.info;

import net.druidlabs.cocapi.annotation.ApiToken;
import net.druidlabs.cocapi.api.Constants;
import net.druidlabs.cocapi.exampleconfigs.InvalidConfigClassA;
import net.druidlabs.cocapi.exampleconfigs.InvalidConfigClassB;
import net.druidlabs.cocapi.exampleconfigs.ValidConfigClass;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * This is the class that declares the logic for sending requests and receiving responses.
 * <p>Clash of clans API requires a JSON token to validate requests.
 * Visit <a href="https://developer.clashofclans.com/">Clash of Clans API</a> to learn how to acquire a token for yourself.
 *
 * <p>If you already have an API token, proceed with:
 * <ol>
 *     <li>In your project folder, create a public Java class with any name you want.</li>
 *     <li>Create a public static String field with any name of your choosing.</li>
 *     <p>This field can be final or not but MUST be public and static
 *     otherwise it will not be detected.
 *     <li>Assign this field to your API token.</li>
 *     <li>Annotate this field with {@link ApiToken}.</li>
 *     <p>This annotation marks the field as the API token which is required for requests.
 * </ol>
 *
 * <p>Here's what the field should look like
 * <blockquote><pre>
 *     &#64;ApiToken
 *     public static final String MY_API_TOKEN = "api.token.here";
 * </pre></blockquote>
 *
 * <p>Any issues with the field annotated as the API token will come back to bite you,
 * so make sure the field is not empty, null and accurately returns your API token.
 * <p>If you have multiple fields annotate with {@code ApiToken},
 * the program will only take the first one it finds and stop there.
 * Field scanning is done from top to bottom.
 *
 * <p>Once you've declared this field, you're done with the configuration class.
 * The only thing left to do is to tell the program what your configuration file is.
 * <p>Call {@link #setConfigurationClass(Class)} and pass in your Java class.
 * It will look something like {@code Info.setConfigurationClass(YourConfigClass.class);}.
 *
 * <p>With that done, you're all set to start making requests.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see ValidConfigClass
 * @see InvalidConfigClassA
 * @see InvalidConfigClassB
 * @since 1.0
 */

public class Info {

    protected static String API_TOKEN;

    protected Info() {
    }

    /**
     * Set the configuration class for this program. This is where your API key resides and is very
     * crucial to the function of this program. Read the documentation of {@link Info this class}
     * for details on how to properly set one up.
     * <p>This method uses the Java reflection API to automatically scan the specified class for
     * a public static String field annotated with {@link ApiToken}.
     *
     * @param configurationClass the class file of your configuration class.
     * @return {@code true} if any public static String field annotated with {@code @ApiToken} is found.
     * So make sure this method this your API token or errors follow.
     * <p>{@code false} if the API token field is private, not static or doesn't exist entirely.
     * */

    public static boolean setConfigurationClass(@NotNull Class<?> configurationClass) {
        String configClassName = configurationClass.getName().concat(".java");

        try {

            for (Field field : configurationClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(ApiToken.class)) {

                    API_TOKEN = (String) field.get(null);
                    return true;
                }

            }

            throw new NoSuchFieldException("No API token field found in " + configClassName);

        } catch (IllegalAccessException e) {
            System.err.println("API token in " + configClassName + " is not accessible, it's most likely private");
            return false;

        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
            return false;

        } catch (NullPointerException e) {
            System.err.println("Cannot find API token field in " + configClassName + ", make sure the field is static");
            return false;
        }
    }

    @NotNull
    protected static HttpsURLConnection apiConnection(@NotNull String resourceUrl) throws IOException {
        final String END_POINT = Constants.BASE_URL + resourceUrl;

        HttpsURLConnection connection;
        try {
            URL endPointUrl = new URI(END_POINT).toURL();

            connection = (HttpsURLConnection) endPointUrl.openConnection();
            connection.setRequestMethod("GET");

            if (API_TOKEN == null) {
                throw new NullPointerException("API token is null");
            }
            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);

            return connection;

        } catch (URISyntaxException e) {
            System.err.println("Encountered error while parsing endpoint, check for issues:");
            System.err.println(e.getMessage());
            throw new RuntimeException();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage() + ", is configuration class set?");
            throw new RuntimeException();
        }
    }
}
