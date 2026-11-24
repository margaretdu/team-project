package interface_adapter.define_highlighted;

public class DefineHighlightedState {
    private String word = "";
    private String wordError;

    public String getWord() { return word; }

    public String getWordError() { return wordError; }

    public void setWord(String word) { this.word = word; }

    public void setWordError(String wordError) { this.word = wordError; }

    @Override
    public String toString() {
        return "DefineHighlightedState{"
                + "word='" + word + '}';
    }

}
