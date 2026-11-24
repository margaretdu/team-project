package interface_adapter.define_highlighted;

import java.util.ArrayList;
import java.util.List;

public class DefineHighlightedViewModel {
    private final List<DefineHighlightedViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "define highlighted";

    private DefineHighlightedState state = new DefineHighlightedState();

    public DefineHighlightedState getState() { return this.state; }

    public void setState(DefineHighlightedState state) { this.state = state; }

    public void addListener(DefineHighlightedViewModelListener listener) { listeners.add(listener); }

    public void notifyStateChanged(){
        for (DefineHighlightedViewModelListener listener : listeners){
            listener.stateChanged();
        }
    }
}
