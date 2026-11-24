package use_case.define_highlighted;

public class DefineHighlightedInputData{
    private final String word;

    public DefineHighlightedInputData(String word) {
        this.word = word;
    }

    String getWord() { return word; }
}
