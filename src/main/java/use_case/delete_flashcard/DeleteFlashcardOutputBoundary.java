package use_case.delete_flashcard;

public interface DeleteFlashcardOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}