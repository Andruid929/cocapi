package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;

import java.util.Objects;

/**
 * Container for information about a specific troop.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-beta.2
 */

public final class Troop {

    /**
     * An object containing information about a specific troop.
     */

    private final JsonObject troop;

    /**
     * Create a new troop object containing information about the troop.
     *
     * @param troop the object from which to get the information about the troop.
     */

    public Troop(JsonObject troop) {
        this.troop = troop;
    }

    /**
     * Get the name of the troop.
     *
     * @return the name of the troop.
     */

    public String getName() {
        return troop.get("name").getAsString();
    }

    /**
     * Get the troop's level.
     *
     * @return the troop's level.
     */

    public int getLevel() {
        return troop.get("level").getAsInt();
    }

    /**
     * Get the troop's max level.
     *
     * @return the troop's max level.
     */

    public int getMaxLevel() {
        return troop.get("maxLevel").getAsInt();
    }

    /**
     * Get the troop's village.
     *
     * @return the troop's village.
     */

    public String getVillage() {
        return troop.get("village").getAsString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Troop trooper = (Troop) o;
        return Objects.equals(troop, trooper.troop);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(troop);
    }
}
