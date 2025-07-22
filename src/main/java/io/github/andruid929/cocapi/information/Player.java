package io.github.andruid929.cocapi.information;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.andruid929.cocapi.attributes.Achievement;
import io.github.andruid929.cocapi.attributes.Troop;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Class containing all information about a specific player.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-alpha.1
 */

public final class Player {

    private final String jsonString;

    /**
     * Create a new instance of and populate fields.
     *
     * @param jsonString the player information JSON response as a String.
     * */

    public Player(String jsonString) {
        this.jsonString = jsonString;
    }

    /**
     * Parses the jsonString.
     *
     * @return a code ready component.
     */

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
     */

    public String getTag(boolean getWithoutHashTag) {
        String tag = data().get("tag").getAsString();

        if (getWithoutHashTag) {
            return tag.substring(1);
        }


        return tag;
    }

    /**
     * Get the in-game name of the player.
     *
     * @return the name of the player.
     * */

    public String getName() {
        return data().get("name").getAsString();
    }

    /**
     * Get the player's town hall level
     *
     * @return the player's town hall level
     * */

    public int getTownHallLevel() {
        return data().get("townHallLevel").getAsInt();
    }

    /**
     * Get the player's experience level.
     *
     * @return the player's experience level.
     * */

    public int getExpLevel() {
        return data().get("expLevel").getAsInt();
    }

    /**
     * Get the number the trophies the player has.
     *
     * @return the number of trophies.
     * */

    public int getTrophies() {
        return data().get("trophies").getAsInt();
    }

    /**
     * Get the number of best trophies the player has.
     *
     * @return the number of best trophies.
     * */

    public int getBestTrophies() {
        return data().get("bestTrophies").getAsInt();
    }

    /**
     * Get the player's number of war stars.
     *
     * @return the number of war stars.
     * */

    public int getWarStars() {
        return data().get("warStars").getAsInt();
    }

    /**
     * Get the player's number of wins attacking.
     *
     * @return the number of attack wins.
     * */

    public int getAttackWins() {
        return data().get("attackWins").getAsInt();
    }

    /**
     * The player's number of wins defending
     *
     * @return the number of defense wins.
     * */

    public int getDefenseWins() {
        return data().get("defenseWins").getAsInt();
    }

    /**
     * Get the player's number of builder base trophies.
     *
     * @return the number of builder base trophies.
     * */

    public int getBuilderBaseTrophies() {
        return data().get("builderBaseTrophies").getAsInt();

    }

    /**
     * Get the player's number of best builder base trophies.
     *
     * @return the number of best builder base trophies.
     * */

    public int getBestBuilderBaseTrophies() {
        return data().get("bestBuilderBaseTrophies").getAsInt();
    }

    /**
     * Get the number of donations sent by the player.
     *
     * @return the number of donations.
     * */

    public int getDonations() {
        return data().get("donations").getAsInt();
    }

    /**
     * Get the number of donations received by the player.
     *
     * @return the number of donations received.
     * */

    public int getDonationsReceived() {
        return data().get("donationsReceived").getAsInt();
    }

    /**
     * Get the number of contributions the player has made to the clan capital.
     *
     * @return the number of contributions.
     * */

    public int getClanCapitalContributions() {
        return data().get("clanCapitalContributions").getAsInt();
    }

    /**
     * Get what the player has achieved.
     *
     * @return an array of achievements.
     * */

    public @NotNull Achievement[] getAchievements() {
        JsonArray achievements = data().get("achievements").getAsJsonArray();

        Achievement[] achievementArray = new Achievement[achievements.size()];

        for (int i = 0; i < achievementArray.length; i++) {
            JsonObject achievementObject = achievements.get(i).getAsJsonObject();

            Achievement achievement = new Achievement(achievementObject);

            achievementArray[i] = achievement;
        }

        return achievementArray;
    }

    /**
     * Get the troops owned by the player.
     *
     * @return an array of troops.
     * */

    public @NotNull Troop[] getTroops() {
        JsonArray troops = data().get("troops").getAsJsonArray();

        Troop[] troopArray = new Troop[troops.size()];

        for (int i = 0; i < troopArray.length; i++) {
            JsonObject troopObject = troops.get(i).getAsJsonObject();

            Troop troop = new Troop(troopObject);

            troopArray[i] = troop;
        }

        return troopArray;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(jsonString, player.jsonString);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(jsonString);
    }
}
