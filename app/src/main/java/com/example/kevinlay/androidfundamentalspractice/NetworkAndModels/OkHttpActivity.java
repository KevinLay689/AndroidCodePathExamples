package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.kevinlay.androidfundamentalspractice.R;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * OkHttp Activity
 *
 * Major Takeaways
 * -Able to add query parameters with a builder, see setupOkHttpQueryParams()
 * -Able to add authorization header with a builder, see setupOkHttpAuthorizationHeader()
 * -Make Asynchronous calls by creating a Call object, using the enqueue() method, and passing an
 *  anonymous Callback object that implements both onFailure() and onResponse().
 * -If you need to update any views from within a response, you will need to use runOnUiThread() or
 *  post the result back on the main thread, see setupOkHttpAsynchronousCallWithViewUpdate();
 * -When processing network requests, check if the response is successful with if(!response.isSuccessfull)
 *      -Response also comes in headers as a list
 *
 */

public class OkHttpActivity extends AppCompatActivity {
    private static final String TAG = "OkHttpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        makeOkhttpRequestWithGsonParse();
    }

    /**
        This method uses Gson to map the Json returned into a javaobject.
        The properties in GitUser map to corresponding keys in the Json Array
     */
    
    private void makeOkhttpRequestWithGsonParse() {
        final OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/users/codepath")
                .build();
        
        final Gson gson = new Gson();
        // Get a handler that can be used to post to the main thread
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                
            }

            // Parse response using gson deserializer
            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // Process the data on the worker thread
                GitUser user = gson.fromJson(response.body().charStream(), GitUser.class);
                // Access deserialized user object here
                Log.i(TAG, "onResponse: " + user.toString());
            }
        });
    }
    /**
        This method parses the Json request given back using plain java
     */

    private void makeOkHttpJsonRequest() {
        final OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/users/codepath")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                try {
                    String responseData = response.body().string();
                    JSONObject json = new JSONObject(responseData);
                    final String owner = json.getString("name");
                } catch (JSONException e) {

                }
            }
        });
    }

    private void setupOkHttpAsynchronousCallWithViewUpdate() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // ... check for failure using `isSuccessful` before proceeding

                // Read data on the worker thread
                final String responseData = response.body().string();

                // Run view-related code back on the main thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView myTextView = new TextView(getApplicationContext());
                        myTextView.setText(responseData);
                    }
                });
                Log.i(TAG, "onResponse: "+responseData);

            }
        });
    }


    private void setupOkHttpAsynchronousCall() {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
            }
        });
    }

    private void setupOkHttpQueryParams() {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://ajax.googleapis.com/ajax/services/search/images").newBuilder();
        urlBuilder.addQueryParameter("v", "1.0");
        urlBuilder.addQueryParameter("q", "android");
        urlBuilder.addQueryParameter("rsz", "8");
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
    }

    private void setupOkHttpAuthorizationHeader() {
        Request request = new Request.Builder()
                .header("Authorization", "token abcd")
                .url("https://api.github.com/users/codepath")
                .build();
    }

    private void setupOkHttp() {
        // should be a singleton
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
    }
}
