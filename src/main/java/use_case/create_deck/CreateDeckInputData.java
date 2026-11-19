package use_case.create_deck;

import entity.Flashcard;

import java.util.ArrayList;

public class CreateDeckInputData {
    private String name;
    private ArrayList<Flashcard> flashcards;

    public CreateDeckInputData(String name) {
        this.name = name;
        this.flashcards = new ArrayList<>();
    }

    String getName(){
        return name;
    }

    ArrayList<Flashcard> getFlashcards(){
        return flashcards;
    }
}
