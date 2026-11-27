package data_access;

import entity.Deck;
import entity.Flashcard;
import use_case.import_deck.ImportDeckDataAccessInterface;
import use_case.save_deck.SaveDeckDataAccessInterface;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONArray;

/**
 * DAO for deck data implemented using Files to persist the data.
 */
public class FileDataAccessObject implements SaveDeckDataAccessInterface,
                                             ImportDeckDataAccessInterface {

    private final DeckDataAccessObject deckDataAccessObject;

    public FileDataAccessObject(DeckDataAccessObject deckDataAccessObject) {
        this.deckDataAccessObject = deckDataAccessObject;
    }

    private JSONObject convertJSON(Deck deck) {
        List<Flashcard> flashcards = deck.getFlashcards();

        JSONArray flashcardArray = new JSONArray();
        for (int i = 0; i < deck.getFlashcardCount(); i++) {
            JSONObject flashcardObject = new JSONObject();

            flashcardObject.put("question", flashcards.get(i).getQuestion());
            flashcardObject.put("answer", flashcards.get(i).getAnswer());

            flashcardArray.put(flashcardObject);
        }

        JSONObject deckObject = new JSONObject();

        deckObject.put("name", deck.getName());
        deckObject.put("flashcards", flashcardArray);

        return deckObject;
    }

    private Deck parseJSON(JSONObject deckObject) {
        String name = deckObject.getString("name");

        Deck deck = new Deck(name);

        JSONArray flashcardArray = deckObject.getJSONArray("flashcards");
        for (int i = 0; i < flashcardArray.length(); i++) {
            JSONObject flashcardObject = flashcardArray.getJSONObject(i);

            String question = flashcardObject.getString("question");
            String answer = flashcardObject.getString("answer");

            deck.addFlashcard(new Flashcard(question, answer));
        }

        return deck;
    }

    @Override
    public void save(Deck deck, String filename) {
        JSONObject deckObject = convertJSON(deck);
        try {
            Files.writeString(Path.of(filename), deckObject.toString());
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Deck getDeck(String name) {
        return deckDataAccessObject.getDeck(name);
    }

    @Override
    public Deck get(String filename) {
        try {
            JSONObject deckObject = new JSONObject(Files.readString(Path.of(filename)));
            return parseJSON(deckObject);
        }
        catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void addDeck(Deck deck) {
        deckDataAccessObject.save(deck);
    }
}
