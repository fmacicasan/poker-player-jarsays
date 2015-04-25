package org.leanpoker.player;

import org.leanpoker.player.entities.GameState;
import org.leanpoker.player.entities.PlayerDetails;

import java.io.IOException;

public class Player {

    protected static final Integer DEFAULT_RETURN = 150;
    static final String VERSION = "cards v1.2";
    static final String OUR_TEAM = "Jarsays";

    public static int betRequest(GameState gameState) throws IOException {
    	BetLogic betLogic = new BetLogic(gameState);
        System.out.println("request:" + gameState);
        System.out.println("Will return default");

        PlayerDetails us = gameState.getPlayer(OUR_TEAM);

//        return gameState.getMinimumRaise() == 0? gameState.getCurrentBuyIn() - us.getBet() : DEFAULT_RETURN;
        return betLogic.calculate();
    }

    public static void showdown(GameState gameState) {
    }
}
