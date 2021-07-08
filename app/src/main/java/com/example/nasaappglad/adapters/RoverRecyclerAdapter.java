package com.example.nasaappglad.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nasaappglad.R;
import com.example.nasaappglad.model.RoverModel;

import java.util.ArrayList;
import java.util.List;

public class RoverRecyclerAdapter extends RecyclerView.Adapter<RoverViewHolder> {
    Context context;
    List<RoverModel> roverModels;

    public RoverRecyclerAdapter(Context context, ArrayList<RoverModel> roverModels) {
        Log.d("RoverAdapter","ADAPTER");

        this.context = context;
        this.roverModels = roverModels;
     }

    @NonNull
    @Override
    public RoverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rover_item, parent, false);
        return new RoverViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoverViewHolder holder, int position) {
        RoverModel roverModel = roverModels.get(position);
        Log.d("AdapterBinding", roverModel.getImg_src());
        holder.loadImage(roverModel.getImg_src());

    }

    @Override
    public int getItemCount() {
        return roverModels.size();
    }
}