package view.deck_view;

import view.AppTheme;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.*;

/**
 * SwingDeckRenderer for JList in deck view
 * Sets the format of each Deck in the list
 */
public class SwingDeckRenderer extends JPanel implements ListCellRenderer<SwingDeck> {
    private final JTextArea questionLabel = new JTextArea();
    private final JTextArea answerLabel = new JTextArea();

    private final CellRendererPane rendererPane = new CellRendererPane();

    public SwingDeckRenderer() {
        setLayout(new GridLayout(1, 2, 15, 0));
        setOpaque(true);
        setBorder(new EmptyBorder(6, 12, 6, 12));
        setBackground(AppTheme.CARD_COLOR);

        questionLabel.setLineWrap(true);
        questionLabel.setWrapStyleWord(true);
        questionLabel.setOpaque(false);
        questionLabel.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE));
        questionLabel.setForeground(AppTheme.TEXT_PRIMARY);

        answerLabel.setLineWrap(true);
        answerLabel.setWrapStyleWord(true);
        answerLabel.setOpaque(false);
        answerLabel.setFont(new Font(AppTheme.FONT_NAME, Font.PLAIN, AppTheme.FONT_SIZE));
        answerLabel.setForeground(AppTheme.TEXT_PRIMARY);

        // creates line between question and answer
        questionLabel.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 0, 1, AppTheme.BORDER_COLOR),
                new EmptyBorder(0, 0, 0, 12)
        ));

        add(questionLabel);
        add(answerLabel);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends SwingDeck> list, SwingDeck deck, int index,
            boolean isSelected, boolean cellHasFocus) {

        questionLabel.setText(deck.getQuestion());
        answerLabel.setText(deck.getAnswer());

        if (isSelected) {
            setBackground(AppTheme.SELECTION_BG);
            questionLabel.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE));
            questionLabel.setForeground(AppTheme.PRIMARY_COLOR);
            answerLabel.setForeground(AppTheme.PRIMARY_COLOR);
        } else {
            setBackground(AppTheme.CARD_COLOR);
            questionLabel.setFont(new Font(AppTheme.FONT_NAME, Font.BOLD, AppTheme.FONT_SIZE));
            questionLabel.setForeground(AppTheme.TEXT_PRIMARY);
            answerLabel.setBackground(AppTheme.BG_SECONDARY);
            answerLabel.setForeground(AppTheme.TEXT_PRIMARY);
        }

        // spacing between rows
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(14, 16, 15, 16, AppTheme.BG_COLOR),
                new EmptyBorder(10, 14, 10, 14)
        ));

        // wrap the question and answer text
        int width = list.getWidth();
        if (width > 0) {
            setSize(width, Short.MAX_VALUE);
            doLayout();
        }

        return this;
    }

    public String getWordAtPoint(JList<? extends SwingDeck> list, SwingDeck deck,
                                 int index, Point clickPoint, Rectangle cellBounds) {
        // make JList render the selected flashcard
        Component comp = this.getListCellRendererComponent(
                list, deck, index, list.isSelectedIndex(index), list.hasFocus());

        list.add(rendererPane);
        try {
            rendererPane.add(comp);
            comp.setBounds(cellBounds);
            comp.validate();

            // convert the click coordinates relative to the list
            Point cellPoint = new Point(
                    clickPoint.x - cellBounds.x,
                    clickPoint.y - cellBounds.y);

            // get the textArea
            Component targetComp = SwingUtilities.getDeepestComponentAt(
                    comp, cellPoint.x, cellPoint.y);
            if (!(targetComp instanceof JTextArea)) {
                return null;
            }

            JTextArea target = (JTextArea) targetComp;

            // convert the location relative to the textArea
            Point targetPoint = SwingUtilities.convertPoint(comp, cellPoint, target);
            int offset = target.viewToModel2D(targetPoint);

            // extract the word
            int start = Utilities.getWordStart(target, offset);
            int end = Utilities.getWordEnd(target, offset);
            return target.getText(start, end - start)
                    .replaceAll("[^a-zA-Z0-9-]", "")
                    .trim();
        } catch (BadLocationException ex) {
            return null;
        } finally {
            rendererPane.remove(comp);
            list.remove(rendererPane);
        }
    }
}