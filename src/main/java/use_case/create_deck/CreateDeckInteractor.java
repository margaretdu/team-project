package use_case.create_deck;

import entity.Deck;
import entity.DeckFactory;


public class CreateDeckInteractor implements CreateDeckInputBoundary{
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
        if (deckDataAccessObject.existsByName(createDeckInputData.getName())) {
            deckPresenter.prepareFailView("Deck with this name already exists.");
        }
        else if ("".equals(createDeckInputData.getName())) {
            deckPresenter.prepareFailView("Name cannot be empty");
        }
        else {
            Deck deck = deckFactory.create(createDeckInputData.getName());
            deckDataAccessObject.save(deck);

            final CreateDeckOutputData createDeckOutputData = new CreateDeckOutputData(deck.getName(), deck.getFlashcards());
            deckPresenter.prepareSuccessView(createDeckOutputData);
        }
    }

    @Override
    public void switchToHomescreenView() {
        deckPresenter.switchToHomescreenView();
    }

}

