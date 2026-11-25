package api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * DictionaryDatabase class.
 */
public class DictionaryDatabase {
    // constants

    private static final String API_URL = "https://api.dictionaryapi.dev/api/v2/entries/en";
    private static final String MEANINGS = "meanings";
    private static final String DEFINITIONS = "definitions";
    private static final String DEFINITION = "definition";
    private static final String EXAMPLE = "example";

    // helper function
    /**
     * Requests the dictionary API for a word. Returns the JSONObject formatted request.
     * @param word
     */
    public static JSONObject GetResponse(String word) {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Making the URL according to the original README
        String url = API_URL + word;

        // Building the request
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            // Getting the response
            Response response = client.newCall(request).execute();
            return new JSONObject(response.body().string());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Gets the definition for a word.
     * @param word
     */
    public static String GetDefinition(String word) {

        final JSONObject responseBody = GetResponse(word);

        return responseBody.getJSONObject(MEANINGS)
                .getJSONObject(DEFINITIONS)
                .getString(DEFINITION);

    }

}
