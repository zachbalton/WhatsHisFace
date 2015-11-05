package com.skylarkingstudios.whatshisface.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.skylarkingstudios.whatshisface.R;
import com.skylarkingstudios.whatshisface.model.Movie;
import com.skylarkingstudios.whatshisface.data.remote.OmdbService;
import com.skylarkingstudios.whatshisface.data.remote.OmdbServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MovieSearchActivity extends Activity {

    HashMap<String, Integer> appearanceMap;
    List<String> enteredMovies;
    List<String[]> actorList;
    ListView listView;
    EditText movieEntry;
    ArrayAdapter<String> adapter;
    TextView prompt;
    List<Movie> movies;

    String actors[];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        Logger.init();      // Don't forget these, I keep crashing without them!

        enteredMovies = new ArrayList<>();
        actorList = new ArrayList<>();
        actors = new String[4]; // Have to change if not using OMDB and API supports more actors

        movies = new ArrayList<>();

        prompt = (TextView) findViewById(R.id.enter_movie_prompt);
        prompt.setVisibility(View.VISIBLE);
        movieEntry = (EditText) findViewById(R.id.movie_entry);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, enteredMovies);
        listView = (ListView) findViewById(R.id.added_movies);
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    // Phase this out ------------------------------------------------------------------------------
    // Use an adaptive list of options returned from text input to choose from by clicking
    public void pressedAdd(View v) {

        if (!movieEntry.getText().toString().equals("")) {

            OmdbService client = OmdbServiceGenerator.createService(OmdbService.class);
            Call<Movie> call = client.getMovie(movieEntry.getText().toString());
            call.enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Response<Movie> response, Retrofit retrofit) {
                    if (response.isSuccess() && response.body().getTitle()!=null) {
                        prompt.setVisibility(View.GONE);
                        movieEntry.setText("");
                        movies.add(response.body());

                        // TODO set up MovieListFragment and create adapter to add MovieCard views to it
                        enteredMovies.add(response.body().getTitle() + " (" + response.body().getYear() + ")");

                        adapter.notifyDataSetChanged();
                    } else {
                        Logger.e("Movie not found.");
                        movieEntry.setError("Movie not found. Ensure the title is correct.");
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Logger.e("Communications Error: ", t.getMessage());
                }
            });

        } else {
            Logger.d("No text added to field");
            movieEntry.setError("Please enter a movie title");
        }
    }

    public void updateMovies(View v, Movie movie) {

    }
    //----------------------------------------------------------------------------------------------

    public void pressedSearch(View v) {
        if (enteredMovies.size() > 0) {
            if (enteredMovies.size() == 1) {
                Logger.v("Actors in " + movies.get(0).getTitle() + ": " + movies.get(0).getActors());
            } else {
                for (Movie movie : movies) {
                    actorList.add(movie.getCast());
                }
                appearanceMap = findCommonActors(actorList);
                if (appearanceMap != null) {
                    Logger.v("Actors in common: " + appearanceMap.toString());
                } else {
                    Logger.v("No actors in common among these movies");
                }
            }
        } else {
            Logger.d("No entries to search for.");
        }
    }

    // Separate from activity class if I update the design pattern
    public HashMap<String,Integer> findCommonActors(List<String[]> actorList) {

        HashMap<String, Integer> appearanceMap = new HashMap<>();

        for (int i = 0; i < actorList.size(); i++) {
            String cast[] = actorList.get(i);
            int castSize = actorList.get(i).length;

            // Add all actors to a HashMap with a frequency counter
            for (int j = 0; j < castSize; j++) {
                String actor = cast[j];
                Integer appearances = appearanceMap.get(actor);
                if (appearances != null) {
                    appearanceMap.put(actor, appearances + 1);
                } else {
                    appearanceMap.put(actor, 1);
                }
            }
        }
        return appearanceMap;
    }
}
