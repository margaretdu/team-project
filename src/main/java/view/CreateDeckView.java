package view;


import interface_adapter.create_deck.CreateDeckController;
import interface_adapter.create_deck.CreateDeckState;
import interface_adapter.create_deck.CreateDeckViewModel;
import interface_adapter.create_deck.CreateDeckViewModelListener;
import interface_adapter.get_all_decks.GetAllDecksController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateDeckView extends JPanel implements ActionListener, CreateDeckViewModelListener {

    private final CreateDeckViewModel createDeckViewModel;
    private final JTextField nameInputField = new JTextField(15);
    private CreateDeckController createDeckController = null;
    private GetAllDecksController getAllDecksController = null;

    private final JButton createDeck;
    private final JButton cancel;
    private final JButton toHomescreen;

    public CreateDeckView(CreateDeckViewModel createDeckViewModel) {
        this.createDeckViewModel = createDeckViewModel;
        createDeckViewModel.addListener(this);

        final JLabel title = new JLabel(CreateDeckViewModel.TITLE_LABEL);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        final LabelTextPanel nameText = new LabelTextPanel(
                new JLabel(CreateDeckViewModel.NAME_LABEL), nameInputField);

        final JPanel buttons = new JPanel();
        createDeck = new JButton(CreateDeckViewModel.CREATEDECK_BUTTON_LABEL);
        buttons.add(createDeck);
        cancel = new JButton(CreateDeckViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        toHomescreen = new JButton(CreateDeckViewModel.TO_HOMESCREEN_BUTTON_LABEL);
        buttons.add(toHomescreen);

        createDeck.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createDeck)) {
                            final CreateDeckState currentState = createDeckViewModel.getState();

                            createDeckController.execute(
                                    currentState.getName()
                            );
                            getAllDecksController.execute();
                        }
                    }
                }
        );

        toHomescreen.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
//                        getAllDecksController.execute();
                    }
                }
        );

        cancel.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        createDeckController.switchToHomescreenView();
                    }
                }
        );

        addNameListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(nameText);
        this.add(buttons);
    }

    private void addNameListener(){
        nameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper(){
                final CreateDeckState createDeckState = createDeckViewModel.getState();
                createDeckState.setName(nameInputField.getText());
                createDeckViewModel.setState(createDeckState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) { JOptionPane.showMessageDialog(this, "Cancel not implemented yet");}

    @Override
    public void stateChanged() {
        if (createDeckViewModel.getState().getNameError() != null) {
            JOptionPane.showMessageDialog(this, createDeckViewModel.getState().getNameError());
        }
    }

    public void setCreateDeckController(CreateDeckController controller) {
        this.createDeckController = controller;
    }

    public void setGetAllDecksController(GetAllDecksController controller) {
        this.getAllDecksController = controller;
    }
}
