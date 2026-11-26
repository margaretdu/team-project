package use_case.delete_deck;

public interface DeleteDeckDataAccessInterface {
    boolean existsByName(String name);
    void deleteDeck(String name);
}
