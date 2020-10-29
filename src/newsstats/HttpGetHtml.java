package newsstats;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.nio.file.Path;
//import java.nio.file.Paths;

/**
* This class gets the html of a webpage from the url. It is currently intended for
* pages from Google News and Yahoo News. The class then analyzes attributes of the
* page, including keywords and important names, by filtering out "filler" words
* and identifying/sorting keywords. 
*/

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
