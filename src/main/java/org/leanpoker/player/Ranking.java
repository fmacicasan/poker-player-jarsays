package org.leanpoker.player;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.leanpoker.player.entities.Card;
import org.leanpoker.player.entities.Hand;
import org.leanpoker.player.utils.HttpClient;
import org.leanpoker.player.utils.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmacicasan on 4/25/2015.
 */
public class Ranking {

    public static Hand getBestHand(List<Card> cards) throws IOException {
        String jsonCards = JsonParser.toJson(cards);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("cards", jsonCards));
        String s = HttpClient.doPost("http://rainman.leanpoker.org/rank", params);
        Hand hand = JsonParser.fromJson(s, Hand.class);
        return hand;
    }

}
