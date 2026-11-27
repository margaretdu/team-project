package data_access;

import entity.Deck;
import entity.Flashcard;
import use_case.create_deck.CreateDeckDataAccessInterface;
import use_case.create_flashcard.CreateFlashcardFlashcardDataAccessInterface;
import use_case.get_all_decks.GetAllDecksDataAccessInterface;
import use_case.get_deck.GetDeckDataAccessInterface;

import java.util.List;
import java.util.ArrayList;

/**
 * DAO for storing deck data.
 */
public class DeckDataAccessObject implements CreateDeckDataAccessInterface,
                                             CreateFlashcardFlashcardDataAccessInterface,
                                             GetAllDecksDataAccessInterface,
                                             GetDeckDataAccessInterface {

    private List<Deck> decks;

    public DeckDataAccessObject() {
        this.decks = new ArrayList<>();
    }

    @Override
    public boolean existsByName(String name) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(name)) return true;
        }
        return false;
    }

    @Override
    public void save(Deck deck) {
        this.decks.add(deck);
    }

    @Override
    public Deck getDeck(String name) {
        for (int i = 0; i < decks.size(); i++) {
            if (decks.get(i).getName().equals(name)) return decks.get(i);
        }
        return null;
    }

    @Override
    public boolean existsByQuestion(String name, String question) {
        if (!existsByName(name)) return false;
        List<Flashcard> flashcards = getDeck(name).getFlashcards();

        for (int i = 0; i < flashcards.size(); i++) {
            if (flashcards.get(i).getQuestion().equals(question)) return true;
        }
        return false;
    }

    @Override
    public void save(String name, Flashcard flashcard) {
        if (!existsByName(name)) return;
        Deck deck = getDeck(name);
        deck.addFlashcard(flashcard);
    }

    @Override
    public List<Deck> getAllDecks() {
        return this.decks;
    }

    @Override
    public boolean noAvailableDecks() {
        return !this.decks.isEmpty();
    }

    @Override
    public boolean deckExists(String name) {
        return existsByName(name);
    }
}
