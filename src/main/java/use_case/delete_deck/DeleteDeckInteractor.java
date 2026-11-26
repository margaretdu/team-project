package use_case.delete_deck;

public class DeleteDeckInteractor implements DeleteDeckInputBoundary {

    private final DeleteDeckDataAccessInterface deckDataAccessObject;
    private final DeleteDeckOutputBoundary presenter;

    public DeleteDeckInteractor(
            DeleteDeckDataAccessInterface deckDataAccessObject,
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

        if (!deckDataAccessObject.existsByName(name)) {
            presenter.prepareFailView("Deck does not exist.");
            return;
        }

        deckDataAccessObject.deleteDeck(name);
        presenter.prepareSuccessView();
    }
}