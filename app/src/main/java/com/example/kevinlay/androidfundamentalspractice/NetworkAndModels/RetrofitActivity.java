package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitGithub.GithubClient;
import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitGithub.GithubRepo;
import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitMovie.MovieClient;
import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitMovie.MovieModel;
import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitMovie.Result;
import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit Activity
 *
 * Major Takeaways
 * -Needs internet permission
 *
 * Steps to using Retrofit
 *      1. Create interface that is in charge of API endpoints, see GitHubClient class
 *      2. Create model that can hold data being passed back, see GithubRepo class
 *      3. Create builder
 *          3a. Builder needs base URL + Converter Factory
 *      4. Create instance of interface using retrofit.create
 *      5. Call a method on the client that returns a call object
 *      6. Use call.enqueue to handle the response, response is returned in the response.body();
 *
 */

public class RetrofitActivity extends AppCompatActivity {

    private static final String TAG = "RetrofitActivity";

    private static final String movieApiKey = "c414f6748521b1f9e997639b2c7c92d9";

    private ListView lvRetrofitRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        lvRetrofitRepos = (ListView) findViewById(R.id.lvRetrofitRepos);
        //startRetrofit();
        startMovieRetrofit();
    }

    private void startMovieRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieClient movieClient = retrofit.create(MovieClient.class);
        Call<MovieModel> call = movieClient.getRecentMovies(movieApiKey);

        // Use this to fetch the URL to ensure your api endpoint is correct
        // call.request().url();

        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                ArrayList<String> movies = new ArrayList<>();
                MovieModel movieModel = response.body();

                for(int i = 0; i < movieModel.getResults().size(); i++) {
                    Result result = movieModel.getResults().get(i);
                    String singleMovie = "Date Released: " + result.getReleaseDate() + " Movie name: " + result.getTitle();
                    movies.add(singleMovie);
                }
                ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.simple_single_item, movies);
                lvRetrofitRepos.setAdapter(itemsAdapter);
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.toString());
            }
        });
    }

    private void startRetrofit() {

        //3
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //4
        GithubClient client = retrofit.create(GithubClient.class);

        //5
        Call<List<GithubRepo>> call = client.reposForUser("kevinlay689");
        //6
        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo> repos = response.body();

                // Creates ArrayAdapter and populates ListView
                ArrayList<String> names = new ArrayList<>();
                for(int i = 0; i < repos.size(); i++) {
                    names.add(repos.get(i).getName());
                }
                ArrayAdapter<String> itemsAdapter =
                        new ArrayAdapter<>(getApplicationContext(), R.layout.simple_single_item, names);
                lvRetrofitRepos.setAdapter(itemsAdapter);
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
