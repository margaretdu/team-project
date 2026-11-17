package app;

import data_access.MockDeckDataAccessObject;
import entity.DeckFactory;
import entity.FlashcardFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_flashcard.CreateFlashcardController;
import interface_adapter.create_flashcard.CreateFlashcardPresenter;
import interface_adapter.create_flashcard.CreateFlashcardViewModel;
import interface_adapter.get_all_decks.GetAllDecksController;
import interface_adapter.get_all_decks.GetAllDecksPresenter;
import interface_adapter.get_all_decks.GetAllDecksViewModel;
import use_case.create_flashcard.CreateFlashcardInputBoundary;
import use_case.create_flashcard.CreateFlashcardInteractor;
import use_case.create_flashcard.CreateFlashcardOutputBoundary;
import use_case.get_all_decks.GetAllDecksInputBoundary;
import use_case.get_all_decks.GetAllDecksInteractor;
import use_case.get_all_decks.GetAllDecksOutputBoundary;
import view.CreateFlashcardView;
import view.HomescreenView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    final FlashcardFactory flashcardFactory = new FlashcardFactory();
    final DeckFactory deckFactory = new DeckFactory();
    final ViewManagerModel viewManagerModel = new ViewManagerModel();

    // initializing this adds it as a listener to viewManagerModel so this line is needed
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // set which data access implementation to use, can be any
    // of the classes from the data_access package

    // DAO version using local file storage
    final MockDeckDataAccessObject deckDataAccessObject = new MockDeckDataAccessObject(deckFactory);

    private HomescreenView getAllDecksView;
    private GetAllDecksViewModel getAllDecksViewModel;
    private CreateFlashcardView createFlashcardView;
    private CreateFlashcardViewModel createFlashcardViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
    public AppBuilder addCreateDeckView(){
        createDeckViewModel = new CreateDeckViewModel();
        createDeckView = new CreateDeckView(createDeckViewModel);
        cardPanel.add(createDeckView, CreateDeckViewModel.VIEW_NAME);
        return this;

    public AppBuilder addCreateFlashcardView(){
        createFlashcardViewModel = new CreateFlashcardViewModel();
        createFlashcardView = new CreateFlashcardView(createFlashcardViewModel);
        cardPanel.add(createFlashcardView, CreateFlashcardViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addCreateFlashcardUseCase() {
        final CreateFlashcardOutputBoundary createFlashcardOutputBoundary = new CreateFlashcardPresenter(viewManagerModel,
                createFlashcardViewModel);
        final CreateFlashcardInputBoundary createFlashcardInteractor = new CreateFlashcardInteractor(
                flashcardDataAccessObject, createFlashcardOutputBoundary, flashcardFactory);

        CreateFlashcardController controller = new CreateFlashcardController(createFlashcardInteractor);
        createFlashcardView.setCreateFlashcardController(controller);
        return this;
    }

     public AppBuilder addCreateDeckUseCase() {
     final CreateDeckOutputBoundary createDeckOutputBoundary = new CreateDeckPresenter(viewManagerModel,
     createDeckViewModel);
     final CreateDeckInputBoundary createDeckInteractor = new CreateDeckInteractor(
     DeckDataAccessObject, createDeckOutputBoundary, DeckFactory);

     CreateDeckController controller = new CreateDeckController(createDeckInteractor);
     createDeckView.setCreateDeckController(controller);
     return this;
     }
 */


    public AppBuilder addGetAllDecksView() {
        getAllDecksViewModel = new GetAllDecksViewModel();
        getAllDecksView = new HomescreenView(getAllDecksViewModel);
        cardPanel.add(getAllDecksView, getAllDecksViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addGetAllDecksUseCase() {
        final GetAllDecksOutputBoundary getAllDecksOutputBoundary = new GetAllDecksPresenter(viewManagerModel,
                getAllDecksViewModel);
        final GetAllDecksInputBoundary getAllDecksInteractor = new GetAllDecksInteractor(
                deckDataAccessObject, getAllDecksOutputBoundary);

        GetAllDecksController controller = new GetAllDecksController(getAllDecksInteractor);
        getAllDecksView.setGetAllDecksController(controller);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Flashcards");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(GetAllDecksViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();

        // initial execution of GetAllDecksUseCase when program starts
        getAllDecksView.initialExecuteGetAllDecks();

        return application;
    }

    // makes java swing look more modern, has gui match the operating system
    public void setGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}
    }
}
