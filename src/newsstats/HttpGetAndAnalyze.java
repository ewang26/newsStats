package newsstats;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class HttpGetAndAnalyze {
    public static void main(String[] argv) {
        try {
            LinkedList<String> newsList = new LinkedList<String>();
            HttpClient client = HttpClient.newHttpClient();

            //get yahoo news from yahoo rss
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://news.yahoo.com/rss")).build();
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("yahoobody.xml")));
            //Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("yahoobody.xml"));

            /*NodeList titles = doc.getElementsByTagName("title");
            for (int ind = 0; ind < titles.getLength(); ind++) {
                Node title = titles.item(ind);
                System.out.println(title.getTextContent());
                newsList.add(title.getTextContent());
            }*/

            // get google news from google rss
            System.out.println("New Google News");
            request = HttpRequest.newBuilder().uri(URI.create("https://news.google.com/rss?hl=en-US&gl=US&ceid=US:en")).build();
            response = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get("googlebody.xml")));
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("googlebody.xml"));

            NodeList titles = doc.getElementsByTagName("title");
            for (int ind = 0; ind < titles.getLength(); ind++) {
                Node title = titles.item(ind);
                System.out.println(title.getTextContent());
                newsList.add(title.getTextContent());
            }

            // get news from other site

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String removeSpecialChars(String arg) {
        return null;

    }

}
