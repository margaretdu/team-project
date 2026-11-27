package use_case.save_deck;

import entity.Deck;

/**
 * DAO interface for the Save Data use case
 */
public interface SaveDeckDataAccessInterface {
    /**
     * Gives the deck with the given name.
     * @param name the name of the deck to search for
     * @return the deck with the given name
     */
    Deck getDeck(String name);

    /**
     * Saves the deck.
     * @param deck the deck to save
     * @param filename the name of the file the deck will be saved in
     */
    void save(Deck deck, String filename);
}
