package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;

import java.util.Objects;

/**
 * Class to represent a player's achievements.
 *
 * @author Andrew Jones
 * @version 1, 0
 * @since 1.1.0-beta.2
 */

public final class Achievement {

    /**
     * The achievement as an object.
     */

    private final JsonObject achievement;

    /**
     * Create a new Achievement object with the data from the JsonObject.
     *
     * @param achievement the object from which to get information about this achievement.
     */

    public Achievement(JsonObject achievement) {
        this.achievement = achievement;
    }

    /**
     * Get the name of the achievement.
     *
     * @return the name of the achievement.
     */

    public String getName() {
        return achievement.get("name").getAsString();
    }

    /**
     * Get the number of stars.
     *
     * @return the number of stars.
     */

    public int getStars() {
        return achievement.get("stars").getAsInt();
    }

    /**
     * Get the value of the achievement.
     *
     * @return the value.
     */

    public int getValue() {
        return achievement.get("value").getAsInt();
    }

    /**
     * Get the target.
     *
     * @return the target.
     */

    public int getTarget() {
        return achievement.get("target").getAsInt();
    }

    /**
     * Get the information about the achievement.
     *
     * @return the information about the achievement.
     */

    public String getInfo() {
        return achievement.get("info").getAsString();
    }

    /**
     * Get the completion information.
     *
     * @return the information on how this achievement was achieved.
     */

    public String getCompletionInfo() {
        return achievement.get("completionInfo").getAsString();
    }

    /**
     * Get the village name.
     *
     * @return the name of the village.
     */

    public String getVillage() {
        return achievement.get("village").getAsString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Achievement that = (Achievement) o;
        return Objects.equals(achievement, that.achievement);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(achievement);
    }
}
