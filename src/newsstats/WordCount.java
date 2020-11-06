package newsstats;

public class WordCount implements Comparable<WordCount>{
    private String _word;
    private int _count;
    
    public WordCount(String word, int count) {
        _word = word;
        _count = count;
    }

    public String getWord() {
        return _word;
    }

    public void setWord(String _word) {
        this._word = _word;
    }

    public int getCount() {
        return _count;
    }

    public void setCount(int _count) {
        this._count = _count;
    }

    public void increaseCount() {
        this._count++;
    }

    public int compareTo(WordCount wc) {
        if (this._count > wc.getCount()) {
            return 1;
        }
        else if (this._count == wc.getCount()) {
            return 0;
        }
        else {
            return -1;
        }
    }

    public String toString() {
        return String.format("Word:%s count %d", _word, _count);
    }

}
