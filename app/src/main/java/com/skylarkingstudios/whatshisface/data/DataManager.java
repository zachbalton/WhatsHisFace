package com.skylarkingstudios.whatshisface.data;

import com.orhanobut.logger.Logger;
import com.skylarkingstudios.whatshisface.data.remote.OmdbService;
import com.skylarkingstudios.whatshisface.data.remote.OmdbServiceGenerator;
import com.skylarkingstudios.whatshisface.model.Movie;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class DataManager {

    public DataManager() {
        Logger.init();

    }

    public Movie getOmdbMovie(String title) {
        final Movie movie = new Movie();
        OmdbService omdbService = OmdbServiceGenerator.createService(OmdbService.class);
        Call<Movie> call = omdbService.getMovie(title);
        call.enqueue(new Callback<Movie>() {

            private Movie innerMovie;

            @Override
            public void onResponse(Response<Movie> response, Retrofit retrofit) {
                if (response.isSuccess() && response.body().getTitle() != null) {
                    innerMovie = response.body();
                }
                else {
                    innerMovie = null;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Logger.e("Network/Communication Error: ", t.getMessage());
                innerMovie = null;
            }

            private Callback<Movie> init(Movie movie) {
                movie = innerMovie;
                return this;
            }

        }.init(movie) );

        return movie;
    }


}
