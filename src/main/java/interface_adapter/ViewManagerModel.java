package interface_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for View Manager. The state is the name of the active View
 * The initial state used is "".
 */
public class ViewManagerModel {
    private final List<ViewManagerModelListener> listeners = new ArrayList<>();

    private String currentView = "";

    public String getCurrentView() {
        return this.currentView;
    }

    public void setState(String currentView) {
        this.currentView = currentView;
    }

    public void addListener(ViewManagerModelListener listener) {
        listeners.add(listener);
    }

    public void notifyViewChanged() {
        for (ViewManagerModelListener listener : listeners) {
            listener.viewChanged();
        }
    }
}
