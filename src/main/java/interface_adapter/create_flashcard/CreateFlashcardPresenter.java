package interface_adapter.create_flashcard;

import interface_adapter.ViewManagerModel;
import interface_adapter.get_all_decks.GetAllDecksViewModel;
import use_case.create_flashcard.CreateFlashcardOutputBoundary;
import use_case.create_flashcard.CreateFlashcardOutputData;

/**
 * Presenter for the Create Flashcard Use Case.
 */
public class CreateFlashcardPresenter implements CreateFlashcardOutputBoundary {

    private final CreateFlashcardViewModel createFlashcardViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateFlashcardPresenter(ViewManagerModel viewManagerModel,
                                    CreateFlashcardViewModel createFashcardViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createFlashcardViewModel = createFashcardViewModel;
    }

    @Override
    public void prepareSuccessView(CreateFlashcardOutputData response) {
        viewManagerModel.setState(CreateFlashcardViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final CreateFlashcardState createFlashcardState = createFlashcardViewModel.getState();
        createFlashcardState.setQuestionError(error);
        createFlashcardViewModel.notifyStateChanged();
    }

    @Override
    public void switchToHomescreenView() {
        viewManagerModel.setState(GetAllDecksViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void switchToCreateFlashcardView(String name){
        final CreateFlashcardState createFlashcardState = new CreateFlashcardState();
        createFlashcardState.setDeckName(name);
        createFlashcardViewModel.setState(createFlashcardState);
        createFlashcardViewModel.notifyStateChanged();

        viewManagerModel.setState(CreateFlashcardViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();
    }
}
