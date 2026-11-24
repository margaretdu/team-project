package use_case.define_highlighted;

public class DefineHighlightedInteractor implements DefineHighlightedInputBoundary{
    private final DefineHighlightedOutputBoundary defineHighlightedPresenter;

    public DefineHighlightedInteractor(DefineHighlightedOutputBoundary presenter) {
        this.defineHighlightedPresenter = presenter;
    }

    @Override
    public void execute(DefineHighlightedInputData inputData) {

    }
}
