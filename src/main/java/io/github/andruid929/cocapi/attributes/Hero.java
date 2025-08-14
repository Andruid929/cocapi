package io.github.andruid929.cocapi.attributes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.information.JsonInfoReader;
import org.jetbrains.annotations.NotNull;

public class Hero extends JsonInfoReader {

    private final JsonObject hero;

    public Hero(JsonObject hero) {
        this.hero = hero;

        setJsonString("{\"name\": \"hero\"" + numberOfReads + "}");
    }

    @Override
    protected JsonObject data() {
        return hero;
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

    public static final class HeroEquipment extends JsonInfoReader {

        private final JsonObject heroEquipment;

        public HeroEquipment(JsonObject heroEquipment) {
            this.heroEquipment = heroEquipment;

            setJsonString("{\"name\": \"heroEquipment\"" + numberOfReads + "}");
        }

        @Override
        protected JsonObject data() {
            return heroEquipment;
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
}