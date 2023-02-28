package com.example.moviefinder;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

public class DigimonModel {
    @SerializedName("name")
    private  String name;
    @SerializedName("level")
    private String level;
    @SerializedName("imageUrl")
    private String imageUrl;

    public DigimonModel(JSONObject responseObj){
        try{
            if (responseObj.has("name")) setName(responseObj.getString("name"));
            if (responseObj.has("level")) setLevel(responseObj.getString("level"));
            if (responseObj.has("img")) setImageUrl(responseObj.getString("img"));
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
