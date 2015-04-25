package org.leanpoker.player;

import com.google.gson.JsonElement;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
        String url = "http://rainman.leanpoker.org/rank";

        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(url);
        request.addHeader("Content-Type","application/x-www-form-urlencoded");
        request.setEntity(new UrlEncodedFormEntity(null));
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
