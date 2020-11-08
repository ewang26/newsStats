package newsstats;

import java.util.ArrayList;

/**
 * The AnalyzeNewsMain program implements an application that retrieves content from online news articles
 * and analyzes them based on the frequency of key words.
 * @author ewang26
 */
public class AnalyzeNewsMain {
// This is the class that executes NewsByJsoup and NewsAnalyzer in order to fetch and analyze the content

    public static void main(String[] argv) {
        ArrayList<String> newsList = new ArrayList<>();

        newsList.addAll(NewsByJsoup.addNewsToList("https://news.google.com/topstories?hl=en-US&gl=US&ceid=US:en", "h3"));
        newsList.addAll(NewsByJsoup.addNewsToList("https://news.google.com/topstories?hl=en-US&gl=US&ceid=US:en", "h4"));
        newsList.addAll(NewsByJsoup.addNewsToList("https://news.yahoo.com", "h3"));
        System.out.println("Total news list size:" + newsList.size());

        NewsAnalyzer analyzer = new NewsAnalyzer(newsList);
        analyzer.countWords();
        analyzer.sortWords();
    }
}
