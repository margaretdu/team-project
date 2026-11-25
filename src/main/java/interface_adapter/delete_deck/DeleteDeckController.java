package interface_adapter.delete_deck;

import use_case.delete_deck.DeleteDeckInputBoundary;
import use_case.delete_deck.DeleteDeckInputData;

public class DeleteDeckController {

    private final DeleteDeckInputBoundary deleteDeckUseCase;

    public DeleteDeckController(DeleteDeckInputBoundary deleteDeckUseCase) {
        this.deleteDeckUseCase = deleteDeckUseCase;
    }

    public void execute(String name) {
        DeleteDeckInputData inputData = new DeleteDeckInputData(name);
        deleteDeckUseCase.execute(inputData);
    }
}
