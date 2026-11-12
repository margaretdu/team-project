package use_case.get_all_decks;

import entity.Deck;

import java.util.List;

/**
 * DAO interface fo
 */
public interface GetAllDecksUserDataAccessInterface {

    /**
     * @return a list of all avaliable flashcard decks
     */
    List<Deck> getAllDecks();

    /**
     * Checks if there are any available flashcard decks.
     * @return true if there are available flashcard decks and false otherwise.
     */
    boolean isEmpty();
}
