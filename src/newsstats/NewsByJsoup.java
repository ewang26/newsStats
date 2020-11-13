package newsstats;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

// this class uses jsoup instead of the Java dom parser

/**
 * The NewsByJSoup program implements the retrieval of text from online news articles using the JSoup library.
 */
public class NewsByJsoup {

    /**
     * Retrieves News content to analyze
     * <p>
     * The theURL argument must specify an existing page from a news organization's website. The tag
     * argument must be a legitimate HTML tag with which to discern relevant content to fetch.
     *
     * @param theUrl a URL giving the location of the text to retrieve
     * @param tag an HTML tag specifying the type of content to retrieve from the url
     * @return the text requested from the URL
     */
    public static ArrayList<String> addNewsToList(String theUrl, String tag) {
        ArrayList<String> newsList = new ArrayList<String>();

        try {
            //theURL can be https://news.google.com/topstories?hl=en-US&gl=US&ceid=US:en
            Document doc = Jsoup.connect(theUrl).get();
            Elements eleList = doc.select(tag);
            System.out.println("url:" + theUrl + " has " + eleList.size() + " news titles");
            for (int i = 0; i < eleList.size(); i++) {
                newsList.add(eleList.get(i).text());
            }
            //eleList.forEach(ele -> newsList.add(ele.text()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return newsList;
    }

}
