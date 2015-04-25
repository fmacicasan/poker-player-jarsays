package org.leanpoker.player;

import org.leanpoker.player.entities.GameState;

import java.io.IOException;

public class Player {

    protected static final Integer DEFAULT_RETURN = 150;
    static final String VERSION = "b00lder2 away";

    public static int betRequest(GameState gameState) throws IOException {
        System.out.println("request:" + gameState);
        System.out.println("Will return default");

        return gameState.getMinimumRaise() == 0 ? 0: DEFAULT_RETURN;
    }

    public static void showdown(GameState gameState) {
    }
}
