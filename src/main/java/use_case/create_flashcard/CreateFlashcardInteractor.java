package use_case.create_flashcard;

import entity.Flashcard;
import entity.FlashcardFactory;

/**
 * The Create Flashcard Interactor.
 */
public class CreateFlashcardInteractor implements CreateFlashcardInputBoundary{
    private final CreateFlashcardFlashcardDataAccessInterface flashcardDataAccessObject;
    private final CreateFlashcardOutputBoundary flashcardPresenter;
    private FlashcardFactory flashcardFactory;

    public CreateFlashcardInteractor(CreateFlashcardFlashcardDataAccessInterface flashcardDataAccessInterface,
                                     CreateFlashcardOutputBoundary createFlashcardOutputBoundary,
                                     FlashcardFactory flashcardFactory) {
        this.flashcardDataAccessObject = flashcardDataAccessInterface;
        this.flashcardPresenter = createFlashcardOutputBoundary;
        this.flashcardFactory = flashcardFactory;
    }

    @Override
    public void execute(CreateFlashcardInputData createFlashcardInputData) {
        if (flashcardDataAccessObject.existsByQuestion(createFlashcardInputData.getQuestion())) {
            flashcardPresenter.prepareFailView("Flashcard with this question already exists.");
        }
        else if ("".equals(createFlashcardInputData.getQuestion())) {
            flashcardPresenter.prepareFailView("Question cannot be empty");
        }
        else if ("".equals(createFlashcardInputData.getAnswer())) {
            flashcardPresenter.prepareFailView("Answer cannot be empty");
        }
        else {
            Flashcard flashcard = flashcardFactory.create(createFlashcardInputData.getQuestion(),
                                                          createFlashcardInputData.getAnswer());
            flashcardDataAccessObject.save(flashcard);

            final CreateFlashcardOutputData createFlashcardOutputData = new CreateFlashcardOutputData(flashcard.getQuestion(), flashcard.getAnswer());
            flashcardPresenter.prepareSuccessView(createFlashcardOutputData);
        }
    }


}
