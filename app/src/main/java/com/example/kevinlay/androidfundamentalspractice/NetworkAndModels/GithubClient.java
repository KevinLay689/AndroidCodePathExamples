package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * GithubClient Interface
 * -This interface is in charge of mapping the endpoints of retrofit
 *
 * Major Takeaways
 * -Many annotations like @Path, @Query, @Body, @Header
 * -Endpoint paths are @GET @POST
 * -Add Headers above the @GET or @POST
 */

public interface GithubClient {

    @GET("/users/{user}/repos")
    Call<List<GithubRepo>> reposForUser(@Path("user") String user);


    /*
        Header request example
        Use this when you need to add a header to the request
        There is a @Headers and @Header annotation. The Headers can be used to provide pre-defined ones
     */
    @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})
    @GET("/some/endpoint")
    Call<GithubRepo> getHeader();

    /*
        Form data
        To submit form-encoded data, use the FormUrlEncoded annotation
        @Field annotation will denote what payload will be submitted as form data.
        Multipart forms are possible with @Multipart annotation
     */
    @FormUrlEncoded
    @POST("/some/endpoint")
    Call<GithubRepo> someEndpoint(@Field("code") String code);

    /*
        Form URL encoding
        Post form encoded name/value pairs use the @FormUrlEncoded and @FieldMap annotations
     */
    @FormUrlEncoded
    @POST("some/endpoint")
    Call<GithubRepo> someEndpoint(@FieldMap Map<String, String> names);




}
