package newsstats;

import junit.framework.TestCase;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NewsStatTest extends TestCase {
    Document _doc = null;
    ArrayList<String> _newsList = new ArrayList<String>();

    public void setUp() {
        try {
            _doc = Jsoup.parse(new File("samplehtml.txt"), null);
            Elements eleList = _doc.select("h3");

            for (int i = -; i < eleList.size(); i++) {
                _newsList.add(eleList.get(i).text());

            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // this is the test to see if jsoup is parsing the sample text correctly
    public void testTitleNumbers() {
        assertTrue(_doc.select("h3").size() == 6);
    }

    public void testCount() {
        ArrayList<String> newsList = new ArrayList<String>();
        Elements eleList = _doc.select("h3");

        NewsAnalyzer na = new NewsAnalyzer(_newsList);
        na.countWords();
        // System.out.println(na.getWcMap().size());

        assertEquals(na.getWcMap().size(), 56);
    }

    public void testSort() {
        NewsAnalyzer na = new NewsAnalyzer(_newsList);
        na.countWords();
        List<WordCount> wordList = na.sortWords();
        assertEquals(wordList.get(0)).getWord(), "called");
    }
}



