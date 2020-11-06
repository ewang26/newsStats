package newsstats;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class NewsAnalyzer {

    private HashMap<String, WordCount> _wcMap = new HashMap<String, WordCount>();
    private ArrayList<String> _newsList = null;

    public NewsAnalyzer(ArrayList<String> newsList) {
        _newsList = newsList;
    }

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
