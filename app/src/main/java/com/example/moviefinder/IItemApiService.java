package com.example.moviefinder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IItemApiService {
    @GET("items/1001")
    Call<ItemModel> getItemModel();
}
