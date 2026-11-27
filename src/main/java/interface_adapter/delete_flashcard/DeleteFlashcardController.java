package interface_adapter.delete_flashcard;

import use_case.delete_flashcard.DeleteFlashcardInputBoundary;
import use_case.delete_flashcard.DeleteFlashcardInputData;

public class DeleteFlashcardController {

    private final DeleteFlashcardInputBoundary deleteFlashcardUseCase;

    public DeleteFlashcardController(DeleteFlashcardInputBoundary deleteFlashcardUseCase) {
        this.deleteFlashcardUseCase = deleteFlashcardUseCase;
    }

    public void execute(String deckName, String question) {
        DeleteFlashcardInputData inputData =
                new DeleteFlashcardInputData(deckName, question);

        deleteFlashcardUseCase.execute(inputData);
    }
}
