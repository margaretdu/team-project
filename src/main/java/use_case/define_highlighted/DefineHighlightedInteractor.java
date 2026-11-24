package use_case.define_highlighted;

public class DefineHighlightedInteractor implements DefineHighlightedInputBoundary{
    private final DefineHighlightedDataAccessInterface defineHighlightedDataAccessObject;
    private final DefineHighlightedOutputBoundary defineHighlightedPresenter;

    public DefineHighlightedInteractor(DefineHighlightedDataAccessInterface dataAccessObject,
                                       DefineHighlightedOutputBoundary presenter) {
        this.defineHighlightedDataAccessObject = dataAccessObject;
        this.defineHighlightedPresenter = presenter;
    }

    @Override
    public void execute(DefineHighlightedInputData inputData) {

    }
}
