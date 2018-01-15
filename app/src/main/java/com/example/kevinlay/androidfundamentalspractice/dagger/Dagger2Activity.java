package com.example.kevinlay.androidfundamentalspractice.dagger;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitGithub.GithubClient;
import com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitGithub.GithubRepo;
import com.example.kevinlay.androidfundamentalspractice.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Dagger2Activity extends AppCompatActivity {

    private static final String TAG = "Dagger2Activity";

    @Inject
    OkHttpClient mOkHttpClient;

    @Inject
    Retrofit mRetroFit;

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);

        // assign singleton instances to fields
        // We need to cast to `MyApp` in order to get the right method
        ((MyApp) getApplication()).getNetComponent().inject(this);

        GithubClient client = mRetroFit.create(GithubClient.class);

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
                    Log.i(TAG, "onResponse: "+ repos.get(i).getName());
                }
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
