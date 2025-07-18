package io.github.andruid929.cocapi.information;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.andruid929.cocapi.attributes.Achievement;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing all information about a specific player.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-alpha.1
 * */

public final class Player {

    private final String jsonString;

    public Player(String jsonString) {
        this.jsonString = jsonString;
    }

    /**
     * Parses the jsonString.
     *
     * @return a code ready component.
     * */

    private JsonObject data() {
        return JsonParser.parseString(jsonString).getAsJsonObject();
    }

    /**
     * Get the player's tag. By default, this method returns
     * the tag with the {@code #}.
     *
     * @param getWithoutHashTag get the player tag without the leading
     *                          hashtag.
     * @return the player's ID.
     * */

    public String getTag(boolean getWithoutHashTag) {
        String tag = data().get("tag").getAsString();

        if (getWithoutHashTag) {
            return tag.substring(1);
        }


        return tag;
    }

    public String getName() {
        return data().get("name").getAsString();
    }

    public int getTownHallLevel() {
        return data().get("townHallLevel").getAsInt();
    }

    public int getExpLevel() {
        return data().get("expLevel").getAsInt();
    }

    public int getTrophies() {
        return data().get("trophies").getAsInt();
    }

    public int getBestTrophies() {
        return data().get("bestTrophies").getAsInt();
    }

    public int getWarStars() {
        return data().get("warStars").getAsInt();
    }

    public int getAttackWins() {
        return data().get("attackWins").getAsInt();
    }

    public int getDefenseWins() {
        return data().get("defenseWins").getAsInt();
    }

    public int getBuilderBaseTrophies() {
        return data().get("builderBaseTrophies").getAsInt();

    }

    public int getBestBuilderBaseTrophies() {
        return data().get("bestBuilderBaseTrophies").getAsInt();
    }

    public int getDonations() {
        return data().get("donations").getAsInt();
    }

    public int getDonationsReceived() {
        return data().get("donationsReceived").getAsInt();
    }

    public int getClanCapitalContributions() {
        return data().get("clanCapitalContributions").getAsInt();
    }
}
