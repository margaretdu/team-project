package use_case.create_deck;

import entity.Deck;
import entity.DeckFactory;
import entity.Flashcard;

import java.util.ArrayList;
import java.util.List;


public class CreateDeckInteractor implements CreateDeckInputBoundary {
    private final CreateDeckDataAccessInterface deckDataAccessObject;
    private final CreateDeckOutputBoundary deckPresenter;
    private DeckFactory deckFactory;

    public CreateDeckInteractor(CreateDeckDataAccessInterface deckDataAccessInterface,
                                CreateDeckOutputBoundary createDeckOutputBoundary,
                                DeckFactory deckFactory) {
        this.deckDataAccessObject = deckDataAccessInterface;
        this.deckPresenter = createDeckOutputBoundary;
        this.deckFactory = deckFactory;
    }

    @Override
    public void execute(CreateDeckInputData createDeckInputData) {
        if (createDeckInputData.getName() == null ||
                createDeckInputData.getName().trim().isEmpty()) {
            deckPresenter.prepareFailView("Name cannot be empty");
        } else if (deckDataAccessObject.existsByName(createDeckInputData.getName())) {
            deckPresenter.prepareFailView("Deck with this name already exists.");
        } else {
            Deck deck = deckFactory.create(createDeckInputData.getName());
            deckDataAccessObject.save(deck);

            List<FlashcardOutputData> flashcardOutputData = new ArrayList<>();

            for (Flashcard flashcard : deck.getFlashcards()) {
                flashcardOutputData.add(
                        new FlashcardOutputData(
                                flashcard.getQuestion(),
                                flashcard.getAnswer()
                        )
                );
            }

            final CreateDeckOutputData createDeckOutputData =
                    new CreateDeckOutputData(deck.getName(), flashcardOutputData);

            deckPresenter.prepareSuccessView(createDeckOutputData);
        }
    }

    @Override
    public void switchToHomescreenView() {
        deckPresenter.switchToHomescreenView();
    }

}

