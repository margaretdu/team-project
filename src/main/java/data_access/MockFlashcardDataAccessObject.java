package data_access;

import entity.Deck;
import entity.Flashcard;
import use_case.create_deck.CreateDeckDataAccessInterface;
import use_case.create_flashcard.CreateFlashcardFlashcardDataAccessInterface;
import use_case.delete_flashcard.DeleteFlashcardDataAccessInterface;

public class MockFlashcardDataAccessObject implements CreateFlashcardFlashcardDataAccessInterface,
        CreateDeckDataAccessInterface, DeleteFlashcardDataAccessInterface {
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

    @Override
    public boolean deckExists(String name) {
        return mockDeckDataAccessObject.deckExists(name);
    }

    @Override
    public void deleteFlashcard(String deckName, String question) {
        mockDeckDataAccessObject.deleteFlashcard(deckName, question);
    }

}
