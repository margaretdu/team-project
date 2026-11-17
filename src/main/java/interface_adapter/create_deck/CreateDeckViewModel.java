package interface_adapter.create_deck;

import java.util.ArrayList;
import java.util.List;

public class CreateDeckViewModel {

    public static final String TITLE_LABEL = "Create Deck View";
    public static final String NAME_LABEL = "Type name";

    public static final String CREATEDECK_BUTTON_LABEL = "Create deck";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String TO_HOMESCREEN_BUTTON_LABEL = "Go to Homescreen";

    private final List<CreateDeckViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "create deck";

    private CreateDeckState state = new CreateDeckState();

    public CreateDeckState getState() { return this.state; }

    public void setState(CreateDeckState state) { this.state = state; }

    public void addListener(CreateDeckViewModelListener listener) { listeners.add(listener); }

    public void notifyStateChanged(){
        for (CreateDeckViewModelListener listener : listeners){
            listener.stateChanged();
        }
    }
}
