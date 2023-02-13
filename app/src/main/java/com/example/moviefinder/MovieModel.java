package com.example.moviefinder;

import org.json.JSONException;
import org.json.JSONObject;

public class MovieModel {

    private String Title;
    private String Year;
    private String Runtime;
    private String Director;
    private String imdbRating;
    private String Poster;
    public MovieModel(JSONObject responseObj) {
        try{
            if (responseObj.has("Title")) setTitle(responseObj.getString("Title"));
            if (responseObj.has("Year")) setTitle(responseObj.getString("Year"));
            if (responseObj.has("Runtime")) setTitle(responseObj.getString("Runtime"));
            if (responseObj.has("Director")) setTitle(responseObj.getString("Director"));
            if (responseObj.has("imdbRating")) setTitle(responseObj.getString("imdbRating"));
            if (responseObj.has("Poster")) setTitle(responseObj.getString("Poster"));
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
