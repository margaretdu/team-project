package use_case.create_flashcard;

import entity.Flashcard;

public interface CreateFlashcardFlashcardDataAccessInterface {

    /**
     * Checks if the given question exists.
     * @param name the name of the deck to search
     * @param question the question to look for
     * @return true if a flashcard with the given question exists; false otherwise
     */
    boolean existsByQuestion(String name, String question);

    /**
     * Saves the flashcard
     * @param name the name of the deck the flashcard will be saved to
     * @param flashcard the flashcard to save
     */
    void save(String name, Flashcard flashcard);
}
