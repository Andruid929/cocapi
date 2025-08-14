package io.github.andruid929.cocapi.attributes;

import io.github.andruid929.cocapi.TestConstants;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private final Hero hero;

    {
        Player player = new Player(JsonCollector.getJsonString(new File(TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME)));

        hero = player.getHeroes()[0];
    }

    @Test
    void getName() {
        assertEquals("Barbarian King", hero.getName());
    }

    @Test
    void getLevel() {
        assertEquals(21, hero.getLevel());
    }

    @Test
    void getMaxLevel() {
        assertEquals(100, hero.getMaxLevel());
    }

    @Test
    void getVillage() {
        assertEquals("home", hero.getVillage());
    }

    @Test
    void getHeroEquipment() {
        assertEquals(2, hero.getHeroEquipment().length);
    }

    @Test
    void testToString() {
        assertTrue(TestConstants.isToStringCorrect(hero));
    }
}