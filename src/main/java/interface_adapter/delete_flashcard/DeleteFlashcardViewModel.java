package interface_adapter.delete_flashcard;

import java.util.ArrayList;
import java.util.List;

public class DeleteFlashcardViewModel {

    private final List<DeleteFlashcardViewModelListener> listeners = new ArrayList<>();

    private DeleteFlashcardState state = new DeleteFlashcardState();

    public DeleteFlashcardState getState() {
        return this.state;
    }

    public void setState(DeleteFlashcardState state) {
        this.state = state;
    }

    public void addListener(DeleteFlashcardViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (DeleteFlashcardViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}