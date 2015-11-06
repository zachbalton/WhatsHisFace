package com.skylarkingstudios.whatshisface.data;

import com.orhanobut.logger.Logger;
import com.skylarkingstudios.whatshisface.data.remote.OmdbService;
import com.skylarkingstudios.whatshisface.data.remote.OmdbServiceGenerator;
import com.skylarkingstudios.whatshisface.model.Movie;

import java.util.HashMap;
import java.util.List;

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



    public HashMap<String, Integer> getCommonActors(List<String[]> actorList) {

        HashMap<String, Integer> actorFreqMap = new HashMap<>();

        for (int i = 0; i < actorList.size(); i++) {
            String cast[] = actorList.get(i);
            int castSize = actorList.get(i).length;

            // Add all actors to a HashMap with a frequency counter
            for (int j = 0; j < castSize; j++) {
                String actor = cast[j];
                Integer appearances = actorFreqMap.get(actor);
                if (appearances != null) {
                    actorFreqMap.put(actor, appearances + 1);
                } else {
                    actorFreqMap.put(actor, 1);
                }
            }
        }
        return actorFreqMap;
    }


}
