package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kevinlay on 1/8/18.
 */

public interface MovieClient {
//    @GET("/movie/upcoming?api_key={apiKey}&language=en-US&page=1/")
//    Call<List<MovieModel>> getRecentMovies(@Path("apiKey") String apiKey);

    @GET("/3/movie/upcoming")
    Call<MovieModel> getRecentMovies(@Query("api_key") String apiKey);
}
