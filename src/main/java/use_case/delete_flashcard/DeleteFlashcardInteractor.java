package use_case.delete_flashcard;

public class DeleteFlashcardInteractor implements DeleteFlashcardInputBoundary {

    private final DeleteFlashcardDataAccessInterface deckDataAccessObject;
    private final DeleteFlashcardOutputBoundary presenter;

    public DeleteFlashcardInteractor(
            DeleteFlashcardDataAccessInterface deckDataAccessObject,
            DeleteFlashcardOutputBoundary presenter) {
        this.deckDataAccessObject = deckDataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(DeleteFlashcardInputData inputData) {

        if (!deckDataAccessObject.deckExists(inputData.getDeckName())) {
            presenter.prepareFailView("Deck does not exist");
            return;
        }

        deckDataAccessObject.deleteFlashcard(
                inputData.getDeckName(),
                inputData.getQuestion()
        );

        presenter.prepareSuccessView();
    }
}