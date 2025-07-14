package net.druidlabs.cocapi.info;

import net.druidlabs.cocapi.util.InputStreamCollector;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;

public final class PlayerInfo extends Info {

    private PlayerInfo() {
    }

    @Contract(pure = true)
    public static String getPlayerInfo(@NotNull String playerId) {
        if (playerId.isBlank() || (playerId.length() != 9)) {

            throw new IllegalArgumentException("Invalid Player ID length");
        }

        String resourceUrl = "players/%23".concat(playerId);

        HttpsURLConnection connection = null;

        try {
            connection = apiConnection(resourceUrl);
            connection.connect();

            InputStream dataStream = connection.getInputStream();

            return InputStreamCollector.collectStreamData(dataStream);

        } catch (RuntimeException e) {
            return null;

        } catch (IOException e) {
            System.err.println("Connection to API encountered an error:");
            System.err.println(e.getMessage());

            if ((connection != null)) {
                System.err.println(InputStreamCollector.collectStreamData(connection.getErrorStream()));
            }

            return null;

        } finally {
            if (connection != null) {

                connection.disconnect();
            }
        }

    }

}
