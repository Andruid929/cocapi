package io.github.andruid929.cocapi.information;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.andruid929.cocapi.attributes.*;
import org.jetbrains.annotations.NotNull;

/**
 * Class containing all information about a specific player.
 *
 * @author Andrew Jones
 * @version 2.0
 * @see io.github.andruid929.cocapi.information.JsonInfoReader
 * @since 1.1.0-alpha.1
 */

public final class Player extends JsonInfoReader {

    /**
     * Create a new instance.
     *
     * @param jsonString the player information JSON response as a String.
     */

    public Player(String jsonString) {
        setJsonString(jsonString);
    }

    /**
     * Get the player's tag. By default, this method returns
     * the tag with the leading {@code #}.
     *
     * @param getWithoutHashTag get the player tag without the leading
     *                          {@code #}.
     * @return the player's ID or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the {@code tag} attribute cannot be found in the JSON string.
     */

    public String getTag(boolean getWithoutHashTag) {
        String tag = getStringIfPresent("tag");

        if (!tag.startsWith("#")) {
            return tag;
        }

        if (getWithoutHashTag) {
            return tag.substring(1);
        }

        return tag;
    }

    /**
     * Get the in-game name of the player.
     *
     * @return the name of the player or {@link JsonInfoReader#NON_EXISTENT_ATTRIBUTE NON-EXISTENT ATTRIBUTE}
     * if the {@code name} attribute cannot be found in the JSON string.
     */

    public String getName() {
        return getStringIfPresent("name");
    }

    /**
     * Get the player's town hall level
     *
     * @return the player's town hall level or {@code -1}
     * if the {@code townHallLevel} attribute cannot be found in the JSON string.
     */

    public int getTownHallLevel() {
        return getIntIfPresent("townHallLevel");
    }

    /**
     * Get the player's experience level.
     *
     * @return the player's experience level or {@code -1}
     * if the {@code expLevel} attribute cannot be found in the JSON string.
     */

    public int getExpLevel() {
        return getIntIfPresent("expLevel");
    }

    /**
     * Get the number the trophies the player has.
     *
     * @return the number of trophies or {@code -1}
     * if the {@code trophies} attribute cannot be found in the JSON string.
     */

    public int getTrophies() {
        return getIntIfPresent("trophies");
    }

    /**
     * Get the number of best trophies the player has.
     *
     * @return the number of best trophies or {@code -1}
     * if the {@code bestTrophies} attribute cannot be found in the JSON string.
     */

    public int getBestTrophies() {
        return getIntIfPresent("bestTrophies");
    }

    /**
     * Get the player's number of war stars.
     *
     * @return the number of war stars or {@code -1}
     * if the {@code warStars} attribute cannot be found in the JSON string.
     */

    public int getWarStars() {
        return getIntIfPresent("warStars");
    }

    /**
     * Get the player's number of wins attacking.
     *
     * @return the number of attack wins or {@code -1}
     * if the {@code attackWins} attribute cannot be found in the JSON string.
     */

    public int getAttackWins() {
        return getIntIfPresent("attackWins");
    }

    /**
     * The player's number of wins defending
     *
     * @return the number of defense wins or {@code -1}
     * if the {@code defenseWins} attribute cannot be found in the JSON string.
     */

    public int getDefenseWins() {
        return getIntIfPresent("defenseWins");
    }

    /**
     * Get the player's number of builder base trophies.
     *
     * @return the number of builder base trophies or {@code -1}
     * if the {@code builderBaseTrophies} attribute cannot be found in the JSON string.
     */

    public int getBuilderBaseTrophies() {
        return getIntIfPresent("builderBaseTrophies");

    }

    /**
     * Get the player's number of best builder base trophies.
     *
     * @return the number of best builder base trophies or {@code -1}
     * if the {@code bestBuilderBaseTrophies} attribute cannot be found in the JSON string.
     */

    public int getBestBuilderBaseTrophies() {
        return getIntIfPresent("bestBuilderBaseTrophies");
    }

    /**
     * Get the number of donations sent by the player.
     *
     * @return the number of donations or {@code -1}
     * if the {@code donations} attribute cannot be found in the JSON string.
     */

    public int getDonations() {
        return getIntIfPresent("donations");
    }

    /**
     * Get the number of donations received by the player.
     *
     * @return the number of donations received or {@code -1}
     * if the {@code donationsReceived} attribute cannot be found in the JSON string.
     */

    public int getDonationsReceived() {
        return getIntIfPresent("donationsReceived");
    }

    /**
     * Get the number of contributions the player has made to the clan capital.
     *
     * @return the number of contributions or {@code -1}
     * if the {@code clanCapitalContributions} attribute cannot be found in the JSON string.
     */

    public int getClanCapitalContributions() {
        return getIntIfPresent("clanCapitalContributions");
    }

    /**
     * Get what the player has achieved.
     *
     * @return an array of achievements.
     * Empty if the {@code achievements}
     * cannot be found in the JSON string.
     */

