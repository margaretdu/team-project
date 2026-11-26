package interface_adapter.define_highlighted;

import use_case.define_highlighted.DefineHighlightedOutputBoundary;
import use_case.define_highlighted.DefineHighlightedOutputData;

public class DefineHighlightedPresenter implements DefineHighlightedOutputBoundary {
    private final DefineHighlightedViewModel defineHighlightedViewModel;

    public DefineHighlightedPresenter(DefineHighlightedViewModel defineHighlightedViewModel) {
        this.defineHighlightedViewModel = defineHighlightedViewModel;
    }

    @Override
    public void prepareSuccessView(DefineHighlightedOutputData outputData) {
        DefineHighlightedState defineHighlightedState = new DefineHighlightedState();
        defineHighlightedState.setWord(outputData.getWord());
        defineHighlightedState.setDefinition(outputData.getDefinition());
        defineHighlightedViewModel.setState(defineHighlightedState);
        this.defineHighlightedViewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        DefineHighlightedState defineHighlightedState = new DefineHighlightedState();
        defineHighlightedState.setErrorMessage(errorMessage);
        defineHighlightedViewModel.setState(defineHighlightedState);
        this.defineHighlightedViewModel.notifyStateChanged();
    }
}
