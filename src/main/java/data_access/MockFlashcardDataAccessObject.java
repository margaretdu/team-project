package data_access;

import entity.Deck;
import entity.Flashcard;
import use_case.create_deck.CreateDeckDataAccessInterface;
import use_case.create_flashcard.CreateFlashcardFlashcardDataAccessInterface;

public class MockFlashcardDataAccessObject implements CreateFlashcardFlashcardDataAccessInterface,
        CreateDeckDataAccessInterface {
    private final MockDeckDataAccessObject mockDeckDataAccessObject;

    public MockFlashcardDataAccessObject(MockDeckDataAccessObject mockDeckDataAccessObject) {
        this.mockDeckDataAccessObject = mockDeckDataAccessObject;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    @Override
    public void save(Deck deck) {
        mockDeckDataAccessObject.addDeck(deck);
    }

    @Override
    public boolean existsByQuestion(String question) {
        return false;
    }

    @Override
    public void save(String name, Flashcard flashcard) {
        mockDeckDataAccessObject.addFlashcard(name, flashcard);
    }
}
