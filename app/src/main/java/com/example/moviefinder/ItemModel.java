package com.example.moviefinder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("img")
    private String img;
    @SerializedName("drop_rate")
    private List<DropRate> dropRate = new ArrayList<>();
    public class DropRate {
        @SerializedName("monster")
        private String monster;

        @SerializedName("rate")
        private String rate;

        @SerializedName("element")
        private String element;

        public String getMonster() {
            return monster;
        }

        public void setMonster(String monster) {
            this.monster = monster;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getElement() {
            return element;
        }

        public void setElement(String element) {
            this.element = element;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<DropRate> getDropRate() {
        return dropRate;
    }

    public void setDropRate(List<DropRate> dropRate) {
        this.dropRate = dropRate;
    }
}
