package com.example.moviefinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviefinder.databinding.ActivityApiListBinding;
import com.example.moviefinder.databinding.ItemMovieListBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiListActivity extends AppCompatActivity {

    private ActivityApiListBinding binding;
//    private final List<MovieModel> movieModelList = new ArrayList<>();
    private final List<DigimonModel> digimonModelList = new ArrayList<>();
    private BaseRecyclerAdapter<DigimonModel> movieAdapter;


    private final List<ItemModel.DropRate> dropRateModelList = new ArrayList<>();
    private BaseRecyclerAdapter<ItemModel.DropRate> dropRateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_api_list);
        dropRateAdapter = new BaseRecyclerAdapter<>(
                dropRateModelList,
                R.layout.item_movie_list,
                ((viewHolder, dropRateModel) -> {
                    ItemMovieListBinding binding = (ItemMovieListBinding) viewHolder.getBinding();
                    binding.setDropRate(dropRateModel);
                })
        );

//        binding.setMovieAdapter(movieAdapter);
        binding.setItemAdapter(dropRateAdapter);
//        callApi();
//        initApiDigimon();
        initApiItem();
    }

    private void callApi() {
        RequestQueue queue = Volley.newRequestQueue(this);
//        String title = "Avengers";
//        String apiKey = "9fdabe54";
        String url = "https://www.omdbapi.com/?t=Avengers&apikey=9fdabe54";
        String urlDigimon = "https://digimon-api.vercel.app/api/digimon";
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                urlDigimon,
                null,
                response -> {
                    try {
                        for (int i = 0; i < response.length(); i++){
                            JSONObject responseObj = response.getJSONObject(i);
                            DigimonModel movieModel = new DigimonModel(responseObj);
                            digimonModelList.add(movieModel);
                            Log.v("response",responseObj.toString());
                        }

                        movieAdapter.setMainData(digimonModelList);
                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                },
                error -> Log.v("responseError",error.toString())
        );

        queue.add(request);
    }

    private void initApiDigimon(){
        DigimonApiService service = new DigimonApiService();
        service.getDigimonModelList().enqueue(new Callback<List<DigimonModel>>() {
            @Override
            public void onResponse(Call<List<DigimonModel>> call, Response<List<DigimonModel>> response) {
                Log.v("response",String.valueOf(response.body().size()));

            }

            @Override
            public void onFailure(Call<List<DigimonModel>> call, Throwable t) {

                Log.v("error",t.getMessage());
            }
        });
    }

    private void initApiItem() {
        ItemApiService service = new ItemApiService();
        service.getItemModel().enqueue(new Callback<ItemModel>() {
            @Override
            public void onResponse(Call<ItemModel> call, Response<ItemModel> response) {
                Log.v("response",String.valueOf(response.body().getDropRate().size()));
                dropRateAdapter.setMainData(response.body().getDropRate());
            }

            @Override
            public void onFailure(Call<ItemModel> call, Throwable t) {
                Log.v("error",t.getMessage());
            }
        });



    }
}