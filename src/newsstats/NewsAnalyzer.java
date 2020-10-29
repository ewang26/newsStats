package newsstats;

import java.util.*;
import java.util.stream.Collectors;

public class NewsAnalyzer {
    public static final String[] IGNORED_WORDS = {"at", "in", "to", "the", "of", "on", "after", "as", "a"};
    private HashMap<String, WordCount> _wcMap = new HashMap<String, WordCount>();
    private ArrayList<String> _newsList = null;

    public NewsAnalyzer(ArrayList<String> newsList) {
        _newsList = newsList;
    }

    public void countWords() {
        List<String> iwList = Arrays.asList(IGNORED_WORDS);

        for (int n = 0; n < _newsList.size(); n++) {
            newsstr = _newsList.get(n);
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

    public void sortWords() {
        List<WordCount> wcList = _wcMap.values().stream().collect(Collectors.toList());
        Collections.sort(wcList);
        wcList.forEach(wc -> System.out.println(wc));
    }

    public ArrayList<String> getNewsList() {
        return _newsList;
    }

    public void setNewsList(ArrayList<String> newsList) {
        this._newsList = newsList;
    }
}
