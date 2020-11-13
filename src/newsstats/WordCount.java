package newsstats;

/**
 * Represents the frequency of a tracked word
 * @author ewang26
 */
public class WordCount implements Comparable<WordCount>{
    private String _word;
    private int _count;

    /**
     * Creates a WordCount of the specific word.
     * Stores the current count at instantiation.
     * @param word The word who's frequency is tracked
     * @param count The frequency of the word
     */
    public WordCount(String word, int count) {
        _word = word;
        _count = count;
    }

    /**
     * Gets the tracked word
     * @return A string representing the tracked word
     */
    public String getWord() {
        return _word;
    }

    /**
     * Sets the tracked word
     * @param _word A string representing the word tracked
     */
    public void setWord(String _word) {
        this._word = _word;
    }

    /**
     * Gets the count or frequency of the word
     * @return A int holding the current frequency of the word
     */
    public int getCount() {
        return _count;
    }

    /**
     * Sets and updates the count of the word
     * @param _count An int representing the new frequency
     */
    public void setCount(int _count) {
        this._count = _count;
    }

    /**
     * Increments the count of the word
     */
    public void increaseCount() {
        this._count++;
    }

    public int compareTo(WordCount wc) {
        //Sorts by increasing (non-decreasing) order of "_count"
        //Name is not a factor
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
