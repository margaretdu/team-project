package data_access;

import entity.Deck;
import entity.DeckFactory;
import entity.Flashcard;
import use_case.get_all_decks.GetAllDecksUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class MockUserDataAccessObject implements GetAllDecksUserDataAccessInterface {

    public MockUserDataAccessObject(DeckFactory deckFactory) {}

    private void mockDataAddFlashcards(Deck deck) {
        deck.addFlashcard(new Flashcard("question1", "answer1"));
        deck.addFlashcard(new Flashcard("question2", "answer2"));
        deck.addFlashcard(new Flashcard("question3", "answer3"));
    }

    private Deck mockDataMakeDeck(String name) {
        Deck deck = new Deck(name);
        mockDataAddFlashcards(deck);
        return deck;
    }

    public List<Deck> getAllDecks() {
        List<Deck> list = new ArrayList<>();

        list.add(mockDataMakeDeck("CSC207H1"));
        list.add(mockDataMakeDeck("MAT257Y1"));
        list.add(mockDataMakeDeck("CSC148H1"));

        return list;
    }

    public boolean isEmpty() {
        return false;
    }
}

