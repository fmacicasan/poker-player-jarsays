package org.leanpoker.player;

import org.leanpoker.player.entities.GameState;

import java.io.IOException;

public class Player {

    protected static final Integer DEFAULT_RETURN = 150;
    static final String VERSION = "b00lder23 away";

    public static int betRequest(GameState gameState) throws IOException {
    	BetLogic betLogic = new BetLogic(gameState);
        System.out.println("request:" + gameState);
        System.out.println("Will return default");

        return DEFAULT_RETURN;
    }

    public static void showdown(GameState gameState) {
    }
}
