package interface_adapter.delete_deck;

import java.util.ArrayList;
import java.util.List;

public class DeleteDeckViewModel {

    private final List<DeleteDeckViewModelListener> listeners = new ArrayList<>();

    private DeleteDeckState state = new DeleteDeckState();

    public DeleteDeckState getState() {
        return state;
    }

    public void setState(DeleteDeckState state) {
        this.state = state;
    }

    public void addListener(DeleteDeckViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (DeleteDeckViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}