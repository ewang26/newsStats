package newsstats;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.nio.file.Path;
//import java.nio.file.Paths;

public class HttpGetAndAnalyze {
    public static void main(String[] argv) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://news.google.com/topstories?hl=en-US&tab=en1&gl=US&ceid=US:en")).build();
           
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response in String:" + response.body());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
