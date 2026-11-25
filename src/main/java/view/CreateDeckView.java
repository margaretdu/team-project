package view;


import interface_adapter.create_deck.CreateDeckController;
import interface_adapter.create_deck.CreateDeckState;
import interface_adapter.create_deck.CreateDeckViewModel;
import interface_adapter.create_deck.CreateDeckViewModelListener;
import interface_adapter.get_all_decks.GetAllDecksController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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


    public CreateDeckView(CreateDeckViewModel createDeckViewModel) {
        this.setLayout(new BorderLayout(14, 14));
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setBackground(AppTheme.BG_COLOR);

        this.createDeckViewModel = createDeckViewModel;
        createDeckViewModel.addListener(this);

        // title panel
        final JLabel title = new JLabel(CreateDeckViewModel.TITLE_LABEL);
        title.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE_TITLE));
        title.setForeground(AppTheme.TEXT_PRIMARY);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        // name label
        JLabel nameStuff = new JLabel(CreateDeckViewModel.NAME_LABEL);
        nameStuff.setFont(new Font(AppTheme.FONT_NAME, Font.PLAIN, AppTheme.FONT_SIZE));
        final LabelTextPanel nameText = new LabelTextPanel(
                nameStuff, nameInputField);


        final JPanel buttons = new JPanel();
        JButton createDeck = new FormattedButton("Create Deck");
        buttons.add(createDeck);
        JButton cancel = new FormattedButton("Cancel");
        buttons.add(cancel);

        createDeck.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createDeck)) {
                            final CreateDeckState currentState = createDeckViewModel.getState();

                            currentState.setNameError(null);

                            createDeckController.execute(currentState.getName());

                            if (createDeckViewModel.getState().getNameError() == null) {
                                nameInputField.setText("");
                                getAllDecksController.execute();
                            }
                        }
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
        this.add(Box.createVerticalStrut(30));
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
        final CreateDeckState state = createDeckViewModel.getState();

        if (state.getNameError() != null) {
            JOptionPane.showMessageDialog(
                    this,
                    state.getNameError(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            state.setNameError(null);
        }
    }

    public void setCreateDeckController(CreateDeckController controller) {
        this.createDeckController = controller;
    }

    public void setGetAllDecksController(GetAllDecksController controller) {
        this.getAllDecksController = controller;
    }
}
