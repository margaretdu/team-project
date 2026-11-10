package use_case.create_flashcard;

/**
 * Input Boundary for actions which are related to creating a flashcard.
 */
public interface CreateFlashcardInputBoundary {
    /**
     * Executes the create a flashcard case.
     * @param createFlashcardInputData the input data
     */
    void execute(CreateFlashcardInputData createFlashcardInputData);
}
