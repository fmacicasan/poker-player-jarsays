package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by fmacicasan on 4/25/2015.
 */
public class Ranking {

    public static void callRanking(JsonElement requestElement) throws IOException {
        String url = "http://rainman.leanpoker.org/rank'?cards=[\n" +
                "    {\"rank\":\"5\",\"suit\":\"diamonds\"},\n" +
                "    {\"rank\":\"6\",\"suit\":\"diamonds\"},\n" +
                "    {\"rank\":\"7\",\"suit\":\"diamonds\"},\n" +
                "    {\"rank\":\"7\",\"suit\":\"spades\"},\n" +
                "    {\"rank\":\"8\",\"suit\":\"diamonds\"},\n" +
                "    {\"rank\":\"9\",\"suit\":\"diamonds\"}\n" +
                "]'";

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        CloseableHttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println("Result" + result.toString());
    }

}
