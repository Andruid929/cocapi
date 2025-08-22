package io.github.andruid929.cocapi.resourcetype;

import io.github.andruid929.cocapi.Config;
import io.github.andruid929.cocapi.annotation.ApiToken;
import io.github.andruid929.cocapi.api.Constants;
import io.github.andruid929.cocapi.api.InvalidTokenException;
import io.github.andruid929.cocapi.exampleconfigs.InvalidConfigClassA;
import io.github.andruid929.cocapi.exampleconfigs.InvalidConfigClassB;
import io.github.andruid929.cocapi.exampleconfigs.ValidConfigClass;
import io.github.andruid929.cocapi.util.ValidateUrl;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * This is the class that declares the logic for sending requests.
 * <p>Clash of clans API requires a JSON token to validate requests.
 * Visit <a href="https://developer.clashofclans.com/">Clash of Clans API</a> to learn how to acquire a token for yourself.
 *
 * <p>If you already have an API token, proceed with:
 * <ol>
 *     <li>In your project folder, create a public Java class with any name you want.</li>
 *     <li>Create a {@code public static String} field with any name of your choosing.
 *     This field can be {@code final} or not but MUST be {@code public} and {@code static}
 *     otherwise it will not be detected.</li>
 *     <li>Assign this field to your API token.</li>
 *     <li>Annotate this field with {@link ApiToken}.
 *     This annotation marks the field as the API token which is required for requests.</li>
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
 * <p>Call {@link Config#setConfigurationClass(Class)} and pass in your Java class.
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

    /**
     * Utility classes cannot be instantiated.
     */

    protected Info() {
    }

    /**
     * Establish a {@code GET} request connection to the specified endpoint.
     * <p>This does require you to have an API token set in a configuration class.
     * See {@link Info here} to learn how to set one up.
     *
     * @param resourceUrl the url to the resource required.
     *                    Trailing and leading slashes will automatically be removed.
     * @return a connection to the API endpoint specified complete with an HTTPS header containing the authorisation JSON token.
     * @throws IOException if any I/O error occurs during the connection.
     */

    @NotNull
    protected static HttpsURLConnection apiConnection(@NotNull String resourceUrl) throws IOException {
        final String END_POINT = Constants.BASE_URL + ValidateUrl.trimSlashes(resourceUrl);

        final String API_TOKEN = Config.getApiToken();

        HttpsURLConnection connection;

        try {
            URL endPointUrl = new URI(END_POINT).toURL();

            connection = (HttpsURLConnection) endPointUrl.openConnection();
            connection.setRequestMethod("GET");

            if (API_TOKEN.isEmpty()) {
                throw new InvalidTokenException("API token is empty");
            }

            connection.setRequestProperty("Authorization", "Bearer " + API_TOKEN);

            return connection;

        } catch (URISyntaxException e) {
            if (Config.getExceptionHandleMode() != 1) {

                System.err.println("Encountered error while parsing endpoint, check for issues:");
                System.err.println(e.getMessage());
            }


            throw new RuntimeException(e);

        } catch (InvalidTokenException e) {
            System.err.println(e.getMessage() + ", is configuration class set?");

            throw new RuntimeException(e);
        }
    }
}
