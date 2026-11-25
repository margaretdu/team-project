package use_case.delete_deck;

public interface DeleteDeckOutputBoundary {
    void prepareSuccessView();
    void prepareFailView(String error);
}
