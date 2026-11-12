package entity;
/**
 * factory for creating deck objects
 */
public class DeckFactory {
    public Deck create(String name) { return new Deck(name); }
}
