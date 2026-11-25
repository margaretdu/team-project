package interface_adapter.delete_deck;

import use_case.delete_deck.DeleteDeckOutputBoundary;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary {

    private final DeleteDeckViewModel deleteDeckViewModel;

    public DeleteDeckPresenter(DeleteDeckViewModel deleteDeckViewModel) {
        this.deleteDeckViewModel = deleteDeckViewModel;
    }

    @Override
    public void prepareSuccessView() {
        DeleteDeckState state = deleteDeckViewModel.getState();
        state.setSuccess(true);
        state.setError(null);
        deleteDeckViewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteDeckState state = deleteDeckViewModel.getState();
        state.setSuccess(false);
        state.setError(error);
        deleteDeckViewModel.notifyStateChanged();
    }
}