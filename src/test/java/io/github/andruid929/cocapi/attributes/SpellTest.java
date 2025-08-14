package io.github.andruid929.cocapi.attributes;

import io.github.andruid929.cocapi.TestConstants;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class SpellTest {

    private final Spell spell;

    {
        Player player = new Player(JsonCollector.getJsonString(new File(TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME)));

        spell = player.getSpells()[0];
    }

    @Test
    void getName() {
        assertEquals("Lightning Spell", spell.getName());
    }

    @Test
    void getLevel() {
        assertEquals(4, spell.getLevel());
    }

    @Test
    void getMaxLevel() {
        assertEquals(12, spell.getMaxLevel());
    }

    @Test
    void getVillage() {
        assertEquals("home", spell.getVillage());
    }

    @Test
    void testToString() {
        assertTrue(TestConstants.isToStringCorrect(spell));
    }
}