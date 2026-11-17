package use_case.create_deck;

import entity.Flashcard;

import java.util.ArrayList;

public class CreateDeckOutputData {

    private String name;
    private ArrayList<Flashcard> flashcards;

    public CreateDeckOutputData(String name,  ArrayList<Flashcard> flashcards) {
        this.name = name;
        this.flashcards = flashcards;
    }

    public String getName() { return name; }

    public  ArrayList<Flashcard> getFlashcards() { return flashcards; }
}
