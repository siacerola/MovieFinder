package com.example.moviefinder;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieModel {

    private String Title;
    private String Year;
    private String Runtime;
    private String Director;
    private String Plot;
    private String imdbRating;
    private String Poster;
    public MovieModel(JSONObject responseObj) {
        try{
            if (responseObj.has("Title")) setTitle(responseObj.getString("Title"));
            if (responseObj.has("Year")) setYear(responseObj.getString("Year"));
            if (responseObj.has("Runtime")) setRuntime(responseObj.getString("Runtime"));
            if (responseObj.has("Director")) setDirector(responseObj.getString("Director"));
            if (responseObj.has("Plot")) setPlot(responseObj.getString("Plot"));
            if (responseObj.has("imdbRating")) setImdbRating(responseObj.getString("imdbRating"));
            if (responseObj.has("Poster")) setPoster(responseObj.getString("Poster"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        this.Runtime = runtime;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        this.Director = director;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        this.Plot = plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }
}
