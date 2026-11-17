package use_case.create_deck;

import entity.Deck;

public interface CreateDeckDataAccessInterface {

    /**
     * Checks if the given deck name exists.
     * @param name the name to look for
     * @return true if a deck with the given name exists; false otherwise
     */
    boolean existsByName(String name);
    /**
     * Saves the deck
     * @param deck the deck to save
     */
    void save(Deck deck);
}
