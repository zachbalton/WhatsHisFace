package com.skylarkingstudios.whatshisface.model;

import com.google.gson.annotations.SerializedName;

// Result of OMDB API with ?s query to search for a movie
public class MovieSearch {

    @SerializedName("Search")
    private Movie[] results;

    public Movie[] getResults() {
        return results;
    }

}
