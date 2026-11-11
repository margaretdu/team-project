package interface_adapter.create_flashcard;

import use_case.create_flashcard.CreateFlashcardInputBoundary;
import use_case.create_flashcard.CreateFlashcardInputData;

/**
 * Controller for the Create Flashcard Use Case.
 */
public class CreateFlashcardController {

    private final CreateFlashcardInputBoundary flashcardCreateFlashcardUseCaseInteractor;

    public CreateFlashcardController(CreateFlashcardInputBoundary flashcardCreateFlashcardUseCaseInteractor) {
        this.flashcardCreateFlashcardUseCaseInteractor = flashcardCreateFlashcardUseCaseInteractor;
    }

    /**
     * Executes Create Flashcard Use Case.
     * @param question the question
     * @param answer the answer
     */
    public void execute(String question, String answer) {
        final CreateFlashcardInputData createFlashcardInputData = new CreateFlashcardInputData(
                question, answer);

        flashcardCreateFlashcardUseCaseInteractor.execute(createFlashcardInputData);
    }

    /**
     * Executes switch to Homescreen Use Case
     */
    public void switchToHomescreenView() { flashcardCreateFlashcardUseCaseInteractor.switchToHomescreenView(); }
}
