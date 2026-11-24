package use_case.define_highlighted;

/**
 * OutputData object for DefineHighlighted use case.
 */

public class DefineHighlightedOutputData {
    private final String word;
    private final String definition;
    private final String viewName;

    public DefineHighlightedOutputData(String word, String definition, String viewName) {
        this.word = word;
        this.definition = definition;
        this.viewName = viewName;
    }

    public String getViewName() { return viewName; }

    public String getWord() { return word; }

    public String getDefinition() { return definition; }
}
