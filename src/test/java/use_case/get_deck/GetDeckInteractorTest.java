package use_case.get_deck;

import entity.Deck;
import entity.Flashcard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GetDeckInteractorTest {

    private static class TestMockDeckDataAccessObject implements GetDeckDataAccessInterface {
        private List<Deck> decks;

        public TestMockDeckDataAccessObject(List<Deck> decks) {
            this.decks = decks;
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
        public Deck getDeck(String name) {
            for (Deck deck : decks) {
                if (deck.getName().equals(name)) {
                    return deck;
                }
            }
            return null;
        }
    }

    // presenter
    private static class OutputRecorder implements GetDeckOutputBoundary {
        GetDeckOutputData success;
        String failure;
        GetDeckOutputData empty;
        String failureEmpty;

        @Override
        public void prepareSuccessView(GetDeckOutputData data) {
            success = data;
        }

        @Override
        public void prepareFailView(String error) {
            failure = error;
        }

        @Override
        public void prepareEmptyView(GetDeckOutputData outputData, String errorMessage) {
            empty = outputData;
            failureEmpty = errorMessage;
        }

        @Override
        public void switchToDeckView() {
            // do not need to test
        }

        @Override
        public void switchToStudyView() {
            // do not need to test
        }
    }

    @Test
    void successTest() {
        List<Deck> list = new ArrayList<>();
        Deck deck1 = new Deck("CSC207H1");
        deck1.addFlashcard(new Flashcard("question1", "answer1"));
        deck1.addFlashcard(new Flashcard("question2", "answer2"));
        deck1.addFlashcard(new Flashcard("question3", "answer3"));

        list.add(deck1);

        GetDeckInputData inputData = new GetDeckInputData("CSC207H1", "deckView");
        GetDeckDataAccessInterface deck = new TestMockDeckDataAccessObject(list);

        OutputRecorder recorder = new OutputRecorder();
        GetDeckInputBoundary interactor = new GetDeckInteractor(deck, recorder);
        interactor.execute(inputData);

        assertNull(recorder.failure);
        assertNull(recorder.failureEmpty);
        assertNull(recorder.empty);

        assertNotNull(recorder.success);
        assertEquals("CSC207H1", recorder.success.getName());

        List<Map<String, String>> flashcards = new ArrayList<>();
        flashcards.add(new HashMap<>(Map.of("question1", "answer1")));
        flashcards.add(new HashMap<>(Map.of("question2", "answer2")));
        flashcards.add(new HashMap<>(Map.of("question3", "answer3")));
        assertEquals(flashcards, recorder.success.getFlashcards());

    }


    @Test
    void deckDoesNotExistTest() {
        List<Deck> list = new ArrayList<>();
        Deck deck1 = new Deck("MAT257Y1");
        deck1.addFlashcard(new Flashcard("question1", "answer1"));
        deck1.addFlashcard(new Flashcard("question2", "answer2"));
        deck1.addFlashcard(new Flashcard("question3", "answer3"));

        list.add(deck1);

        GetDeckInputData inputData = new GetDeckInputData("MAT237Y1", "deckView");
        GetDeckDataAccessInterface decks = new TestMockDeckDataAccessObject(list);
        OutputRecorder recorder = new OutputRecorder();

        GetDeckInputBoundary interactor = new GetDeckInteractor(decks, recorder);
        interactor.execute(inputData);

        assertNull(recorder.failureEmpty);
        assertNull(recorder.empty);
        assertNull(recorder.success);
        assertNotNull(recorder.failure);

        assertEquals("Deck does not exist", recorder.failure);
    }

    @Test
    void deckHasNoFlashcardsStudyTest() {
        List<Deck> list = new ArrayList<>();
        Deck deck3 = new Deck("emptyDeck");
        list.add(deck3);

        GetDeckInputData inputData = new GetDeckInputData("emptyDeck", "studyView");
        GetDeckDataAccessInterface decks = new TestMockDeckDataAccessObject(list);

        OutputRecorder recorder = new OutputRecorder();

        GetDeckInputBoundary interactor = new GetDeckInteractor(decks, recorder);
        interactor.execute(inputData);

        assertNull(recorder.failureEmpty);
        assertNull(recorder.empty);
        assertNull(recorder.success);
        assertNotNull(recorder.failure);

        assertEquals("There are no flashcards in this deck", recorder.failure);
    }

    @Test
    void deckHasNoFlashcardsDeckTest() {
        List<Deck> list = new ArrayList<>();
        Deck deck3 = new Deck("emptyDeck");
        list.add(deck3);

        GetDeckInputData inputData = new GetDeckInputData("emptyDeck", "deckView");
        GetDeckDataAccessInterface decks = new TestMockDeckDataAccessObject(list);

        OutputRecorder recorder = new OutputRecorder();

        GetDeckInputBoundary interactor = new GetDeckInteractor(decks, recorder);
        interactor.execute(inputData);

        assertNotNull(recorder.failureEmpty);
        assertNotNull(recorder.empty);
        assertNull(recorder.success);
        assertNull(recorder.failure);

        assertEquals("There are no flashcards in this deck", recorder.failureEmpty);
        assertEquals(new ArrayList<>(), recorder.empty.getFlashcards());
        assertEquals("emptyDeck", recorder.empty.getName());
    }
}

