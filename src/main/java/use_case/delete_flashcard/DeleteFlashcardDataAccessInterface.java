package use_case.delete_flashcard;

public interface DeleteFlashcardDataAccessInterface {
    boolean deckExists(String name);
    void deleteFlashcard(String deckName, String question);
}