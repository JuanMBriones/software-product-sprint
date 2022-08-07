package com.google.sps.utils;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class SentimentAnalysis {
    public static int getSentiment(String text) throws IOException {
        URL url = new URL("https://api.deepai.org/api/sentiment-analysis");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setDoOutput(true);
        http.setRequestProperty("api-key", "e556d12a-e1e7-4c80-b328-331355a852eb");

        String data = "text=ok";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        try (DataOutputStream wr = new DataOutputStream(http.getOutputStream())) {
            wr.write(out);
        }
        /*OutputStream stream = http.getOutputStream();
        stream.write(out);*/
        
        StringBuilder content;

        try (var br = new BufferedReader(new InputStreamReader(http.getInputStream()))) {

            String line;
            content = new StringBuilder();

            while ((line = br.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
            }
        }
        http.disconnect();

        if (content.toString().contains("Neutral")) {
            return 0;
        }
        else if(content.toString().contains("Positive")) {
            return 1;
        }
        else if(content.toString().contains("Negative")) {
            return -1;
        }

        return 0;
    }
}
