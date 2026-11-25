package use_case.delete_deck;

public class DeleteDeckInputData {
    private final String name;
    public DeleteDeckInputData(String name) {
        this.name = name;
    }
    public String getName() {return name;}
}
