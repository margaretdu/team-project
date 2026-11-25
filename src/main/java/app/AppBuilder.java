package app;

import data_access.MockDeckDataAccessObject;
import data_access.MockFlashcardDataAccessObject;
import entity.DeckFactory;
import entity.FlashcardFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_deck.CreateDeckController;
import interface_adapter.create_deck.CreateDeckPresenter;
import interface_adapter.create_deck.CreateDeckViewModel;
import interface_adapter.create_flashcard.CreateFlashcardController;
import interface_adapter.create_flashcard.CreateFlashcardPresenter;
import interface_adapter.create_flashcard.CreateFlashcardViewModel;
import interface_adapter.get_all_decks.GetAllDecksController;
import interface_adapter.get_all_decks.GetAllDecksPresenter;
import interface_adapter.get_all_decks.GetAllDecksViewModel;
import interface_adapter.get_deck.GetDeckController;
import interface_adapter.get_deck.GetDeckPresenter;
import interface_adapter.get_deck.deck_view.GetDeckViewModel;
import interface_adapter.get_deck.study_view.StudyViewModel;
import use_case.create_deck.CreateDeckInputBoundary;
import use_case.create_deck.CreateDeckInteractor;
import use_case.create_deck.CreateDeckOutputBoundary;
import use_case.create_flashcard.CreateFlashcardInputBoundary;
import use_case.create_flashcard.CreateFlashcardInteractor;
import use_case.create_flashcard.CreateFlashcardOutputBoundary;
import use_case.get_all_decks.GetAllDecksInputBoundary;
import use_case.get_all_decks.GetAllDecksInteractor;
import use_case.get_all_decks.GetAllDecksOutputBoundary;
import use_case.get_deck.GetDeckInputBoundary;
import use_case.get_deck.GetDeckInteractor;
import use_case.get_deck.GetDeckOutputBoundary;
import view.*;
import view.deck_view.DeckView;
import view.deck_view.StudyView;
import interface_adapter.delete_flashcard.DeleteFlashcardController;
import interface_adapter.delete_flashcard.DeleteFlashcardPresenter;
import interface_adapter.delete_flashcard.DeleteFlashcardViewModel;
import use_case.delete_flashcard.DeleteFlashcardInputBoundary;
import use_case.delete_flashcard.DeleteFlashcardInteractor;
import use_case.delete_flashcard.DeleteFlashcardOutputBoundary;
import interface_adapter.delete_deck.DeleteDeckController;
import interface_adapter.delete_deck.DeleteDeckPresenter;
import interface_adapter.delete_deck.DeleteDeckViewModel;
import use_case.delete_deck.DeleteDeckInputBoundary;
import use_case.delete_deck.DeleteDeckInteractor;
import use_case.delete_deck.DeleteDeckOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    final DeckFactory deckFactory = new DeckFactory();
    final ViewManagerModel viewManagerModel = new ViewManagerModel();

    // initializing this adds it as a listener to viewManagerModel so this line is needed
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // set which data access implementation to use, can be any
    // of the classes from the data_access package

    // DAO version using local file storage
    final MockDeckDataAccessObject deckDataAccessObject = new MockDeckDataAccessObject(deckFactory);
    final MockFlashcardDataAccessObject flashcardDataAccessObject = new MockFlashcardDataAccessObject(deckDataAccessObject);

    private HomescreenView homescreenView;
    private GetAllDecksViewModel getAllDecksViewModel;

    private DeckView deckView;
    private GetDeckViewModel getDeckViewModel;

    private StudyView studyView;
    private StudyViewModel studyViewModel;

    private CreateFlashcardView createFlashcardView;
    private CreateFlashcardViewModel createFlashcardViewModel;

    private CreateDeckView createDeckView;
    private CreateDeckViewModel createDeckViewModel;

    private DeleteFlashcardViewModel deleteFlashcardViewModel;

    private DeleteDeckViewModel deleteDeckViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public AppBuilder addHomescreenView() {
        getAllDecksViewModel = new GetAllDecksViewModel();
        homescreenView = new HomescreenView(getAllDecksViewModel);
        cardPanel.add(homescreenView, GetAllDecksViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addDeckView() {
        getDeckViewModel = new GetDeckViewModel();
        deckView = new DeckView(getDeckViewModel);
        cardPanel.add(deckView, GetDeckViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addStudyView() {
        studyViewModel = new StudyViewModel();
        studyView = new StudyView(studyViewModel);
        cardPanel.add(studyView, StudyViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addCreateDeckView() {
        createDeckViewModel = new CreateDeckViewModel();
        createDeckView = new CreateDeckView(createDeckViewModel);
        cardPanel.add(createDeckView, CreateDeckViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addCreateFlashcardView(){
        createFlashcardViewModel = new CreateFlashcardViewModel();
        createFlashcardView = new CreateFlashcardView(createFlashcardViewModel);
        cardPanel.add(createFlashcardView, CreateFlashcardViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addGetAllDecksUseCase() {
        final GetAllDecksOutputBoundary getAllDecksOutputBoundary = new GetAllDecksPresenter(viewManagerModel,
                getAllDecksViewModel);
        final GetAllDecksInputBoundary getAllDecksInteractor = new GetAllDecksInteractor(
                deckDataAccessObject, getAllDecksOutputBoundary);

        GetAllDecksController controller = new GetAllDecksController(getAllDecksInteractor);
        homescreenView.setGetAllDecksController(controller);
        deckView.setGetAllDecksController(controller);
        studyView.setGetAllDecksController(controller);
        createDeckView.setGetAllDecksController(controller);
        return this;
    }

    public AppBuilder addGetDeckUseCase() {
        final GetDeckOutputBoundary getDeckOutputBoundary = new GetDeckPresenter(viewManagerModel,
                getAllDecksViewModel, getDeckViewModel, studyViewModel);

        final GetDeckInputBoundary getDeckInteractor = new GetDeckInteractor(
                deckDataAccessObject, getDeckOutputBoundary);

        GetDeckController controller = new GetDeckController(getDeckInteractor);
        deckView.setGetDeckController(controller);
        homescreenView.setGetDeckController(controller);
        createFlashcardView.setGetDeckController(controller);
        return this;
    }

    public AppBuilder addCreateFlashcardUseCase() {
        final CreateFlashcardOutputBoundary createFlashcardOutputBoundary = new CreateFlashcardPresenter(viewManagerModel,
                createFlashcardViewModel);
        FlashcardFactory flashcardFactory = new FlashcardFactory();
        final CreateFlashcardInputBoundary createFlashcardInteractor = new CreateFlashcardInteractor(
                flashcardDataAccessObject, createFlashcardOutputBoundary, flashcardFactory);

        CreateFlashcardController controller = new CreateFlashcardController(createFlashcardInteractor);
        createFlashcardView.setCreateFlashcardController(controller);
        deckView.setCreateFlashcardController(controller);
        return this;
    }

    public AppBuilder addCreateDeckUseCase() {
        final CreateDeckOutputBoundary createDeckOutputBoundary = new CreateDeckPresenter(viewManagerModel,
                createDeckViewModel);
        final CreateDeckInputBoundary createDeckInteractor = new CreateDeckInteractor(
                flashcardDataAccessObject, createDeckOutputBoundary, new DeckFactory());

        CreateDeckController controller = new CreateDeckController(createDeckInteractor);
        createDeckView.setCreateDeckController(controller);
        homescreenView.setCreateDeckController(controller);
        return this;
    }

    public AppBuilder addDeleteFlashcardUseCase() {
        deleteFlashcardViewModel = new DeleteFlashcardViewModel();

        final DeleteFlashcardOutputBoundary deleteFlashcardOutputBoundary =
                new DeleteFlashcardPresenter(deleteFlashcardViewModel);

        final DeleteFlashcardInputBoundary deleteFlashcardInteractor =
                new DeleteFlashcardInteractor(
                        deckDataAccessObject,
                        deleteFlashcardOutputBoundary
                );

        DeleteFlashcardController controller =
                new DeleteFlashcardController(deleteFlashcardInteractor);

        deckView.setDeleteFlashcardController(controller);

        return this;
    }

    public AppBuilder addDeleteDeckUseCase() {

        deleteDeckViewModel = new DeleteDeckViewModel();

        final DeleteDeckOutputBoundary deleteDeckOutputBoundary =
                new DeleteDeckPresenter(deleteDeckViewModel);

        final DeleteDeckInputBoundary deleteDeckInteractor =
                new DeleteDeckInteractor(
                        deckDataAccessObject,
                        deleteDeckOutputBoundary
                );

        DeleteDeckController controller =
                new DeleteDeckController(deleteDeckInteractor);

        homescreenView.setDeleteDeckController(controller);

        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Flashcards");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(GetAllDecksViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();

        // initial execution of GetAllDecksUseCase when program starts
        homescreenView.initialExecuteGetAllDecks();

        return application;
    }

    // makes java swing look more modern, has gui match the operating system
    public void setGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) { /* if not supported then ignore */}
    }
}
