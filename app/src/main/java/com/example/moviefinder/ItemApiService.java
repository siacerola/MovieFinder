package com.example.moviefinder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ItemApiService implements IItemApiService {

    private final IItemApiService apiService;

    public ItemApiService() {
        apiService = new Retrofit.Builder()
                .baseUrl("https://ragnapi.com/api/v1/re-newal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IItemApiService.class);
    }


    @Override
    public Call<ItemModel> getItemModel() {
        return apiService.getItemModel();
    }
}
