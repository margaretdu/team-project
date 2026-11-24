package use_case.define_highlighted;

/**
 * Input boundary for the DefineHighlighted term use case.
 */
public interface DefineHighlightedInputBoundary {

    /**
     * Executes the DefineHighlighted use case.
     * @param inputData is the input data
    */
    void execute(DefineHighlightedInputData inputData);

}
