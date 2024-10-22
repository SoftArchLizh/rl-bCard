package com.rl.ai;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import org.json.JSONObject;

/**
 * Author: 李中华
 * Date: 2024/10/17
 **/

    public class OcrExample {
        public static void main(String[] args) {
            try {
                URL url = new URL("https://apple.hi3w.com/api/endpoint");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();


                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json; utf-8");
                con.setRequestProperty("Accept", "application/json");
                con.setRequestProperty("Authorization", "Bearer sk-6oDdN7HE06cB57Zp0dE620D9F79d47128e2dC8F814Fd3042");

                JSONObject data = new JSONObject();
                data.put("model", "gpt-4o-mini");
                data.put("prompt", "");
                data.put("max_tokens", 4000);
                data.put("temperature", 1.0);

                con.setDoOutput(true);
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = data.toString().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                        String output = in.lines().reduce((a, b) -> a + b).get();
                        System.out.println(new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
                    }
                } else {
                    System.out.println("Error: " + responseCode);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

