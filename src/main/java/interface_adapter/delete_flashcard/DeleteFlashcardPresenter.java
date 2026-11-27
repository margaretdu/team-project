package interface_adapter.delete_flashcard;

import use_case.delete_flashcard.DeleteFlashcardOutputBoundary;

public class DeleteFlashcardPresenter implements DeleteFlashcardOutputBoundary {

    private final DeleteFlashcardViewModel deleteFlashcardViewModel;

    public DeleteFlashcardPresenter(DeleteFlashcardViewModel deleteFlashcardViewModel) {
        this.deleteFlashcardViewModel = deleteFlashcardViewModel;
    }

    @Override
    public void prepareSuccessView() {
        DeleteFlashcardState state = new DeleteFlashcardState();
        state.setSuccess(true);
        state.setError(null);

        deleteFlashcardViewModel.setState(state);
        deleteFlashcardViewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteFlashcardState state = new DeleteFlashcardState();
        state.setSuccess(false);
        state.setError(error);

        deleteFlashcardViewModel.setState(state);
        deleteFlashcardViewModel.notifyStateChanged();
    }
}