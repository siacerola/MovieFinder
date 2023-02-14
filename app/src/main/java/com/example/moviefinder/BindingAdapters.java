package com.example.moviefinder;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BindingAdapters {

    @BindingAdapter("app:setAdapter")
    public static void setAdapter(RecyclerView recyclerView, BaseRecyclerAdapter adapter){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

}
