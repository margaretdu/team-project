package use_case.define_highlighted;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DefineHighlightedInteractor implements DefineHighlightedInputBoundary{
    // Constants

    private final DefineHighlightedOutputBoundary defineHighlightedPresenter;

    public DefineHighlightedInteractor(DefineHighlightedOutputBoundary presenter) {
        this.defineHighlightedPresenter = presenter;
    }

    @Override
    public void execute(DefineHighlightedInputData inputData) {

    }
}
