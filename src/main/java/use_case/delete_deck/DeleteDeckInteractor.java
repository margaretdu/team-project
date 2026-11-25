package use_case.delete_deck;

import use_case.get_all_decks.GetAllDecksDataAccessInterface;

public class DeleteDeckInteractor implements DeleteDeckInputBoundary {

    private final GetAllDecksDataAccessInterface deckDataAccessObject;
    private final DeleteDeckOutputBoundary presenter;

    public DeleteDeckInteractor(
            GetAllDecksDataAccessInterface deckDataAccessObject,
            DeleteDeckOutputBoundary presenter) {
        this.deckDataAccessObject = deckDataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(DeleteDeckInputData inputData) {

        String name = inputData.getName();

        if (name == null || name.trim().isEmpty()) {
            presenter.prepareFailView("Deck name cannot be empty.");
            return;
        }

        boolean deckExists = false;

        for (entity.Deck deck : deckDataAccessObject.getAllDecks()) {
            if (deck.getName().equals(name)) {
                deckExists = true;
                break;
            }
        }

        if (!deckExists) {
            presenter.prepareFailView("Deck does not exist.");
            return;
        }

        deckDataAccessObject.deleteDeck(name);
        presenter.prepareSuccessView();
    }
}
