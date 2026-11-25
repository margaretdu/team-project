package interface_adapter.delete_flashcard;

public class DeleteFlashcardState {

    private boolean success = false;
    private String error = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}