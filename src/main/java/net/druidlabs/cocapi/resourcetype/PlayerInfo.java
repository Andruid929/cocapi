package net.druidlabs.cocapi.resourcetype;

import net.druidlabs.cocapi.util.JsonCollector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

/**
 * Class for connecting to the player information resource on the Clash of clans
 * API and getting a response as String.
 * Call {@link #getPlayerInfo(String)} to make a request to the server.
 *
 * @author Andrew Jones
 * @version 1.0
 * @see net.druidlabs.cocapi.resourcetype.Info
 * @since 1.0
 */

public final class PlayerInfo extends Info {

    /**
     * The default value that is returned when there is an issue with the API connection.
     */

    public static final String FAILED_DATA = "NULL_DATA";

    private PlayerInfo() {
    }

    /**
     * Connect to the server and request a player's information.
     * <p>Before printing the player information, this method will print out
     * a response code.
     *
     * @param playerId player's unique ID without the #.
     * @return player info as JSON String or {@link #FAILED_DATA NULL_DATA}
     * if anything goes wrong while getting the response.
     * @throws IllegalArgumentException if the {@code playerId} is not 9 characters long.
     */

    @NotNull
    @Contract(pure = true)
    public static String getPlayerInfo(@NotNull String playerId) {
        if (playerId.isBlank() || (playerId.length() != 9)) {

            throw new IllegalArgumentException("Invalid Player ID");
        }

        String resourceUrl = "players/%23".concat(playerId);

        HttpsURLConnection connection = null;

        try {
            connection = apiConnection(resourceUrl);
            connection.connect();

            System.out.println(connection.getResponseCode());

            return JsonCollector.getJsonString(connection.getInputStream());

        } catch (RuntimeException e) {
            System.err.println(e.getCause().getMessage());
            return FAILED_DATA;

        } catch (IOException e) {
            System.err.println("Connection to API encountered an error:");
            System.err.println(e.getMessage());

            if ((connection != null)) {
                System.err.println(JsonCollector.getJsonString(connection.getErrorStream()));
            }

            return FAILED_DATA;

        } finally {
            if (connection != null) {

                connection.disconnect();
            }
        }

    }

}
