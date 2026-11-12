package use_case.create_flashcard;

/**
 * Output Data for the Create Flashcard Use Case
 */
public class CreateFlashcardOutputData {

    private String question;
    private String answer;

    public CreateFlashcardOutputData(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() { return question; }

    public String getAnswer() { return answer; }

}
