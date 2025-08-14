package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;
import org.jetbrains.annotations.NotNull;

public final class Spell extends JsonInfoReader {

    private final JsonObject spell;

    public Spell(JsonObject spell) {
        this.spell = spell;

        setJsonString("{\"name:\" \"spell\"" + numberOfReads + "}");
    }

    @Override
    protected JsonObject data() {
        return spell;
    }

    public @NotNull String getName() {
        return getStringIfPresent("name");
    }

    public int getLevel() {
        return getIntIfPresent("level");
    }

    public int getMaxLevel() {
        return getIntIfPresent("maxLevel");
    }

    public @NotNull String getVillage() {
        return getStringIfPresent("village");
    }
}
