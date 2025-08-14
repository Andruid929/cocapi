package io.github.andruid929.cocapi.attributes;

import io.github.andruid929.cocapi.TestConstants;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.github.andruid929.cocapi.TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AchievementTest {

    private final Achievement achievement;

    {
        Player player = new Player(JsonCollector.getJsonString(new File(SAMPLE_PLAYER_INFO_RESPONSE_FILENAME)));

        achievement = player.getAchievements()[0];
    }

    @Test
    void getName() {
        assertEquals("Bigger Coffers", achievement.getName());
    }

    @Test
    void getStars() {
        assertEquals(0, achievement.getStars());
    }

    @Test
    void getValue() {
        assertEquals(1, achievement.getValue());
    }

    @Test
    void getTarget() {
        assertEquals(2, achievement.getTarget());
    }

    @Test
    void getInfo() {
        assertEquals("Upgrade a Gold Storage to level 2", achievement.getInfo());
    }

    @Test
    void getCompletionInfo() {
        assertEquals("Highest Gold Storage level: 1", achievement.getCompletionInfo());
    }

    @Test
    void getVillage() {
        assertEquals("home", achievement.getVillage());
    }

    @Test
    void testToString() {
        assertTrue(TestConstants.isToStringCorrect(achievement));
    }
}