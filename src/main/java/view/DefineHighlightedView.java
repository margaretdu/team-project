package view;

import interface_adapter.define_highlighted.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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

        // getting stuff out of the viewmodel
        DefineHighlightedState state = defineHighlightedViewModel.getState();
        String word = state.getWord();
        String definition = state.getDefinition();

        // title text
        final JLabel title_label = new JLabel("Definition of " + word + ":");
        title_label.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE_TITLE));
        title_label.setForeground(AppTheme.TEXT_PRIMARY);

        // definition text
        final JLabel definition_label = new JLabel(definition);
        definition_label.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE_SMALL));
        definition_label.setForeground(AppTheme.TEXT_PRIMARY);

        // overall view layout
        this.setLayout(new BorderLayout(50, 7));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setBackground(AppTheme.BG_COLOR);
        this.add(title_label, BorderLayout.NORTH);
        this.add(definition_label, BorderLayout.CENTER);
    }

    @Override
    public void stateChanged() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setDefineHighlightedController(DefineHighlightedController controller) {
        this.defineHighlightedController = controller;
    }
}
