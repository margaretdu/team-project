package use_case.create_deck;

/**
 * Input Boundary for actions which are related to creating a deck.
 */
public interface CreateDeckInputBoundary {

    void execute(CreateDeckInputData createDeckInputData);
    /**
     * Executes the switch to homescreen use case.
     */
    void switchToHomescreenView();
    void switchToCreateDeckView();
}
