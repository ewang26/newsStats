package newsstats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Analyzes the textual context of a news article
 * @author ewang26
 */
public class NewsAnalyzer {

    /**
     * Stores the frequency of tracked words
     */
    private HashMap<String, WordCount> _wcMap = new HashMap<String, WordCount>();
    /**
     * Stores the text of a news article
     */
    private ArrayList<String> _newsList = null;

    /**
     * Creates a new NewsAnalyzer with the specified article content
     * @param newsList represents the text from an online article
     */
    public NewsAnalyzer(ArrayList<String> newsList) {
        _newsList = newsList;
    }

    /**
     * Counts the frequency of important words in a news title.
     * Ignores a predefined list of "filler" words, including prepositions, conjunctions, and pronouns.
     */
    public void countWords() {
        List<String> iwList = getIgnoredWords();

        for (int n = 0; n < _newsList.size(); n++) {
            String newsstr = _newsList.get(n);
            String[] words = newsstr.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!iwList.contains(word.toLowerCase())) {
                    System.out.printf("[%s] ", word);
                    if (_wcMap.containsKey(word)) {
                        WordCount wc = _wcMap.get(word);
                        wc.increaseCount();
                    } else {
                        _wcMap.put(word, new WordCount(word, 1));
                    }
                }
            }
        }

    }

    /**
     * Retrieves the list of words or phrases to ignore from FILLERWORDS.txt
     * @return A List of strings representing unimportant words or phrases
     */
    public static List<String> getIgnoredWords(){
        List<String> result = new ArrayList<String>();

        try {
            BufferedReader in = new BufferedReader(new FileReader("FILLERWORDS.txt"));
            String line;
            while((line = in.readLine()) != null){
                line = line.trim();
                if(line.isEmpty() || (line.length()>2 && line.substring(0, 2).equals("//")))
                    continue;
                result.add(line);
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Sorts then prints the tracked words of an article in non-decreasing order by their frequency.
     */
    public List<WordCount> sortWords() {
        List<WordCount> wcList = _wcMap.values().stream().collect(Collectors.toList());
        Collections.sort(wcList);
        wcList.forEach(wc -> System.out.println(wc));
        return wcList;
    }


    /**
     * Prints the top 10 terms of the article by number of appearances. If there are less than 10 words in the article,
     * the method will print all of the words available.
     */
    public void printTopTerms(){
        List<WordCount> topList = getTopTerms();
        for(WordCount i : topList){
            System.out.println(i.getWord() + ": " + i.getCount());
        }
    }

    /**
     * Finds and returns the top 10 terms of the article by number of appearances. If there are less than 10 words in the article,
     * the method will return all of the words available.
     * @return List of WordCount for the top 10 or less terms of the article by number of appearances
     */
    public List<WordCount> getTopTerms(){
        List<WordCount> wcList = _wcMap.values().stream().collect(Collectors.toList());
        Collections.sort(wcList);
        Collections.reverse(wcList);

        List<WordCount> result = new ArrayList<WordCount>();
        for(int i = 0; i<Math.min(10, wcList.size()); ++i){
            result.add(wcList.get(i));
        }
        return result;
    }



    public HashMap<String, WordCount> getWcMap() {
        return _wcMap;
    }

    public void setWcMap(HashMap<String, WordCount> _wcMap) {
        this._wcMap = _wcMap;
    }

    /**
     * Retrieves the text of the represented news article
     * @return An ArrayList of strings storing text
     */
    public ArrayList<String> getNewsList() {
        return _newsList;
    }

    /**
     * Sets the content of the represented news article
     * @param newsList An ArrayList of strings storing text
     */
    public void setNewsList(ArrayList<String> newsList) {
        this._newsList = newsList;
    }
}
