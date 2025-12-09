package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;
import org.jetbrains.annotations.NotNull;

/**
 * Class to represent the player heroes attribute.
 *
 * @author Andrew Jones
 * @version 1.0
 * @since 1.1.0-beta.3
 */

public final class Hero extends JsonInfoReader {

    /**
     * The hero as an object.
     */

    private final JsonObject hero;

    /**
     * Create a new Hero object with the data from the JsonObject.
     *
     * @param hero the object from which to get information about this hero.
     */

    public Hero(JsonObject hero) {
        this.hero = hero;

        setJsonString("{\"name\": \"hero\"" + numberOfReads + "}");
    }

    @Override
    protected JsonObject data() {
        return hero;
    }

    /**
     * Get the name of the hero.
     *
     * @return the name of the hero or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the{@code name} attribute does not exist in the JSON object.
     */

    public @NotNull String getName() {
        return getStringIfPresent("name");
    }

    /**
     * Get the level of the hero.
     *
     * @return the level or {@code -1}
     * if the {@code level} attribute does not exist.
     */

    public int getLevel() {
        return getIntIfPresent("level");
    }

    /**
     * Get the max level of the hero.
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

    /**
     * Get the equipment used by the hero.
     *
     * @return an array of equipment.
     * Empty if the {@code equipment} attribute
     * cannot be found in the JSON string.
     */

    public HeroEquipment @NotNull [] getHeroEquipment() {
        JsonArray equipment = getJsonArrayIfPresent("equipment");

        HeroEquipment[] heroEquipmentArray = new HeroEquipment[equipment.size()];

        if (heroEquipmentArray.length == 0) {
            return heroEquipmentArray;
        }

        for (int i = 0; i < heroEquipmentArray.length; i++) {
            JsonObject object = equipment.get(i).getAsJsonObject();

            HeroEquipment heroEquipment = new HeroEquipment(object);

            heroEquipmentArray[i] = heroEquipment;
        }

        return heroEquipmentArray;
    }

    /**
     * Class to represent the player hero equipment attribute.
     *
     * @author Andrew Jones
     * @version 1, 0
     * @since 1.1.0-beta.3
     */

    public static final class HeroEquipment extends JsonInfoReader {

        /**
         * The equipment as an object.
         */

        private final JsonObject heroEquipment;

        /**
         * Create a new HeroEquipment object with the data from the JsonObject.
         *
         * @param heroEquipment the object from which to get information about this achievement.
         */

        public HeroEquipment(JsonObject heroEquipment) {
            this.heroEquipment = heroEquipment;

            setJsonString("{\"name\": \"heroEquipment\"" + numberOfReads + "}");
        }

        @Override
        protected JsonObject data() {
            return heroEquipment;
        }

        /**
         * Get the equipment name.
         *
         * @return the name of the equipment or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
         * if the{@code name} attribute does not exist in the JSON object.
         */

        public @NotNull String getName() {
            return getStringIfPresent("name");
        }

        /**
         * Get the level of the equipment.
         *
         * @return the level or {@code -1}
         * if the {@code level} attribute does not exist.
         */

        public int getLevel() {
            return getIntIfPresent("level");
        }

        /**
         * Get the max level of the equipment.
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
}