package use_case.delete_flashcard;

public class DeleteFlashcardInputData {
    private final String deckName;
    private final String question;

    public DeleteFlashcardInputData(String deckName, String question) {
        this.deckName = deckName;
        this.question = question;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getQuestion() {
        return question;
    }
}