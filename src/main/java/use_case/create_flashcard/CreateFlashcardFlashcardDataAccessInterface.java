package use_case.create_flashcard;

import entity.Flashcard;

public interface CreateFlashcardFlashcardDataAccessInterface {

    /**
     * Checks if the given question exists.
     * @param question the question to look for
     * @return true if a flashcard with the given question exists; false otherwise
     */
    boolean existsByQuestion(String question);

    /**
     * Saves the flashcard
     * @param flashcard the flashcard to save
     */
    void save(Flashcard flashcard);
}
