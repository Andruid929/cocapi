package io.github.andruid929.cocapi.information;

import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.github.andruid929.cocapi.TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    private final Player player;

    {
        String jsonString = JsonCollector.getJsonString(new File(SAMPLE_PLAYER_INFO_RESPONSE_FILENAME));

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

    @Test
    void getAchievements() {
        assertEquals(53, player.getAchievements().length);
    }

    @Test
    void getTroops() {
        assertEquals(19, player.getTroops().length);
    }
}