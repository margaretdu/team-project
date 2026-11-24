package use_case.define_highlighted;

/**
 * The output boundary for the DefineHighlighted Use Case.
 */
public interface DefineHighlightedOutputBoundary {
    /**
     * Prepares the success view for the DefineHighlighted Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(DefineHighlightedOutputData outputData);

    /**
     * Prepares the failure view for the DefineHighlighted Use Case
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
