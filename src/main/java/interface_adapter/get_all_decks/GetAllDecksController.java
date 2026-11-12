package interface_adapter.get_all_decks;

import use_case.get_all_decks.GetAllDecksInputBoundary;
import use_case.get_all_decks.GetAllDecksInputData;

/**
 * Controller for the GetAllDecks Use Case.
 */
public class GetAllDecksController {

    private final GetAllDecksInputBoundary userGetAllDecksUseCaseInteractor;

    public GetAllDecksController(GetAllDecksInputBoundary userGetAllDecksUseCaseInteractor) {
        this.userGetAllDecksUseCaseInteractor = userGetAllDecksUseCaseInteractor;
    }

    /**
     * Executes the GetAllDecks Use Case.
     */
    public void execute() {
        final GetAllDecksInputData getAllDecksInputData = new GetAllDecksInputData();

        userGetAllDecksUseCaseInteractor.execute(getAllDecksInputData);
    }

    /**
     * Executes the "switch to DeckView" Use Case.
     */
//    public void switchToDeckView() {
//        userGetAllDecksUseCaseInteractor.switchToDeckView();
//    }
}

