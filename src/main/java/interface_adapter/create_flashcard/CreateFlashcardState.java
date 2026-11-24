package interface_adapter.create_flashcard;

public class CreateFlashcardState {
    private String question = "";
    private String answer = "";
    private String questionError;
    private String answerError;
    private String deckName = "";

    public String getQuestion() { return question; }

    public String getAnswer() { return answer; }

    public String getQuestionError() { return questionError; }

    public String getAnswerError() { return answerError; }

    public String getDeckName() { return deckName; }

    public void setQuestion(String question) { this.question = question; }

    public void setAnswer(String answer) { this.answer = answer; }

    public void setQuestionError(String questionError) { this.questionError = questionError; }

    public void setAnswerError(String answerError) {this.answerError = answerError; }

    public void setDeckName(String name) { this.deckName = name;}

    @Override
    public String toString() {
        return "CreateFlashcardState{"
                + "question='" + question + '\''
                +", answer='" + answer + '\''
                + '}';
    }
}
