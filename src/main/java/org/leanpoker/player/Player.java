package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.leanpoker.player.entities.GameState;

import java.io.IOException;

public class Player {

    protected static final Integer DEFAULT_RETURN = 200;
    static final String VERSION = "b00ld away";

    public static int betRequest(GameState gameState) throws IOException {
        System.out.println("request:" + gameState);
        System.out.println("Will return default");

        return DEFAULT_RETURN;
    }

    public static int betRequest(JsonElement request) throws IOException {

        System.out.println("request:" + request);
        System.out.println("Will return default");

        return DEFAULT_RETURN;
    }

    public static void showdown(JsonElement game) {
    }

    public static void showdown(GameState game) {
    }
}
