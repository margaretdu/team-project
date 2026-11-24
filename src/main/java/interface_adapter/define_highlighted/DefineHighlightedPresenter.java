package interface_adapter.define_highlighted;

import use_case.define_highlighted.DefineHighlightedOutputBoundary;
import use_case.define_highlighted.DefineHighlightedOutputData;

public class DefineHighlightedPresenter implements DefineHighlightedOutputBoundary {

    @Override
    public void prepareSuccessView(DefineHighlightedOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
