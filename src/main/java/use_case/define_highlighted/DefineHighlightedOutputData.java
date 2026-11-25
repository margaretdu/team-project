package use_case.define_highlighted;

/**
 * OutputData object for DefineHighlighted use case.
 */

public class DefineHighlightedOutputData {
    private final String word;
    private final String definition;

    public DefineHighlightedOutputData(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() { return word; }

    public String getDefinition() { return definition; }
}
