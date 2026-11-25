package interface_adapter.delete_flashcard;

import use_case.delete_flashcard.DeleteFlashcardOutputBoundary;

public class DeleteFlashcardPresenter implements DeleteFlashcardOutputBoundary {

    private final DeleteFlashcardViewModel deleteFlashcardViewModel;

    public DeleteFlashcardPresenter(DeleteFlashcardViewModel deleteFlashcardViewModel) {
        this.deleteFlashcardViewModel = deleteFlashcardViewModel;
    }

    @Override
    public void prepareSuccessView() {
        DeleteFlashcardState state = deleteFlashcardViewModel.getState();
        state.setSuccess(true);
        deleteFlashcardViewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteFlashcardState state = deleteFlashcardViewModel.getState();
        state.setError(error);
        deleteFlashcardViewModel.notifyStateChanged();
    }
}