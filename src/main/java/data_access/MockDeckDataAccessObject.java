package data_access;

import entity.Deck;
import entity.DeckFactory;
import entity.Flashcard;
import use_case.get_all_decks.GetAllDecksDataAccessInterface;
import use_case.get_deck.GetDeckDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * DeckDataAccessObject used for testing, gives mock data
 */
public class MockDeckDataAccessObject implements GetAllDecksDataAccessInterface, GetDeckDataAccessInterface {

    private final List<Deck> decks = new ArrayList<>();

    public MockDeckDataAccessObject(DeckFactory deckFactory) {
//        decks.add(mockDataMakeDeck("CSC207H1"));
//
//        Deck deck = new Deck("MAT257Y1");
//        mockDataAddFlashcardsShort(deck);
//        decks.add(deck);
//        decks.add(mockDataMakeDeck("CSC148H1"));
//        decks.add(mockDataMakeDeck("CSC236H1"));
//        decks.add(mockDataMakeDeck("CSC240H1"));
//        decks.add(mockDataMakeDeck("CSC258H1"));
//        decks.add(mockDataMakeDeck("MAT267H1"));
//        decks.add(mockDataMakeDeck("CSC209H1"));
//        decks.add(mockDataMakeDeck("MAT237Y1"));
//        decks.add(new Deck("ESS250H1"));
    }

    private void mockDataAddFlashcardsShort(Deck deck) {
        deck.addFlashcard(new Flashcard("question 1", "answer 1"));
        deck.addFlashcard(new Flashcard("question 2", "answer 2"));
        deck.addFlashcard(new Flashcard("question 3", "answer 3"));
    }

    private void mockDataAddFlashcards(Deck deck) {
        deck.addFlashcard(new Flashcard(
                "Checked Exceptions",
                "-like IOException these are child " +
                "classes of Exception that the developer must check (except runtime exception)\n" +
                "-The method caller must either catch or throw the exception, this is checked " +
                "when the code is compiled.\n" +
                "- use try, catch. Or throw exception\n" +
                "-use checked exceptions for conditions from which the caller can reasonably be " +
                "expected to recover."));
        deck.addFlashcard(new Flashcard(
                "Unchecked Exceptions",
                "Like Error and RuntimeException and any of their subclasses. " +
                        "You do not need to catch or declare these exceptions, " +
                        "these are the error messages you see when you code crashes."));
        deck.addFlashcard(new Flashcard(
                "Exceptions",
                "There are checked and unchecked exceptions, both of which are throwable."));
        deck.addFlashcard(new Flashcard(
                "User story",
                "As a [user] I want to [accomplish a goal] so that [I receive some benefit]"));
        deck.addFlashcard(new Flashcard(
                "Usecase",
                "Name\n" +
                "Primary Actor\n" +
                "Precondition\n" +
                "Trigger\n" +
                "success outcome\n" +
                "Main success scenario\n" +
                "extension"));
        deck.addFlashcard(new Flashcard(
                "Disability",
                "a physical or mental impairment that is associated with a personal " +
                        "or social limitation on the activities one can perform. " +
                        "You can look at disabilities through the medical or social model\n" +
                "Example, physical: paraplegia, social: not being able to access public spaces."));

        String gettysburgAddress = "Four score and seven years ago our fathers brought forth on this " +
                "continent, a new nation, conceived in Liberty, and dedicated to the " +
                "proposition that all men are created equal.\n" +
                "\n" +
                "Now we are engaged in a great civil war, testing whether that nation, or any nation " +
                "so conceived and so dedicated, can long endure. We are met on a great battle-field " +
                "of that war. We have come to dedicate a portion of that field, as a final resting " +
                "place for those who here gave their lives that that nation might live. It is " +
                "altogether fitting and proper that we should do this.\n" +
                "\n" +
                "But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not " +
                "hallow -- this ground. The brave men, living and dead, who struggled here, have " +
                "consecrated it, far above our poor power to add or detract.";
        deck.addFlashcard(new Flashcard("the Gettysburg Address", gettysburgAddress));
    }

    private Deck mockDataMakeDeck(String name) {
        Deck deck = new Deck(name);
        mockDataAddFlashcards(deck);
        return deck;
    }

    public List<Deck> getAllDecks() {
        return decks;
    }

    public boolean noAvailableDecks() {
        return decks.isEmpty();
    }

    @Override
    public boolean deckExists(String name) {
        for (Deck deck : decks) {
            if (deck.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteFlashcard(String deckName, String question) {
        Deck deck = getDeck(deckName);
        deck.removeFlashcard(question);
    }

    @Override
    public Deck getDeck(String name) {
        for (Deck deck: decks) {
            if (deck.getName().equals(name)) {
                return deck;
            }
        }
        return null;
    }

    public void addDeck(Deck deck) {
        decks.add(deck);
    }

    public void addFlashcard(String name, Flashcard flashcard) {
        for (Deck deck: decks) {
            if (deck.getName().equals(name)) {
                deck.addFlashcard(flashcard);
            }
        }
    }
}

