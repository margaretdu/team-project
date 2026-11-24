package interface_adapter.define_highlighted;

import use_case.define_highlighted.DefineHighlightedInputBoundary;
import use_case.define_highlighted.DefineHighlightedInputData;

public class DefineHighlightedController {
    private final DefineHighlightedInputBoundary defineHighlightedUseCaseInteractor;

    public DefineHighlightedController(DefineHighlightedInputBoundary useCaseInteractor) {
        this.defineHighlightedUseCaseInteractor = useCaseInteractor;
    }

    /**
     * Executes DefineHighlighted use case interactor.
     * @param word
     */
    public void execute(String word) {
        DefineHighlightedInputData defineHighlightedInputData = new DefineHighlightedInputData(word);
        defineHighlightedUseCaseInteractor.execute(defineHighlightedInputData);
    }
}
