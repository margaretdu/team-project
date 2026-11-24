package interface_adapter.create_deck;

import use_case.create_deck.CreateDeckInputBoundary;
import use_case.create_deck.CreateDeckInputData;

public class CreateDeckController {
    private final CreateDeckInputBoundary deckCreateDeckUseCaseInteractor;

    public CreateDeckController(CreateDeckInputBoundary deckCreateDeckUseCaseInteractor) {
        this.deckCreateDeckUseCaseInteractor = deckCreateDeckUseCaseInteractor;
    }

    /**
     * Executes Create Deck Use Case.
     * @param name the name
     */
    public void execute(String name) {
        final CreateDeckInputData createDeckInputData = new CreateDeckInputData(
                name);

        deckCreateDeckUseCaseInteractor.execute(createDeckInputData);
    }

    /**
     * Executes switch to Homescreen Use Case
     */
    public void switchToHomescreenView() { deckCreateDeckUseCaseInteractor.switchToHomescreenView(); }
    public void switchToCreateDeckView() { deckCreateDeckUseCaseInteractor.switchToCreateDeckView(); }
}