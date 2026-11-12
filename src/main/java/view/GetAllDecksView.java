package view;

import interface_adapter.get_all_decks.GetAllDecksController;
import interface_adapter.get_all_decks.GetAllDecksState;
import interface_adapter.get_all_decks.GetAllDecksViewModel;

import interface_adapter.get_all_decks.GetAllDecksViewModelListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View for when the user is viewing all the flashcard decks.
 */
public class GetAllDecksView extends JPanel implements ActionListener, GetAllDecksViewModelListener {

    private final GetAllDecksViewModel getAllDecksViewModel;

    private final JLabel getAllDecksErrorField = new JLabel();

    private final JButton open;

    private GetAllDecksController getAllDecksController = null;

    public GetAllDecksView(GetAllDecksViewModel getAllDecksViewModel) {
        this.getAllDecksViewModel = getAllDecksViewModel;
        this.getAllDecksViewModel.addListener(this);

        final JLabel title = new JLabel("Select Flashcard Deck");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        open = new JButton("Open");
        buttons.add(open);

//        open.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(open)) {
//                            final GetAllDecksState currentState = getAllDecksViewModel.getState();
//
//                            getAllDecksController.execute(
//                                    currentState.getSelectedDeck()
//                            );
//                        }
//                    }
//                }
//        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(getAllDecksErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void stateChanged() {
        setFields(getAllDecksViewModel.getState());
        getAllDecksErrorField.setText(getAllDecksViewModel.getState().getGetAllDecksError());
    }

    private void setFields(GetAllDecksState state) {
//        usernameInputField.setText(state.getUsername());
    }

    public void setGetAllDecksController(GetAllDecksController getAllDecksController) {
        this.getAllDecksController = getAllDecksController;
    }
}
