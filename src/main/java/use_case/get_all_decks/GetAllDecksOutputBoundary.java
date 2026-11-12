package use_case.get_all_decks;

/**
 * The output boundary for the GetALlDecks Use Case.
 */
public interface GetAllDecksOutputBoundary {
    /**
     * Prepares the success view for the GetAllDecks Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(GetAllDecksOutputData outputData);

    /**
     * Prepares the failure view for the GetAllDecks Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
