package view;

import interface_adapter.define_highlighted.DefineHighlightedController;
import interface_adapter.define_highlighted.DefineHighlightedViewModel;
import interface_adapter.define_highlighted.DefineHighlightedViewModelListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * DefineHighlighted view.
 */
public class DefineHighlightedView extends JPanel implements ActionListener, DefineHighlightedViewModelListener {

    private final DefineHighlightedViewModel defineHighlightedViewModel;
    private DefineHighlightedController defineHighlightedController = null;

    public DefineHighlightedView(DefineHighlightedViewModel defineHighlightedViewModel) {
        this.defineHighlightedViewModel = defineHighlightedViewModel;
        defineHighlightedViewModel.addListener(this);
    }

    @Override
    public void stateChanged() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
