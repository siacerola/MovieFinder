package com.example.moviefinder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DigimonApiService implements IDigimonApiService{

    private final IDigimonApiService apiService;

    public DigimonApiService(){
        apiService = new Retrofit.Builder()
                .baseUrl("https://digimon-api.vercel.app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IDigimonApiService.class);
    }


    @Override
    public Call<List<DigimonModel>> getDigimonModelList() {
        return apiService.getDigimonModelList();
    }
}
