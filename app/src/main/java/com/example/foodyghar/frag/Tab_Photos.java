package com.example.foodyghar.frag;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.example.foodyghar.Adapter.GridViewPhotosAdapter;
import com.example.foodyghar.Adapter.Tab_photos_Gv_Adapter;
import com.example.foodyghar.Model.GetImage;
import com.example.foodyghar.Model.GetImage__1;
import com.example.foodyghar.Model.Tab_photos_model;
import com.example.foodyghar.R;
import com.example.foodyghar.ScrollableGridView;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.google.android.gms.common.api.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Tab_Photos extends Fragment {

    ScrollableGridView coursesGV;
    ArrayList<GetImage__1> getImage__1s;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_photos, null);
        progressBar = v.findViewById(R.id.progress_bar_photos);

        coursesGV = v.findViewById(R.id.idGVcourses);
        /*ArrayList<Tab_photos_model> tab_photos_modelArrayList = new ArrayList<Tab_photos_model>();
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel1));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel2));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel3));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel4));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel5));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel1));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel2));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel3));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel4));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel5));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel2));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel3));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel4));
        tab_photos_modelArrayList.add(new Tab_photos_model(R.drawable.hotel5));
*/
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String hotel_id = sharedPreferences.getString("hotel_id", "");
        Log.e("HOTEL_ID", hotel_id);

        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<GetImage> getImageCall = apInterface.getAllImage(hotel_id);
        getImageCall.enqueue(new Callback<GetImage>() {
            @Override
            public void onResponse(Call<GetImage> call, Response<GetImage> response) {
                try {
                    getImage__1s = (ArrayList<GetImage__1>) response.body().getGetImages();
                    GridViewPhotosAdapter tab_photos_gv_Adapter = new GridViewPhotosAdapter(getActivity(), getImage__1s, progressBar);
                    coursesGV.setAdapter(tab_photos_gv_Adapter);
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetImage> call, Throwable t) {

            }
        });
        return v;
    }
}