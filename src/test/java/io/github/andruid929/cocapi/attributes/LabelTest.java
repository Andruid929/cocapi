package io.github.andruid929.cocapi.attributes;

import io.github.andruid929.cocapi.TestConstants;
import io.github.andruid929.cocapi.information.Player;
import io.github.andruid929.cocapi.util.JsonCollector;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class LabelTest {

    private final Label label;

    {
        Player player = new Player(JsonCollector.getJsonString(new File(TestConstants.SAMPLE_PLAYER_INFO_RESPONSE_FILENAME)));

        label = player.getLabels()[0];
    }

    @Test
    void getId() {
        assertEquals(57000012, label.getId());
    }

    @Test
    void getName() {
        assertEquals("Talkative", label.getName());
    }

    @Test
    void getIconUrls() {
        assertTrue(label.getIconUrls().getSmallIconUrl().endsWith(".png"));
    }
}