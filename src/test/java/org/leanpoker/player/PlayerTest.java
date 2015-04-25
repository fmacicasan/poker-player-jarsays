package org.leanpoker.player;

import org.junit.Before;
import org.junit.Test;
import org.leanpoker.player.entities.GameState;
import org.leanpoker.player.utils.FileUtils;
import org.leanpoker.player.utils.JsonParser;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private String c1;

    @Before
    public void setUp() throws Exception {
        c1 = FileUtils.readAllContent("src/test/resources/game_state.json");
    }

    @Test
    public void testBetRequest() throws Exception {
        GameState gameState = JsonParser.fromJson(c1, GameState.class);
        assertEquals(Player.DEFAULT_RETURN.intValue(), Player.betRequest(gameState));
    }
}
