package net.druidlabs.cocapi.information;

import net.druidlabs.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final Player player;

    {
        String fileName = "Sample player_info response.json";

        String jsonString = JsonCollector.getJsonString(new File(fileName));

        player = new Player(jsonString);
    }

    @Test
    void getTag() {
        assertEquals("3ATJ4V424", player.getTag(true));
    }

    @Test
    void getName() {
        assertEquals("Hello World", player.getName());
    }

    @Test
    void getTownHallLevel() {
        assertEquals(22, player.getTownHallLevel());
    }

    @Test
    void getExpLevel() {
        assertEquals(11, player.getExpLevel());
    }

    @Test
    void getTrophies() {
        assertEquals(230, player.getTrophies());
    }

    @Test
    void getBestTrophies() {
        assertEquals(120, player.getBestTrophies());
    }

    @Test
    void getWarStars() {
        assertEquals(30, player.getWarStars());
    }

    @Test
    void getAttackWins() {
        assertEquals(334, player.getAttackWins());
    }

    @Test
    void getDefenseWins() {
        assertEquals(54, player.getDefenseWins());
    }

    @Test
    void getBuilderBaseTrophies() {
        assertEquals(18, player.getBuilderBaseTrophies());
    }

    @Test
    void getBestBuilderBaseTrophies() {
        assertEquals(9, player.getBestBuilderBaseTrophies());
    }

    @Test
    void getDonations() {
        assertEquals(0, player.getDonations());
    }

    @Test
    void getDonationsReceived() {
        assertEquals(873, player.getDonationsReceived());
    }

    @Test
    void getClanCapitalContributions() {
        assertEquals(232, player.getClanCapitalContributions());
    }
}