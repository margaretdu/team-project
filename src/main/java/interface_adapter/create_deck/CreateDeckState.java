package interface_adapter.create_deck;

public class CreateDeckState {
    private String name = "";
    private String nameError;

    public String getName() { return name; }

    public String getNameError() { return nameError; }

    public void setName(String name) { this.name = name; }

    public void setNameError(String nameError) { this.nameError = nameError; }


    @Override
    public String toString() {
        return "CreateFlashcardState{"
                + "name='" + name + '}';
    }
}