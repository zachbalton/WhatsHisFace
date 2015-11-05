package com.skylarkingstudios.whatshisface.data.remote;

import com.skylarkingstudios.whatshisface.model.Movie;
import com.skylarkingstudios.whatshisface.model.MovieSearch;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface OmdbService {

    @GET("/")
    Call<Movie> getMovie(@Query("t") String title);

    @GET("/")
    Call<MovieSearch> searchMovie(@Query("s") String search);
}
