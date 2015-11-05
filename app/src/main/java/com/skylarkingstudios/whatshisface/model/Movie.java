package com.skylarkingstudios.whatshisface.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    // Using OMDB SerializedNames retrieved from their API's JSON output
    @SerializedName("Title")
    private String title;

    @SerializedName("Actors")
    private String actors;

    @SerializedName("Year")
    private String year;

    @SerializedName("Poster")
    private String poster;

    @SerializedName("Plot")
    private String plot;

    private String cast[];


    public String getTitle() {
        return title;
    }

    public String getActors() {
        return actors;
    }

    public String getYear() {
        return year;
    }

    public String[] getCast() {
        cast = actors.split(",\\s");
        return cast;
    }

    public String getPoster() {
        return poster;
    }

    public String getPlot() {
        return plot;
    }
}
