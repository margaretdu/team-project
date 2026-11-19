package use_case.create_deck;

public class FlashcardOutputData {

    private final String question;
    private final String answer;

    public FlashcardOutputData(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion(){return question;}

    public String getAnswer(){return answer;}
}
