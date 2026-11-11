package use_case.create_flashcard;

/**
 * The output boundary for the Create Flashcard Use Case.
 */
public interface CreateFlashcardOutputBoundary {
    /**
     * Prepares the success view for the Create Flashcard Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(CreateFlashcardOutputData outputData);

    /**
     * Prepares the failure view for the Create Flashcard Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to the Homescreen View
     */
    void switchToHomescreenView();

}
