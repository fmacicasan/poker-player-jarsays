package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "test version";

    public static int betRequest(JsonElement request) {
        System.out.println("request:" + request);
        return 100;
    }

    public static void showdown(JsonElement game) {
    }
}
