package interface_adapter.create_flashcard;

import java.util.ArrayList;
import java.util.List;

/**
 * The ViewModel for the CreateFlashcard View.
 */
public class CreateFlashcardViewModel {

    public static final String TITLE_LABEL = "Create Flashcard View";
    public static final String QUESTION_LABEL = "Type question";
    public static final String ANSWER_LABEL = "Type answer";

    public static final String CREATEFLASHCARD_BUTTON_LABEL = "Create flashcard";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    public static final String TO_HOMESCREEN_BUTTON_LABEL = "Go to Homescreen";

    private final List<CreateFlashcardViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "create flashcard";

    private CreateFlashcardState state = new CreateFlashcardState();

    public CreateFlashcardState getState() { return this.state; }

    public void setState(CreateFlashcardState state) { this.state = state; }

    public void addListener(CreateFlashcardViewModelListener listener) { listeners.add(listener); }

    public void notifyStateChanged(){
        for (CreateFlashcardViewModelListener listener : listeners){
            listener.stateChanged();
        }
    }
}
