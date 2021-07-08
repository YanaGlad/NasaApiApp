package com.example.nasaappglad.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nasaappglad.R;
import com.example.nasaappglad.adapters.RoverRecyclerAdapter;
import com.example.nasaappglad.api.Api;
import com.example.nasaappglad.api.Instance;
import com.example.nasaappglad.model.Rover;
import com.example.nasaappglad.model.RoverModel;
import com.example.nasaappglad.model.Rovers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoversFragment extends Fragment {
    private ArrayList<RoverModel> roverModels = new ArrayList<>();

    public void createListOfRoverModels(ArrayList<Rover> rovers) {
        for (Rover r : rovers){
            Log.d("RoverCreatesModel", "ADDING: " + r.createRoverModel().getImg_src());
            roverModels.add(r.createRoverModel());
        }
    }


    public void loadGifs() {
        Api service = Instance.getInstance().create(Api.class);
        service.getMarsPhotos().enqueue(roverCallback);
    }

    public RoversFragment() {

    }

    private Callback<Rovers> roverCallback = new Callback<Rovers>() {
        @Override
        public void onResponse(@NonNull Call<Rovers> call, Response<Rovers> response) {
            if (response.isSuccessful()) {

                if (response.body() != null) {
                    Log.d("ResponseRovers", "Size " + response.body().getRovers().size());
                    createListOfRoverModels(response.body().getRovers());

                }
            }

            Log.d("Response callback", "RoverModels size is... " + roverModels.size());
        }

        @Override
        public void onFailure(@NonNull Call<Rovers> call, @NonNull Throwable t) {
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadGifs();
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rovers, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));


        Log.d("ON CREATE VIEW", "Size of rover models: " + roverModels.size());

        for (RoverModel rover : roverModels) {
            Log.d("RoverCreatesModel", "Src: " + rover.getImg_src());
        }


        RoverRecyclerAdapter roverRecyclerAdapter = new RoverRecyclerAdapter(getContext(), roverModels);
        recyclerView.setAdapter(roverRecyclerAdapter);
        
        return view;
    }
}