    public @NotNull Achievement @NotNull [] getAchievements() {
        JsonArray achievements = getJsonArrayIfPresent("achievements");

        Achievement[] achievementArray = new Achievement[achievements.size()];

        if (achievementArray.length == 0) {
            return achievementArray;
        }

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
     * Empty if the {@code achievements}
     * cannot be found in the JSON string.
     */

    public @NotNull Label @NotNull [] getLabels() {
        JsonArray labels = getJsonArrayIfPresent("labels");

        Label[] labelArray = new Label[labels.size()];

        if (labelArray.length == 0) {
            return labelArray;
        }

        for (int i = 0; i < labelArray.length; i++) {
            JsonObject labelObject = labels.get(i).getAsJsonObject();

            Label label = new Label(labelObject);

            labelArray[i] = label;
        }

        return labelArray;
    }

    /**
     * Get the troops owned by the player.
     *
     * @return an array of troops.
     * Empty if the {@code achievements}
     * cannot be found in the JSON string.
     */

    public @NotNull Troop @NotNull [] getTroops() {
        JsonArray troops = getJsonArrayIfPresent("troops");

        Troop[] troopArray = new Troop[troops.size()];

        if (troopArray.length == 0) {
            return troopArray;
        }

        for (int i = 0; i < troopArray.length; i++) {
            JsonObject troopObject = troops.get(i).getAsJsonObject();

            Troop troop = new Troop(troopObject);

            troopArray[i] = troop;
        }

        return troopArray;
    }

    /**
     * Get the heroes owned by the player.
     *
     * @return an array of heroes.
     * Empty if the {@code heroes} attribute
     * cannot be found in the JSON string.
     * @since 1.1.0-beta.3
     */

    public @NotNull Hero @NotNull [] getHeroes() {
        JsonArray heroes = getJsonArrayIfPresent("heroes");

        Hero[] heroArray = new Hero[heroes.size()];

        if (heroArray.length == 0) {
            return heroArray;
        }

        for (int i = 0; i < heroArray.length; i++) {
            JsonObject object = heroes.get(i).getAsJsonObject();

            Hero hero = new Hero(object);

            heroArray[i] = hero;
        }

        return heroArray;
    }

    /**
     * Get the hero equipment owned by the player.
     *
     * @return an array of hero equipment.
     * Empty if the {@code heroEquipment} attribute
     * cannot be found in the JSON string.
     * @since 1.1.0-beta.3
     */

    public @NotNull Hero.HeroEquipment @NotNull [] getHeroEquipment() {
        JsonArray heroEquipment = getJsonArrayIfPresent("heroEquipment");

        Hero.HeroEquipment[] heroEquipmentArray = new Hero.HeroEquipment[heroEquipment.size()];

        if (heroEquipmentArray.length == 0) {
            return heroEquipmentArray;
        }

        for (int i = 0; i < heroEquipmentArray.length; i++) {
            JsonObject object = heroEquipment.get(i).getAsJsonObject();

            Hero.HeroEquipment equipment = new Hero.HeroEquipment(object);

            heroEquipmentArray[i] = equipment;
        }

        return heroEquipmentArray;
    }

    /**
     * Get the spells owned by the player.
     *
     * @return an array of spells.
     * Empty if the {@code spells} attribute
     * cannot be found in the JSON string.
     * @since 1.1.0-beta.3
     */

    public @NotNull Spell @NotNull [] getSpells() {
        JsonArray spells = getJsonArrayIfPresent("spells");

        Spell[] spellArray = new Spell[spells.size()];

        if (spellArray.length == 0) {
            return spellArray;
        }

        for (int i = 0; i < spellArray.length; i++) {
            JsonObject object = spells.get(i).getAsJsonObject();

            Spell spell = new Spell(object);

            spellArray[i] = spell;
        }

        return spellArray;
    }

    /**
     * Method for testing {@link JsonInfoReader#getStringIfPresent(String)};
     *
     * @since 1.1.0-beta.2
     */

    String getNonExistentAttributeString() {
        return getStringIfPresent("writeOnceRunAnywhere");
    }

    /**
     * Method for testing {@link JsonInfoReader#getIntIfPresent(String)};
     *
     * @since 1.1.0-beta.2
     */

    int getNonExistentAttributeInt() {
        return getIntIfPresent("writeOnceRunAnywhere");
    }

    /**
     * Method for testing {@link JsonInfoReader#getJsonObjectIfPresent(String)};
     *
     * @since 1.1.0-beta.2
     */

    JsonObject getNonExistentAttributeJsonObject() {
        return getJsonObjectIfPresent("writeOnceRunAnywhere");
    }

    /**
     * Method for testing {@link JsonInfoReader#getJsonArrayIfPresent(String)};
     *
     * @since 1.1.0-beta.2
     */

    JsonArray getNonExistentAttributeJsonArray() {
        return getJsonArrayIfPresent("writeOnceRunAnywhere");
    }
}
