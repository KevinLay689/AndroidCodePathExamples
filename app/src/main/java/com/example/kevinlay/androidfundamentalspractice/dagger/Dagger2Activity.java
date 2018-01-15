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

/**
 * Dagger 2 Activity
 *
 * -Must understand some annotations before using dagger 2
 *
 * @Module
 * -Use this annotation on a class to signal to Dagger to search within the available methods for possible
 * instance providers.
 * -See NetModule
 *
 * @Provides
 * -Use this annotation on a method to signal to Dagger that this method is the constructor for a
 * object return type
 * -The return type annotated with a @Provides annotation is used to associate this instantiation
 * with any other modules of the same type.
 * -See NetModule
 *
 * @Inject
 * -Use this annotation on a object to provide a way for the fields in your activities, fragments,
 * or services to be assigned references
 * -Calling inject() will cause Dagger 2 to locate the singletons in the dependency graph to try to
 * find a matching return type. If it finds one, it assigns the references to the respective fields.
 * -See below for example
 *
 * @Component
 * -Use this annotation on a interface to assigns references in our activities, services, or
 * fragments to have access to singletons we earlier defined
 * -See NetComponent
 *
 * Steps to using Dagger 2
 *      1. Add gradle dependencies
 *      2. Create your Module classes
 *          2a. Module classes must be annotated with @Module
 *          2b. Create methods in the class that return objects, these methods must be annotated with @Provides
 *      3. Create your Component class
 *          3a. This is also known as injector class, it is in charge of handing our activities
 *          references of the Modules we created
 *      4. Create an App class that extends Applications
 *          4a. Use the Component object Builder to build the Component using the Modules
 *          4b. Modify the Manifest Application name to point to the new App class
 *      5. Inside the Activity, inject the Modules using the @Inject annotation
 *          5a. Cast an Application Object to the App class created previously and use the public
 *          getter to retrieve the Component and perform a inject() on it
 */

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
