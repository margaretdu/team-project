package use_case.create_flashcard;

/**
 * The Input Data for the Create Flashcard Use Case.
 */
public class CreateFlashcardInputData {

    private String question;
    private String answer;
    private String deckName;

    public CreateFlashcardInputData(String question, String answer, String deckName) {
        this.question = question;
        this.answer = answer;
        this.deckName = deckName;
    }

    String getQuestion(){
        return question;
    }

    String getAnswer(){
        return answer;
    }

    String getDeckName() { return deckName; }

}
