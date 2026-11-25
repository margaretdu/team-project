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
    private static final String API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en";
    private static final String MEANINGS = "meanings";
    private static final String DEFINITIONS = "definitions";
    private static final String DEFINITION = "definition";
    private static final String EXAMPLE = "example";

    private final DefineHighlightedOutputBoundary defineHighlightedPresenter;

    public DefineHighlightedInteractor(DefineHighlightedOutputBoundary presenter) {
        this.defineHighlightedPresenter = presenter;
    }

    @Override
    public void execute(DefineHighlightedInputData inputData) throws IOException {
        //TODO

        // for making requests to the dictionary API
        final OkHttpClient client = new OkHttpClient();
        JSONObject responseBody;
        String word = inputData.getWord();

        // making the url
        String url = API_URL + word;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            responseBody = new JSONObject(response.body().string());
        }
    }
}
