package use_case.define_highlighted;

import api.DictionaryInteractor;

public class DefineHighlightedInteractor implements DefineHighlightedInputBoundary{
    // Constants

    private final DefineHighlightedOutputBoundary defineHighlightedPresenter;

    public DefineHighlightedInteractor(DefineHighlightedOutputBoundary presenter) {
        this.defineHighlightedPresenter = presenter;
    }

    @Override
    public void execute(DefineHighlightedInputData inputData) {
        final String word = inputData.getWord();
        final String definition = DictionaryInteractor.GetDefinition(word);

        DefineHighlightedOutputData outputData = new DefineHighlightedOutputData(word, definition);

        defineHighlightedPresenter.prepareSuccessView(outputData);

    }
}
