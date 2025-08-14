package io.github.andruid929.cocapi.attributes;

import io.github.andruid929.cocapi.TestConstants;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.github.andruid929.cocapi.TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TroopTest {

    private final Troop troop;

    {
        Player player = new Player(JsonCollector.getJsonString(new File(SAMPLE_PLAYER_INFO_RESPONSE_FILENAME)));

        troop = player.getTroops()[0];
    }

    @Test
    void getName() {
        assertEquals("Barbarian", troop.getName());
    }

    @Test
    void getLevel() {
        assertEquals(1, troop.getLevel());
    }

    @Test
    void getMaxLevel() {
        assertEquals(12, troop.getMaxLevel());
    }

    @Test
    void getVillage() {
        assertEquals("home", troop.getVillage());
    }

    @Test
    void testToString() {
        assertTrue(TestConstants.isToStringCorrect(troop));
    }
}