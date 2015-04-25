package org.leanpoker.player;

import com.google.gson.reflect.TypeToken;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.leanpoker.player.entities.Card;
import org.leanpoker.player.entities.Hand;
import org.leanpoker.player.utils.FileUtils;
import org.leanpoker.player.utils.JsonParser;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author octavian
 * @since 25.04.2015
 */
public class RankingTest {
    private String content;

    @Before
    public void setUp() throws Exception {
        content = FileUtils.readAllContent("src/test/resources/cards.json");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCallRanking() throws Exception {
        Type collectionType = new TypeToken<List<Card>>() {
        }.getType();

        List<Card> cards = JsonParser.fromJson(content, collectionType);
        Hand hand = Ranking.getBestHand(cards);

        Assert.assertEquals(8, hand.getRank());
        //TODO: add more
    }
}