package use_case.create_deck;

import java.util.List;

public class CreateDeckOutputData {

    private final String name;
    private final List<FlashcardOutputData> flashcards;

    public CreateDeckOutputData(String name,  List<FlashcardOutputData> flashcards) {
        this.name = name;
        this.flashcards = flashcards;
    }

    public String getName() { return name; }

    public  List<FlashcardOutputData> getFlashcards() { return flashcards; }
}
