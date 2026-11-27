package use_case.import_deck;

import entity.Deck;

/**
 * DAO interface for the Import Data use case
 */
public interface ImportDeckDataAccessInterface {
    /**
     * Adds the deck to the database.
     * @param deck the deck to add
     */
    void addDeck(Deck deck);

    /**
     * Returns the deck saved in the file with the given filename
     * @param filename the filename of the file that the deck is saved in
     * @return the deck saved in the file with the given filename, or null if such a file does not exist.
     */
    Deck get(String filename);
}
