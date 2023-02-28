package com.example.moviefinder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDigimonApiService {

    @GET("digimon")
    Call<List<DigimonModel>>  getDigimonModelList();
}
