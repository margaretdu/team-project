package use_case.get_all_decks;

import entity.Deck;
import entity.Flashcard;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class GetAllDecksInteractorTest {

    private static class TestMockDeckDataAccessObject implements GetAllDecksDataAccessInterface{
        private final List<Deck> decks;

        public TestMockDeckDataAccessObject(List<Deck> decks) {
            this.decks = decks;
        }

        @Override
        public List<Deck> getAllDecks() {
            return decks;
        }

        @Override
        public boolean noAvailableDecks() { return decks.isEmpty(); }
    }

    // presenter
    private static class OutputRecorder implements GetAllDecksOutputBoundary {
        GetAllDecksOutputData success;
        String empty;

        @Override
        public void prepareSuccessView(GetAllDecksOutputData data) {
            success = data;
        }

        @Override
        public void prepareEmptyView(String error) {
            empty = error;
        }
    }

    @Test
    void successTest() {
        List<Deck> list = new ArrayList<>();
        Deck deck1 = new Deck("CSC207H1");
        deck1.addFlashcard(new Flashcard("question1", "answer1"));
        deck1.addFlashcard(new Flashcard("question2", "answer2"));
        deck1.addFlashcard(new Flashcard("question3", "answer3"));

        Deck deck2 = new Deck("MAT257Y1");
        deck2.addFlashcard(new Flashcard("a", "b"));
        deck2.addFlashcard(new Flashcard("c", "d"));

        list.add(deck1);
        list.add(deck2);

        GetAllDecksDataAccessInterface decks = new TestMockDeckDataAccessObject(list);
        OutputRecorder recorder = new OutputRecorder();
        GetAllDecksInputBoundary interactor = new GetAllDecksInteractor(decks, recorder);
        interactor.execute();

        Map<String, Integer> map = new HashMap<>(Map.of(
                "CSC207H1", 3,
                "MAT257Y1", 2
        ));
        assertNotNull(recorder.success);
        assertEquals(map, recorder.success.getDecks());
        assertNull(recorder.empty);
    }


    @Test
    void noAvailableDecksTest() {
        GetAllDecksDataAccessInterface decks = new TestMockDeckDataAccessObject(new ArrayList<>());
        OutputRecorder recorder = new OutputRecorder();
        GetAllDecksInputBoundary interactor = new GetAllDecksInteractor(decks, recorder);
        interactor.execute();

        assertNull(recorder.success);
        assertNotNull(recorder.empty);
        assertEquals("No Flashcard Decks have been added", recorder.empty);
    }
}
