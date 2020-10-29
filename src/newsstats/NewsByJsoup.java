package newsstats;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NewsByJsoup {
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
