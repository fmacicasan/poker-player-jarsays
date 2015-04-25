package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.io.IOException;
import java.util.Map;

public class Player {

    static final String VERSION = "b00lder away";

    protected static final Integer DEFAULT_RETURN = 400;

    public static int betRequest(JsonElement request) throws IOException {

        System.out.println("request:" + request);
        System.out.println("Will return default");

        return DEFAULT_RETURN;
    }

    public static void showdown(JsonElement game) {
    }
}
