package view;

import interface_adapter.create_flashcard.CreateFlashcardController;
import interface_adapter.create_flashcard.CreateFlashcardState;
import interface_adapter.create_flashcard.CreateFlashcardViewModel;
import interface_adapter.create_flashcard.CreateFlashcardViewModelListener;

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

    private final JButton createFlashcard;
    private final JButton cancel;
    private final JButton toHomescreen;

    public CreateFlashcardView(CreateFlashcardViewModel createFlashcardViewModel) {
        this.createFlashcardViewModel = createFlashcardViewModel;
        createFlashcardViewModel.addListener(this);

        final JLabel title = new JLabel(CreateFlashcardViewModel.TITLE_LABEL);
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        final LabelTextPanel questionText = new LabelTextPanel(
                new JLabel(CreateFlashcardViewModel.QUESTION_LABEL), questionInputField);
        final LabelTextPanel answerText = new LabelTextPanel(
                new JLabel(CreateFlashcardViewModel.ANSWER_LABEL), answerInputField);

        final JPanel buttons = new JPanel();
        createFlashcard = new JButton(CreateFlashcardViewModel.CREATEFLASHCARD_BUTTON_LABEL);
        buttons.add(createFlashcard);
        cancel = new JButton(CreateFlashcardViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        toHomescreen = new JButton(CreateFlashcardViewModel.TO_HOMESCREEN_BUTTON_LABEL);
        buttons.add(toHomescreen);

        createFlashcard.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createFlashcard)) {
                            final CreateFlashcardState currentState = createFlashcardViewModel.getState();

                            createFlashcardController.execute(
                                    currentState.getQuestion(),
                                    currentState.getAnswer()
                            );
                        }
                    }
                }
        );

        toHomescreen.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        createFlashcardController.switchToHomescreenView();
                    }
                }
        );

        cancel.addActionListener(this);

        addQuestionListener();
        addAnswerListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
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
}
