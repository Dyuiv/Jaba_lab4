package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        try {
            JSONArray jsonResponse = getJsonArray("https://dummy-json.mock.beeceptor.com/todos");
            for (int i = 0; i < jsonResponse.length(); i++) {
                JSONObject user = jsonResponse.getJSONObject(i);
                System.out.println("userId: " + user.getInt("userId"));
                System.out.println("id: " + user.getInt("id"));
                System.out.println("title: " + user.getString("title"));
                System.out.println("completed: " + user.getBoolean("completed"));
            }
            jsonResponse = getJsonArray("https://dummy-json.mock.beeceptor.com/posts");
            for (int i = 0; i < jsonResponse.length(); i++) {
                JSONObject user = jsonResponse.getJSONObject(i);
                System.out.println("userId: " + user.getInt("userId"));
                System.out.println("id: " + user.getInt("id"));
                System.out.println("title: " + user.getString("title"));
                System.out.println("body: " + user.getString("body"));
                System.out.println("link: " + user.getString("link"));
                System.out.println("comment_count: " + user.getInt("comment_count"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONArray getJsonArray(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return new JSONArray(response.toString());
    }
}
