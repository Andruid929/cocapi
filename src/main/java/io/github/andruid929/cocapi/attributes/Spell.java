package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;
import org.jetbrains.annotations.NotNull;

/**
 * Class to represent the player spells attribute.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-beta.3
 */

public final class Spell extends JsonInfoReader {

    /**
     * The spell as an object.
     */

    private final JsonObject spell;

    /**
     * Create a new Spell object with the data from the JsonObject.
     *
     * @param spell the object from which to get information about this spell.
     */

    public Spell(JsonObject spell) {
        this.spell = spell;

        setJsonString("{\"name:\" \"spell\"" + numberOfReads + "}");
    }

    @Override
    protected JsonObject data() {
        return spell;
    }

    /**
     * Get the name of the spell.
     *
     * @return the name of the spell or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the{@code spell} attribute does not exist in the JSON object.
     */

    public @NotNull String getName() {
        return getStringIfPresent("name");
    }

    /**
     * Get the level of the spell.
     *
     * @return the level or {@code -1}
     * if the {@code level} attribute does not exist.
     */

    public int getLevel() {
        return getIntIfPresent("level");
    }

    /**
     * Get the max level of the spell.
     *
     * @return the max level or {@code -1}
     * if the {@code maxLevel} attribute does not exist.
     */

    public int getMaxLevel() {
        return getIntIfPresent("maxLevel");
    }

    /**
     * Get the name of the village.
     *
     * @return the name of the village or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the{@code village} attribute does not exist in the JSON object.
     */

    public @NotNull String getVillage() {
        return getStringIfPresent("village");
    }
}
