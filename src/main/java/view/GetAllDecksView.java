package view;

import interface_adapter.get_all_decks.GetAllDecksController;
import interface_adapter.get_all_decks.GetAllDecksState;
import interface_adapter.get_all_decks.GetAllDecksViewModel;

import interface_adapter.get_all_decks.GetAllDecksViewModelListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Map;

/**
 * The View for when the user is viewing all the flashcard decks.
 */
public class GetAllDecksView extends JPanel implements ActionListener, GetAllDecksViewModelListener {

    private final GetAllDecksViewModel getAllDecksViewModel;

    private final DefaultListModel<SwingDeck> deckListModel = new DefaultListModel<>();
    private final JLabel getAllDecksErrorField = new JLabel();

//    private final JButton open;

    private GetAllDecksController getAllDecksController = null;

    // Colors
    private static final Color BG_COLOR = new Color(245, 247, 250);
    private static final Color CARD_COLOR = Color.WHITE;
    private static final Color PRIMARY_COLOR = new Color(59, 130, 246);    // Modern Blue
    private static final Color SELECTION_BG = new Color(239, 246, 255);     // Soft Blue Tint
    private static final Color TEXT_PRIMARY = new Color(30, 41, 59);        // Dark Slate
    private static final Color BADGE_BG = new Color(226, 232, 240);         // Light Gray Pill
    private static final Color BORDER_COLOR = new Color(226, 232, 240);

    // Class used for swing JList
    static class SwingDeck {
        private final String name;
        private final int count;

        public SwingDeck(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() { return name; }
        public int getCount() { return count; }
    }

    public GetAllDecksView(GetAllDecksViewModel getAllDecksViewModel) {
        this.getAllDecksViewModel = getAllDecksViewModel;
        this.getAllDecksViewModel.addListener(this);

        //title text
        final JLabel title = new JLabel("Select Flashcard Deck");
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        title.setForeground(TEXT_PRIMARY);
//
//        final JPanel buttons = new JPanel();
//        open = new JButton("Open");
//        buttons.add(open);

        this.addComponentListener(
                new ComponentAdapter() {
                    public void componentShown(ComponentEvent evt) {
                        if (evt.getSource().equals(this)) {
                            getAllDecksController.execute();
                        }
                    }
                }
        );



        this.setSize(400, 460);
        this.setLayout(new BorderLayout());

        this.add(title, BorderLayout.NORTH);
//        this.add(getAllDecksErrorField);
//        this.add(buttons);
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
        Map<String, Integer> map = state.getDecks();
        for (String name : map.keySet()) {
            deckListModel.addElement(new SwingDeck(name, map.get(name)));
        }
    }

    public void setGetAllDecksController(GetAllDecksController getAllDecksController) {
        this.getAllDecksController = getAllDecksController;
    }
}
