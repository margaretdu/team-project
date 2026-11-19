package interface_adapter.create_deck;

import interface_adapter.ViewManagerModel;
import use_case.create_deck.CreateDeckOutputBoundary;
import use_case.create_deck.CreateDeckOutputData;

public class CreateDeckPresenter implements CreateDeckOutputBoundary {

    private final CreateDeckViewModel createDeckViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateDeckPresenter(ViewManagerModel viewManagerModel,
                                    CreateDeckViewModel createFashcardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createDeckViewModel = createFashcardViewModel;
    }

    @Override
    public void prepareSuccessView(CreateDeckOutputData response) {
        viewManagerModel.setState(CreateDeckViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final CreateDeckState createDeckState = createDeckViewModel.getState();
        createDeckState.setNameError(error);
        createDeckViewModel.notifyStateChanged();
    }

    @Override
    public void switchToHomescreenView() {
        viewManagerModel.setState(CreateDeckViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }
}
