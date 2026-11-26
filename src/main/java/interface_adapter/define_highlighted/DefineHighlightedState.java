package interface_adapter.define_highlighted;

public class DefineHighlightedState {
    private String word = "";
    private String definition = "";

    private String errorMessage;

    public String getWord() { return word; }

    public String getDefinition() {return definition;}

    public String getError() {return errorMessage;}

    public void setWord(String word) { this.word = word; }

    public void setDefinition(String definition) {this.definition = definition;}

    public void setErrorMessage(String wordError) { this.errorMessage = errorMessage; }

    @Override
    public String toString() {
        return "DefineHighlightedState{"
                + "word='" + word + '}';
    }

}
