package org.leanpoker.player.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.leanpoker.player.entities.GameState;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class JsonParserTest {
    private String c1;

    @Before
    public void setUp() throws Exception {
        c1 = FileUtils.readAllContent("src/test/resources/game_state.json");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFromJson() throws Exception {
        GameState gameState = JsonParser.fromJson(c1, GameState.class);
        Assert.assertEquals(7, gameState.getOrbits());
        Assert.assertEquals(1, gameState.getDealer());
    }
}