package com.example.moviefinder;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaseRecyclerAdapter<M> extends RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder> {

    private List<M> mainData;
    private @LayoutRes int layoutRes;
    private BaseRecyclerAdapterListener<M> listener;

    public BaseRecyclerAdapter(List<M> mainData, int layoutRes, BaseRecyclerAdapterListener<M> listener) {
        setMainData(mainData);
        setLayoutRes(layoutRes);
        setListener(listener);
    }

    public interface BaseRecyclerAdapterListener<M>{
        void onBindView(BaseViewHolder viewHolder,M m);
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;
        private BaseRecyclerAdapterListener listener;
        public BaseViewHolder(@NonNull View itemView,BaseRecyclerAdapterListener listener) {
            super(itemView);
            this.listener=listener;
            binding= DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding(){return binding;}
    }
    @NonNull
    @Override
    public BaseRecyclerAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                getLayoutRes(),
                parent,
                false
        );
        return new BaseViewHolder(view, getListener());
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerAdapter.BaseViewHolder holder, int position) {

        M m = getMainData().get(position);
        listener.onBindView(holder,m);
    }

    @Override
    public int getItemCount() {
        return getMainData().size();
    }

    public List<M> getMainData() {
        return mainData;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMainData(List<M> mainData) {
        this.mainData = mainData;
        notifyDataSetChanged();
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public void setLayoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public BaseRecyclerAdapterListener<M> getListener() {
        return listener;
    }

    public void setListener(BaseRecyclerAdapterListener<M> listener) {
        this.listener = listener;
    }
}
