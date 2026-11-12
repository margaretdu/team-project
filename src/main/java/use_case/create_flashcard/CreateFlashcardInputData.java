package use_case.create_flashcard;

/**
 * The Input Data for the Create Flashcard Use Case.
 */
public class CreateFlashcardInputData {

    private String question;
    private String answer;

    public CreateFlashcardInputData(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    String getQuestion(){
        return question;
    }

    String getAnswer(){
        return answer;
    }

}
