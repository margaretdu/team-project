package view;

import interface_adapter.create_flashcard.CreateFlashcardController;
import interface_adapter.create_flashcard.CreateFlashcardState;
import interface_adapter.create_flashcard.CreateFlashcardViewModel;
import interface_adapter.create_flashcard.CreateFlashcardViewModelListener;
import interface_adapter.get_deck.GetDeckController;

import javax.swing.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The View for the Create Flashcard Use Case.
 */
public class CreateFlashcardView extends JPanel implements ActionListener, CreateFlashcardViewModelListener {

    private final CreateFlashcardViewModel createFlashcardViewModel;
    private final JTextField questionInputField = new JTextField(15);
    private final JTextField answerInputField = new JTextField(15);
    private CreateFlashcardController createFlashcardController = null;
    private GetDeckController getDeckController = null;

    public CreateFlashcardView(CreateFlashcardViewModel createFlashcardViewModel) {
        this.createFlashcardViewModel = createFlashcardViewModel;
        createFlashcardViewModel.addListener(this);
        // title
        final JLabel title = new JLabel(CreateFlashcardViewModel.TITLE_LABEL);
        title.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE_TITLE));
        title.setForeground(AppTheme.TEXT_PRIMARY);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        // question and answer fields
        JLabel questionStuff = new JLabel(CreateFlashcardViewModel.QUESTION_LABEL);
        questionStuff.setFont(new Font(AppTheme.FONT_NAME, Font.PLAIN, AppTheme.FONT_SIZE));
        final LabelTextPanel questionText = new LabelTextPanel(
                questionStuff, questionInputField);
        JLabel answerStuff = new JLabel(CreateFlashcardViewModel.ANSWER_LABEL);
        answerStuff.setFont(new Font(AppTheme.FONT_NAME, Font.PLAIN, AppTheme.FONT_SIZE));
        final LabelTextPanel answerText = new LabelTextPanel(
                answerStuff, answerInputField);

        final JPanel buttons = new JPanel();
        JButton createFlashcard = new FormattedButton("Create");
        buttons.add(createFlashcard);
        JButton cancel = new FormattedButton("Cancel");
        buttons.add(cancel);

        createFlashcard.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createFlashcard)) {
                            final CreateFlashcardState currentState =
                                    createFlashcardViewModel.getState();

                            createFlashcardController.execute(
                                    currentState.getQuestion(),
                                    currentState.getAnswer(),
                                    currentState.getDeckName()
                            );

                            getDeckController.execute(
                                    currentState.getDeckName(),
                                    "deckView"
                            );
                        }
                    }
                }
        );


        cancel.addActionListener(this);
        //TODO: this needs to go back to the deck we were on without changes

        addQuestionListener();
        addAnswerListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(Box.createVerticalStrut(30));
        this.add(questionText);
        this.add(answerText);
        this.add(buttons);
    }

    private void addQuestionListener(){
        questionInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper(){
                final CreateFlashcardState createFlashcardState = createFlashcardViewModel.getState();
                createFlashcardState.setQuestion(questionInputField.getText());
                createFlashcardViewModel.setState(createFlashcardState);
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

    private void addAnswerListener() {
        answerInputField.getDocument().addDocumentListener(new DocumentListener() {
            private void documentListenerHelper(){
                final CreateFlashcardState createFlashcardState = createFlashcardViewModel.getState();
                createFlashcardState.setAnswer(answerInputField.getText());
                createFlashcardViewModel.setState(createFlashcardState);
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
        if (createFlashcardViewModel.getState().getAnswerError() != null) {
            JOptionPane.showMessageDialog(this, createFlashcardViewModel.getState().getAnswerError());
        }
    }

    public void setCreateFlashcardController(CreateFlashcardController controller) {
        this.createFlashcardController = controller;
    }

    public void setGetDeckController(GetDeckController controller) {
        this.getDeckController = controller;
    }
}
