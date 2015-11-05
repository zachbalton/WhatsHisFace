package com.skylarkingstudios.whatshisface.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.skylarkingstudios.whatshisface.data.DataManager;
import com.skylarkingstudios.whatshisface.model.Movie;
import com.skylarkingstudios.whatshisface.model.MovieSearch;
import com.skylarkingstudios.whatshisface.view.activity.MovieSearchActivity;

import java.util.HashMap;
import java.util.List;

public class MovieSearchModel extends BaseObservable {

    private DataManager dataManager;
    private Context context;
    private Movie movie;

    public MovieSearchModel(Context context, Movie movie) {
        this.context = context;
        this.movie = movie;
        Logger.init();
    }

    // Listeners (No 2 way binding in Android yet?)
    public View.OnClickListener onClickSearch() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the logic when search is clicked here, not activity
            }
        };
    }

    public View.OnClickListener onClickAdd() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle logic for when add is clicked here, not activity
            }
        };
    }


    public HashMap<String, Integer> findCommonActors(List<String[]> actorList) {

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
