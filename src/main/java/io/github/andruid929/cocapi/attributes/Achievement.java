package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;

import java.util.Objects;

/**
 * Class to represent the player achievements attribute.
 *
 * @author Andrew Jones
 * @version 1, 0
 * @since 1.1.0-beta.2
 */

public final class Achievement extends JsonInfoReader {

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

        setJsonString("{ \"name\": \"Achievement\"" + numberOfReads + "}");
    }

    @Override
    protected JsonObject data() {
        return achievement;
    }

    /**
     * Get the name of the achievement.
     *
     * @return the name of the achievement or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the{@code name} attribute does not exist in the JSON object.
     */

    public String getName() {
        return getStringIfPresent("name");
    }

    /**
     * Get the number of stars.
     *
     * @return the number of stars or {@code -1}
     * if the {@code stars} attribute does not exist.
     */

    public int getStars() {
        return getIntIfPresent("stars");
    }

    /**
     * Get the value of the achievement.
     *
     * @return the value or {@code -1}
     * if the {@code value} attribute does not exist.
     */

    public int getValue() {
        return getIntIfPresent("value");
    }

    /**
     * Get the target.
     *
     * @return the target or {@code -1}
     * if the {@code target} attribute does not exist.
     */

    public int getTarget() {
        return getIntIfPresent("target");
    }

    /**
     * Get the information about the achievement.
     *
     * @return the information about the achievement or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the {@code info} attribute cannot be found in the JSON string.
     */

    public String getInfo() {
        return getStringIfPresent("info");
    }

    /**
     * Get the completion information.
     *
     * @return the information on how this achievement was achieved or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the {@code completionInfo} attribute cannot be found in the JSON string.
     */

    public String getCompletionInfo() {
        return getStringIfPresent("completionInfo");
    }

    /**
     * Get the village name.
     *
     * @return the name of the village or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the {@code village} attribute cannot be found in the JSON string.
     */

    public String getVillage() {
        return getStringIfPresent("village");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Achievement that = (Achievement) o;

        return Objects.equals(achievement, that.achievement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), achievement);
    }
}
